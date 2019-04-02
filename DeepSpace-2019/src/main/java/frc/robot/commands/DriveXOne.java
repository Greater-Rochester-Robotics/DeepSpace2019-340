/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
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

	/**
	 * Left for full speed, right stick slow stick
	 */
	@Override
	protected void execute() {
		// Robot.drive.arcadeDrive(Robot.oi.getDriverAxis(Axis.LEFT_Y), Robot.oi.getDriverAxis(Axis.LEFT_X)); //Poll driver's left axes to drive

		//Dual-stick code from 2018 PowerUp
		//Gives precedence to LS, runs slower RS otherwise
		if(Math.abs(Robot.oi.getDriverAxis(Axis.LEFT_X)) >= .05 ||
			Math.abs(Robot.oi.getDriverAxis(Axis.LEFT_Y)) >= .05) {
				Robot.drive.arcadeDrive(Robot.oi.getDriverAxis(Axis.LEFT_Y)*.65, Robot.oi.getDriverAxis(Axis.LEFT_X)*.7569);
		} else if(Math.abs(Robot.oi.getDriverAxis(Axis.RIGHT_X)) >= .15 ||
			Math.abs(Robot.oi.getDriverAxis(Axis.RIGHT_Y)) >= .15) {
				Robot.drive.arcadeDrive(Robot.oi.getDriverAxis(Axis.RIGHT_Y)*.3, Robot.oi.getDriverAxis(Axis.RIGHT_X)*.45);
		} else {
			Robot.drive.setDriveBoth(0);
		}

		// System.out.println(Robot.drive.getRotation());
	}

	@Override
	protected boolean isFinished() {
		return false; //Never finish. There's no reason to
	}

	@Override
	protected void end() {
		Robot.drive.setDriveBoth(RobotMap.ZERO_SPEED); //Stop moving if this command ends for some reason (e.g. interrupt for climb)
	}
}
