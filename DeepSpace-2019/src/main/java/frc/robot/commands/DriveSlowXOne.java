/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.OI.Axis;

public class DriveSlowXOne extends Command {
	public DriveSlowXOne() {
		requires(Robot.drive);
	}
	
	/**
	 * Repeatedly arcade drive
	 */
	@Override
	protected void execute() {
		Robot.drive.arcadeDrive(Robot.oi.getDriverAxis(Axis.LEFT_Y) / 2, Robot.oi.getDriverAxis(Axis.LEFT_X) / 2);
	}

	//Never finish
	@Override
	protected boolean isFinished() {
		return false;
	}

	/**
	 * Kill drive on end
	 */
	@Override
	protected void end() {
		Robot.drive.setDriveBoth(RobotMap.ZERO_SPEED);
	}
}
