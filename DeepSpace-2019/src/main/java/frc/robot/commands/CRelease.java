/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Use the C to release/fire cargo<br>
 * It's not impossible to imagine this will have some PID at some point
 */
public class CRelease extends Command {
	
	/**
	 * Step 1: take the C<br>
	 * Step 2: release
	 */
	public CRelease() {
		requires(Robot.c);
	}

	@Override
	protected void initialize() {
		Robot.c.setSpeed(-1); //Roll wheels outward the instant this command begins
	}

	@Override
	protected boolean isFinished() {
		return !Robot.c.hasCargo(); //Continue rolling until interrupt or cargo acquisition
	}

	@Override
	protected void end() {
		Robot.c.setSpeed(0); //On interrupt or cargo acquisition, stop the wheels
	}
}
