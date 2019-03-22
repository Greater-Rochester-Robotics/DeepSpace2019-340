/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//Can we clean these up?
import com.revrobotics.CANSparkMax;
import com.revrobotics.ControlType;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;
import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorStick;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

/**
 * <h1>Elevator</h1>
 * Moves the claw and hatch mechanism up and down.<br>
 * Programmed assuming TalonSR and encoder; subject to change<br>
 * <br>
 * Always uses the Xbox ONE controller unless told otherwise
 * 
 * TODO: make this <i>much</i> more sophisticated
 */
public class Elevator extends Subsystem {
	private static Solenoid discBrake; //True moving, false stopping
	private static DoubleSolenoid tilt;
	private static CANSparkMax elevatorA, elevatorC; //B decommissioned
	private static CANDigitalInput elevatorBottomLimit;
	private static CANEncoder enc;

	// kP = ((maxSpeed) / (maxPosition * %from max position to start slowing down))
	// kI ~ kP * 0.01
	private static double kP = (RobotMap.ELEVATOR_SPEED_MULTIPLIER / (RobotMap.ELEVATOR_MAX_HEIGHT * 0.2));
	// private static double kI = kP * 0.01;

	private static CANPIDController pidControllerA;
	// private static CANPIDController pidControllerB;
	// private static CANPIDController pidControllerC;

	@Deprecated private double offset = 0; //Adjusts for encoder drift

	/**
	 * Makes the ports given the not-so-magic
	 * numbers in robotmap
	 */
	public Elevator() {
		tilt = new DoubleSolenoid(RobotMap.ELEVATOR_TILT_SOLENOID_FORWARD_CHANNEL, RobotMap.ELEVATOR_TILT_SOLENOID_BACKWARD_CHANNEL);
		discBrake = new Solenoid(RobotMap.DISC_BRAKE_SOLENOID_RELEASE_CHANNEL);
		elevatorA = new CANSparkMax(RobotMap.ELEVATOR_A_MOTOR_CAN_ID, MotorType.kBrushless);
		// elevatorB = new CANSparkMax(RobotMap.ELEVATOR_B_MOTOR_CAN_ID, MotorType.kBrushless);
		elevatorC = new CANSparkMax(RobotMap.ELEVATOR_C_MOTOR_CAN_ID, MotorType.kBrushless);

		elevatorA.restoreFactoryDefaults();
		// elevatorB.restoreFactoryDefaults();
		elevatorC.restoreFactoryDefaults();

		elevatorBottomLimit = elevatorA.getForwardLimitSwitch(LimitSwitchPolarity.kNormallyOpen); //Faux reverse limit... Will we use it?
		elevatorBottomLimit.enableLimitSwitch(true);
		enc = elevatorA.getEncoder();
		
		//Enslave motor C (and formerly B) to motor A
		// elevatorB.follow(elevatorA);
		elevatorC.follow(elevatorA);

		//Invert direction
		elevatorA.setInverted(true);

		pidControllerA = elevatorA.getPIDController();
		pidControllerA.setP(kP);
		// pidControllerA.setI(kI);
		// pidControllerB = elevatorB.getPIDController();
		// pidControllerB.setP(kP);
		// pidControllerB.setI(kI);
		// pidControllerC = elevatorC.getPIDController();
		// pidControllerC.setP(kP);
		// pidControllerC.setI(kI);
		// pidController.setReference(1, ControlType.kPosition);
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ElevatorStick());
	}
	
	/**
	 * @return the current offset. Duh.
	 */
	@Deprecated
	public double getEncoderOffset() {
		return offset;
	}

	/**
	 * This just gets run over and over and over again<br>
	 * <br>
	 * <i>We don't need to worry about deadzones; that's implemented in OI</i>
	 * @param spd new speed; positive = up
	 */
	public void setSpeed(double spd) {

		//Jeremiah doesn't like this here but John put his foot down, so here it will stay...
		if(isAtBottom()) {
			resetEncoder();
		}

		//Cut motor if robot is too high up
		//The Spark Mins (hah) can't do it themselves
		if(enc.getPosition() >= RobotMap.ELEVATOR_MAX_HEIGHT && spd > 0) {
			spd = RobotMap.ZERO_SPEED;
		}

		//Drive down no faster than 55%
		if(spd < -.55) {
			spd = -.55;
		}

		if(spd == RobotMap.ZERO_SPEED) {
			discBrake.set(false); //Brake the disk
		} else {
			discBrake.set(true); //Let it slide
		}

		elevatorA.set(spd);
	}

	/**
	 * Set the elevator to move up or down based on
	 *  the given speed param. This function contains
	 *  a deadzone feature to compensate for an
	 *  uncentered joystick axis, and those ignored
	 *  values would not really drive the elevator up
	 *  or down. This function also limits the top
	 *  speed of the elevator based on its position.
	 * @param speed
	 */
	public void setSpeedScaled(double speed) {
		
		//Slows the elevator down before it breaks everything.
		//Deadzones don't need to be here but whatever
		if(speed < -0.05) {
			if(getRawPos() < RobotMap.ELEVATOR_BOTTOM_LOWER_SLOW) {
				speed *= 0.1;
			} else if(getRawPos() < RobotMap.ELEVATOR_BOTTOM_UPPER_SLOW) {
				speed *= 0.3;
			}
		} else if(speed > 0.05) {
			if(getRawPos() > RobotMap.ELEVATOR_TOP_UPPER_SLOW) {
				speed = 0.05;
			} else if(getRawPos() > RobotMap.ELEVATOR_TOP_LOWER_SLOW) {
				speed *= 0.25;
			}
		} else {
			speed = RobotMap.ZERO_SPEED;
		}

		setSpeed(speed);
	}

	/**
	 * Set the pidcontroller on the elevator to basic 
	 *  precent voltage control mode, set motors for 
	 *  the elevator to an output of zero. and engage 
	 *  the brake. The goal is to stop the elevator in place.
	 */
	public void stop() {
		pidControllerA.setReference(0, ControlType.kDutyCycle);
		discBrake.set(false);
		elevatorA.stopMotor();
	}

	/**
	 * Function to release the brake annd allow 
	 *  the elevator to move. This should be a 
	 *  true to a signle action pneumatic solenoid 
	 *  valve.
	 */
	public void disengageBrake() {
		discBrake.set(true);
	}

	/**
	 * Function to engage the elevator brake, 
	 *  this should be a false to a single action 
	 *  pneumatic solenoid valve.
	 */
	public void engageBrake() {
		discBrake.set(false);
	}

	/**
	 * @return the elevator's height traveled, offset included, based on motor rotations
	 * FIXME: check if we have to <i>adjust</i> or <i>redefine</i> the offset
	 */
	@Deprecated
	public double getPos() {
		return offset - enc.getPosition(); //Equivalent of -(enc - offset); negative on account of sign
	}

	/**
	 * @return raw encoder output, in motor rotations
	 */
	public double getRawPos() {
		return enc.getPosition();
	}
	/**
	 * @return the current speed of the winch
	 */
	public double getSpeed() {
		return elevatorA.get();
	}

	/**
	 * @return the value of the forward solenoid
	 */
	public boolean isTiltedForward() {
		return tilt.get().equals(Value.kForward);
	}

	/**
	 *  Tilts the Elevator forward
	 */
	public void tiltForward() {
		tilt.set(Value.kForward);
	}

	/**
	 *  Tilts the Elevator backward
	 */
	public void tiltBackward() {
		tilt.set(Value.kReverse);
	}

	/**
	 * Use PID to set the elevator to a given position<br>
	 * This is like 98% certain to completely fail,
	 * and 1% certain to succeed with nasty side effects
	 * @param pos height to go to, in motor rotations
	 */
	public void goToPos(double pos) {
		pidControllerA.setP((RobotMap.ELEVATOR_SPEED_MULTIPLIER / (pos * 0.15)));
		// pidControllerA.setI(pidControllerA.getP() * .01);

		discBrake.set(true);

		pidControllerA.setReference(pos, ControlType.kPosition);
		// pidControllerB.setReference(pos, ControlType.kPosition);
		// pidControllerC.setReference(pos, ControlType.kPosition);
	}

	/**
	 * Adjust encoder offset to set current output to """zero"""
	 */
	public void resetEncoder() {		
		// offset = enc.getPosition();
		elevatorA.setEncPosition(0);
		// elevatorA.setParameter(ConfigParameter.kSoftLimitRevEn, offset - RobotMap.ELEVATOR_MAX_DELTA_HEIGHT);
		// System.out.println(" kSoftLimitRevEn " + (offset - RobotMap.ELEVATOR_MAX_DELTA_HEIGHT));
	}

	/**
	 * @return {@code true} if elevator is triggering bottom DI
	 */
	public boolean isAtBottom() {
		return elevatorBottomLimit.get();
	}

	/**
	 * @return {@code true} if the elevator is at least at its
	 * max height. The encoder returns motor rotations, but this
	 * value is scaled via the MAX to centimeters. Hopefully.
	 * TODO: check if we might as well just use revolutions
	 */
	public boolean isAtTop() {
		return getPos() >= RobotMap.ELEVATOR_MAX_HEIGHT;
	}
}
