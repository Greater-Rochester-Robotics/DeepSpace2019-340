/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//Can we clean these up?
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.ConfigParameter;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorStick;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * <h1>Elevator</h1>
 * Moves the claw and hatchy-boi up and down.<br>
 * Programmed assuming TalonSR and encoder; subject to change<br>
 * <br>
 * Always uses the Xbox ONE controller unless told otherwise
 * 
 * TODO: make this <i>much</i> more sophisticated
 */
public class Elevator extends Subsystem {
	
	private static Solenoid tiltForward, tiltBackward, discBrake;
	private static CANSparkMax elevatorA, elevatorB, elevatorC;
	private static DigitalInput reverseLimit;
	private static CANEncoder enc;

	private double offset = 0; //Adjusts for encoder drift

	/**
	 * Makes the ports given the not-so-magic
	 * numbers in robotmap
	 */
	public Elevator() {
		tiltForward = new Solenoid(RobotMap.ELEVATOR_TILT_SOLENOID_FORWARD_CHANNEL);
		tiltBackward = new Solenoid(RobotMap.ELEVATOR_TILT_SOLENOID_BACKWARD_CHANNEL);
		discBrake = new Solenoid(RobotMap.DISC_BRAKE_SOLENOID_RELEASE_CHANNEL);
		elevatorA = new CANSparkMax(RobotMap.ELEVATOR_A_MOTOR_CAN_ID, MotorType.kBrushless);
		elevatorB = new CANSparkMax(RobotMap.ELEVATOR_B_MOTOR_CAN_ID, MotorType.kBrushless);
		elevatorC = new CANSparkMax(RobotMap.ELEVATOR_C_MOTOR_CAN_ID, MotorType.kBrushless);
		reverseLimit = new DigitalInput(RobotMap.ELEVATOR_BOTTOM_SENSOR_PORT); //Explain? TODO: check normal state
		enc = elevatorA.getEncoder(); //FIXME: adjust for gearing

		//Enslave motors B and C to motor A
		elevatorB.follow(elevatorA);
		elevatorC.follow(elevatorA);
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ElevatorStick());
	}

	/**
	 * This just gets run over and over and over again<br>
	 * <br>
	 * <i>We don't need to worry about deadzones; that's implemented in OI</i>
	 * @param spd new speed; positive = up
	 */
	public void setSpeed(double spd) {
		if(isAtBottom() && spd < RobotMap.ZERO_SPEED) {
			spd = RobotMap.ZERO_SPEED;
		} else if(isAtTop() && spd > RobotMap.ZERO_SPEED) {
			spd = RobotMap.ZERO_SPEED;
		}

		if(spd == RobotMap.ZERO_SPEED) {
			discBrake.set(true); //Brake the disk
		} else {
			discBrake.set(false); //Let it slide
		}
		
		elevatorA.set(spd);
	}

	/**
	 * @return the robot's distance traveled, offset included
	 * FIXME: adjust for gearing via {@link ConfigParameter#kEncoderCountsPerRev}
	 */
	public double getPos() {
		return enc.getPosition() - offset;
	}

	/**
	 * @return the current speed of the winch
	 */
	public double getSpeed() {
		return elevatorA.get();
	}

	/**
	 * 
	 * @return the value of the forward solenoid
	 */
	public boolean getTiltForward(){
		return tiltForward.get();
	}

	/**
	 * 
	 * @return the value of the backward solenoid
	 */
	public boolean getTiltBackward(){
		return tiltBackward.get();
	}

	/**
	 *  Tilts the Elevator forward
	 */
	public void tiltForward() {
		tiltForward.set(true);
		tiltBackward.set(false);
	}

	/**
	 *  Tilts the Elevator backward
	 */
	public void tiltBackward() {
		tiltForward.set(false);
		tiltBackward.set(true);
	}

	/**
	 * Adjust encoder offset to set current output to """zero"""
	 */
	public void resetEncoder() {
		offset += enc.getPosition();
	}

	/**
	 * @return {@code true} if elevator is triggering bottom DI
	 */
	public boolean isAtBottom() {
		return reverseLimit.get();
	}

	/**
	 * @return {@code true} if the elevator is at least at its
	 * max height. The encoder returns motor rotations, but this
	 * value is scaled via the MAX to centimeters. Hopefully.
	 */
	public boolean isAtTop() {
		return getPos() >= RobotMap.ELEVATOR_MAX_HEIGHT_CM;
	}
}
