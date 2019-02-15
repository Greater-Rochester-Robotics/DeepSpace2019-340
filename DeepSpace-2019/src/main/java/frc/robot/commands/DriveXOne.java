/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI.Axis;

/**
 * Drives the robot via Arcade Drive on
 * the driver's Xbox ONE controller
 */
public class DriveXOne extends Command {

	/**
	 * Continuously drive the robot via Arcade Drive
	 */
	public DriveXOne() {
		requires(Robot.drive);
	}

	@Override
	protected void execute() {
		Robot.drive.arcadeDrive(Robot.oi.getCoDriverAxis(Axis.LEFT_Y), Robot.oi.getCoDriverAxis(Axis.LEFT_X)); //Poll driver's left axes to drive
	}

	@Override
	protected boolean isFinished() {
		return false; //Never finish. There's no reason to
	}

	@Override
	protected void end() {
		Robot.drive.setDriveBoth(0); //Stop moving if this command ends for some reason (e.g. interrupt for climb)
	}
}
