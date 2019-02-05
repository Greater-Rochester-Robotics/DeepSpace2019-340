/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANDigitalInput.LimitSwitchPolarity;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorStick;
import edu.wpi.first.wpilibj.Solenoid;
import com.revrobotics.*;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;


/**
 * <h1>Elevator</h1>
 * Moves the claw and hatchy-boi up and down.<br>
 * Programmed assuming TalonSR and encoder; subject to change<br>
 * <br>
 * Always uses the Xbox ONE controller unless told otherwise
 */
public class Elevator extends Subsystem {
	private static Encoder enc;
	private static Talon winch;
	private static Solenoid leftTilt, rightTilt;
	private static CANSparkMax elevatorA, elevatorB, elevatorC;
	private static CANDigitalInput reverseLimit;
	/**
	 * Makes the ports given the not-so-magic
	 * numbers in robotmap
	 */
	public Elevator() {
		enc = new Encoder(RobotMap.ELEVATOR_ENCODER_CHANNEL_A, RobotMap.ELEVATOR_ENCODER_CHANNEL_B);
		winch = new Talon(RobotMap.ELEVATOR_TALON_CHANNEL);
		leftTilt = new Solenoid(RobotMap.ELEVATOR_SOLENOID_LEFT);
		rightTilt = new Solenoid(RobotMap.ELEVATOR_SOLENOID_RIGHT);
		elevatorA = new CANSparkMax(RobotMap.ELEVATOR_A_MOTOR_CAN_ID, MotorType.kBrushless);
		elevatorB = new CANSparkMax(RobotMap.ELEVATOR_B_MOTOR_CAN_ID, MotorType.kBrushless);
		elevatorC = new CANSparkMax(RobotMap.ELEVATOR_C_MOTOR_CAN_ID, MotorType.kBrushless);
		reverseLimit = elevatorA.getReverseLimitSwitch(LimitSwitchPolarity.kNormallyClosed);

		elevatorB.follow(elevatorA);
		elevatorC.follow(elevatorA);

		reverseLimit.enableLimitSwitch(true);
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
		winch.set(spd);
	}

	/**
	 * @return the robot's distance traveled
	 */
	public double getPos() {
		return enc.getDistance();
	}

	/**
	 * @return the current speed of the winch
	 */
	public double getSpeed() {
		return winch.get();
	}

	/**
	 *  Tilts the Elevator forward
	 */
	public void tiltForward(){
		leftTilt.set(true);
		rightTilt.set(true);
	}

	/**
	 *  Tilts the Elevator backward
	 */
	public void tiltBackward(){
		leftTilt.set(false);
		rightTilt.set(false);
	}

}
