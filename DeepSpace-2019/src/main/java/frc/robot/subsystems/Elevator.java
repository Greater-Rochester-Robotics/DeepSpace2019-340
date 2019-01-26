/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.ElevatorStick;

/**
 * <h1>Elevator</h1>
 * Moves the claw and hatchy-boi up and down.<br>
 * Programmed assuming TalonSR and Encoder
 */
public class Elevator extends Subsystem {
	private static Talon winch;
	private static Encoder enc;

	/**
	 * Makes the ports given the not-so-magic
	 * numbers in robotmap
	 */
	public Elevator() {
		winch = new Talon(RobotMap.ELEVATOR_TALON_CHANNEL);
		enc = new Encoder(RobotMap.ELEVATOR_ENCODER_CHANNEL_A, RobotMap.ELEVATOR_ENCODER_CHANNEL_B);
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

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new ElevatorStick());
	}
}
