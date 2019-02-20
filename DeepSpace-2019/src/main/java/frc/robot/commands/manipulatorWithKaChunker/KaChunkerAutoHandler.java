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
	private boolean startingStatus = false; //True if sensor button starts pressed
	private double timeout;

	/**
	 * Handles the ka-chunker with masterful accuracy. Maybe.
	 */
	public KaChunkerAutoHandler(double timeout) {
		requires(manipulatorWithKaChunker);
		this.timeout = timeout;
	}

	@Override
	protected void initialize() {
		startingStatus = manipulatorWithKaChunker.hasHatch();
		manipulatorWithKaChunker.setWristDown();
		manipulatorWithKaChunker.setKachunkerDrop();
		setTimeout(timeout); //When trying to drop a hatch, give the machine .15 seconds to finish dropping
	}

	/**
	 * literally NO IDEA if this is gonna work :P
	 * will make a more consistent version later
	 * (it didnt)
	 * @return
	 */
	@Override
	protected boolean isFinished() {
		if(startingStatus != manipulatorWithKaChunker.hasHatch()) {
			return isTimedOut();
		} else {
			return false;
		}
	}

	@Override
	protected void end() {
		manipulatorWithKaChunker.setKachunkerGrab();
		startingStatus = manipulatorWithKaChunker.hasHatch();
	}
}
