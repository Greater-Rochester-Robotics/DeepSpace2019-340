/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.manipulatorWithKaChunker;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

import static frc.robot.Robot.manipulatorWithKaChunker;

public class CShipRelease extends Command {

	/**
	 * Step 1: take the C<br>
	 * Step 2: tilt it down-ish<br>
	 * Step 3: release<br>
	 * Step 4: stop release
	 */
	public CShipRelease() {
		requires(manipulatorWithKaChunker);
	}

	@Override
	protected void initialize() {
		if(!manipulatorWithKaChunker.isWristDown()) {
			manipulatorWithKaChunker.setWristDown();
			setTimeout(RobotMap.WRIST_TILT_DOWN_TIME_S);
		} else {
			setTimeout(0);
		}
	}

	@Override
	protected void execute() {
		if(isTimedOut()) {
			manipulatorWithKaChunker.setCSpeed(RobotMap.C_OUTTAKE_SPEED);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		manipulatorWithKaChunker.setCSpeed(RobotMap.ZERO_SPEED);
	}
}
