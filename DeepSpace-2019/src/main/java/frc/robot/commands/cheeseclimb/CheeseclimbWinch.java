/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.cheeseclimb;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.cheeseclimber;

/**
 * Set the Cheeseclimber's winch to tilt the robot. This command ends
 * immediately, leaving the tilt in progress
 */
public class CheeseclimbWinch extends Command {
	private double speed;

	/**
	 * @param speed winch percent VBus; positive tilts robot up
	 */
	public CheeseclimbWinch(double speed) {
		requires(cheeseclimber);
		this.speed = speed;
	}

	/**
	 * Start actuating the winch, and don't stop
	 */
	@Override
	protected void initialize() {
		cheeseclimber.setWinch(speed);
	}

	/**
	 * Be done immediately
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}
}
