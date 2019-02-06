/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

//Can we clean these up?
import com.revrobotics.CANSparkMax;
import com.revrobotics.CANDigitalInput;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorStick;
import edu.wpi.first.wpilibj.Solenoid;

/**
 * <h1>Elevator</h1>
 * Moves the claw and hatchy-boi up and down.<br>
 * Programmed assuming TalonSR and encoder; subject to change<br>
 * <br>
 * Always uses the Xbox ONE controller unless told otherwise
 */
public class Elevator extends Subsystem {
	
	private static Solenoid tiltForward, tiltBackward;
	private static CANSparkMax elevatorA, elevatorB, elevatorC;
	private static CANDigitalInput reverseLimit;
	private static CANEncoder elevatorAEncoder; 

	/**
	 * Makes the ports given the not-so-magic
	 * numbers in robotmap
	 */
	public Elevator() {
		tiltForward = new Solenoid(RobotMap.ELEVATOR_TILT_SOLENOID_FORWARD_CHANNEL);
		tiltBackward = new Solenoid(RobotMap.ELEVATOR_TILT_SOLENOID_BACKWARD_CHANNEL);
		elevatorA = new CANSparkMax(RobotMap.ELEVATOR_A_MOTOR_CAN_ID, MotorType.kBrushless);
		elevatorB = new CANSparkMax(RobotMap.ELEVATOR_B_MOTOR_CAN_ID, MotorType.kBrushless);
		elevatorC = new CANSparkMax(RobotMap.ELEVATOR_C_MOTOR_CAN_ID, MotorType.kBrushless);
		reverseLimit = elevatorA.getReverseLimitSwitch(CANDigitalInput.LimitSwitchPolarity.kNormallyClosed); //Explain?
		elevatorAEncoder = elevatorA.getEncoder(); //FIXME: adjust for gearing

		//Enslave motors B and C to motor A
		elevatorB.follow(elevatorA);
		elevatorC.follow(elevatorA);

		reverseLimit.enableLimitSwitch(true); //Does this add a top soft limit?
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ElevatorStick());
	}

	/**
	 * This just gets run over and over and over again
	 * @param spd new speed; positive = up
	 */
	public void setSpeed(double spd) {
		elevatorA.set(spd);
	}

	/**
	 * @return the robot's distance traveled
	 * FIXME: adjust for gearing
	 */
	public double getPos() {
		return elevatorAEncoder.getPosition();
	}

	/**
	 * @return the current speed of the winch
	 */
	public double getSpeed() {
		return elevatorA.get();
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
}
