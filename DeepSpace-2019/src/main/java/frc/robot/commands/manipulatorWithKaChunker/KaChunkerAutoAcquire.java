/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.manipulatorWithKaChunker;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.manipulatorWithKaChunker;

public class KaChunkerAutoAcquire extends Command {

	/**
	 * Handles the ka-chunker with masterful accuracy. Maybe.
	 */
	public KaChunkerAutoAcquire() {
		requires(manipulatorWithKaChunker);
	}

	@Override
	protected void initialize() {
		manipulatorWithKaChunker.setWristDown();
		manipulatorWithKaChunker.setKachunkerDrop();
	}

	/**
	 * literally NO IDEA if this is gonna work :P
	 * will make a more consistent version later
	 * (it didnt)
	 * @return
	 */
	@Override
	protected boolean isFinished() {
		return manipulatorWithKaChunker.hasHatch();
	}

	@Override
	protected void end() {
		manipulatorWithKaChunker.setKachunkerGrab();
	}
}
