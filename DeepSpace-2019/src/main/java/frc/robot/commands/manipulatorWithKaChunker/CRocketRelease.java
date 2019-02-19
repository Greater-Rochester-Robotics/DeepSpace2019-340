/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.manipulatorWithKaChunker;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

import static frc.robot.Robot.manipulatorWithKaChunker;

/**
 * Use the C to release/fire cargo<br>
 * It's not impossible to imagine this will have some PID at some point
 */
public class CRocketRelease extends Command {
	
	/**
	 * Step 1: take the C<br>
	 * Step 2: release<br>
	 * Step 3: stop release
	 */
	public CRocketRelease() {
		requires(manipulatorWithKaChunker);
	}

	@Override
	protected void initialize() {
		if(manipulatorWithKaChunker.isWristDown()) {
			manipulatorWithKaChunker.setWristUp();
			setTimeout(RobotMap.WRIST_TILT_UP_TIME_S);
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
		return false; //Continue rolling until interrupt
	}

	@Override
	protected void end() {
		Robot.manipulatorWithKaChunker.setCSpeed(RobotMap.ZERO_SPEED); //On interrupt or cargo acquisition, stop the wheels
	}
}
