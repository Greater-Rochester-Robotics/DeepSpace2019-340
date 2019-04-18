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
 * Stops the Cheeseclimber's winch/angling
 */
public class CheeseclimbStopWinch extends Command {
	public CheeseclimbStopWinch() {
		requires(cheeseclimber);
	}

	/**
	 * End winch motion
	 */
	@Override
	protected void initialize() {
		cheeseclimber.stopWinch();
	}

	/**
	 * Be done immediately
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}
}
