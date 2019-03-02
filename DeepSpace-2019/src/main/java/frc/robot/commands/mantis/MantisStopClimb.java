/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.mantis;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

import static frc.robot.Robot.mantis;
import static frc.robot.Robot.elevator;

public class MantisStopClimb extends Command {
	public MantisStopClimb() {
		requires(mantis);
		requires(elevator);
	}

	/**
	 * Stop arms and return stinger
	 */
	@Override
	protected void initialize() {
		mantis.setArmSpeed(RobotMap.ZERO_SPEED);
		elevator.engageBrake();
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
