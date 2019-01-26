/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class CRelease extends Command {
	public CRelease() {
		requires(Robot.c);
	}

	@Override
	protected void initialize() {
		Robot.c.setSpeed(-1);
	}

	@Override
	protected boolean isFinished() {
		return !Robot.c.hasCargo();
	}

	@Override
	protected void end() {
		Robot.c.setSpeed(0);
	}
}
