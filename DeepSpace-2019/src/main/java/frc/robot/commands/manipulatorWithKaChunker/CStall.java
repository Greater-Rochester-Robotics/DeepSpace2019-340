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

public class CStall extends Command {
	public CStall() {
		requires(manipulatorWithKaChunker);
	}

	@Override
	protected void initialize() {
		if(manipulatorWithKaChunker.hasCargo()) {
			manipulatorWithKaChunker.setCSpeed(RobotMap.C_STALL_SPEED, true); //Stall, but only if we have cargo
		} else {
			manipulatorWithKaChunker.setCSpeed(RobotMap.ZERO_SPEED, false); //Cut speed to C
		}
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
