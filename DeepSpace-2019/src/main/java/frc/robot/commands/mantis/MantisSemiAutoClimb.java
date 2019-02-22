/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.mantis;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.mantis;
import frc.robot.RobotMap;
import static frc.robot.Robot.manipulatorWithKaChunker;

/**
 * TODO: add elevator height for climbing<br>
 * Might need to move this to a commandgroup?
 */
public class MantisSemiAutoClimb extends Command {
	private boolean flag = false;

	public MantisSemiAutoClimb() {
		requires(mantis);
		requires(manipulatorWithKaChunker);
	}

	@Override
	protected void initialize() {
		mantis.setArmSpeed(RobotMap.MANTIS_ARM_DOWN_SPEED);
		manipulatorWithKaChunker.setWristUp();
		setTimeout(1.7);
	}

	@Override
	protected void execute() {
		if(isTimedOut()) {
			mantis.setStinger(true);
			flag = true;
		}
	}

	@Override
	protected boolean isFinished() {
		return flag;
	}
}