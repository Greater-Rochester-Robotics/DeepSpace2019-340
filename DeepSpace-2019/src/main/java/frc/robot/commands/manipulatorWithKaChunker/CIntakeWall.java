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

public class CIntakeWall extends Command {

	/**
	 * Step 1: intake
	 * Step 2: stop intaking when sensors get vv upset
	 */
	public CIntakeWall() {
		requires(manipulatorWithKaChunker);
	}

	@Override
	protected void initialize() {
		manipulatorWithKaChunker.setWristUp();
		manipulatorWithKaChunker.setCSpeed(RobotMap.C_INTAKE_SPEED);
	}

	//Will this work? :thonk:
	@Override
	protected void execute() {
		if(manipulatorWithKaChunker.hasCargo()) {
			setTimeout(.05 + timeSinceInitialized());
		}
	}

	@Override
	protected boolean isFinished() {
		return manipulatorWithKaChunker.hasCargo() && isTimedOut();
	}

	@Override
	protected void end() {
		manipulatorWithKaChunker.setCSpeed(RobotMap.ZERO_SPEED);
	}
}
