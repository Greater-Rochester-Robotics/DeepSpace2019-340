/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.manipulatorWithKaChunker;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.manipulatorWithKaChunker;

public class KaChunkerAutoHandler extends Command {
	public KaChunkerAutoHandler() {
		requires(manipulatorWithKaChunker);
	}

	@Override
	protected void initialize() {
		manipulatorWithKaChunker.setKachunkerDrop();
		setTimeout(.15); //When trying to drop a hatch, give the machine .15 seconds to finish dropping
	}

	@Override
	protected boolean isFinished() {
		return manipulatorWithKaChunker.hasHatch() && isTimedOut();
	}

	@Override
	protected void end() {
		manipulatorWithKaChunker.setKachunkerGrab();
	}
}
