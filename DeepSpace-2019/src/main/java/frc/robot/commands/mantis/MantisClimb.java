/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.mantis;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

import static frc.robot.Robot.mantis;

public class MantisClimb extends Command {
	public MantisClimb() {
		requires(mantis);
	}

	@Override
	protected void initialize() {
		mantis.setStinger(true); //fire stinger
	}

	@Override
	protected void execute() {
		mantis.setArmSpeed(RobotMap.MANTIS_ARM_DOWN_SPEED); //start raising the front, too
	}

	@Override
	protected boolean isFinished() {
		return Robot.isBackHigh() && Robot.isFrontHigh() && mantis.isDown(); //Up AND flush w/ hab3
	}

	@Override
	protected void end() {
		mantis.setStinger(false);
		mantis.setArmSpeed(RobotMap.ZERO_SPEED);
	}

	@Override
	protected void interrupted() {
		mantis.setArmSpeed(RobotMap.ZERO_SPEED);
	}
}
