/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

/**
 * Toggles the ka-chunker. Fairly self-descriptive
 */
public class KaChunkerToggle extends Command {

	/**
	 * Check the ka-chunker's state, then invert it
	 */
	public KaChunkerToggle() {
		requires(Robot.kaChunker);
	}

  	@Override
	protected void initialize() {
		Robot.kaChunker.set(!Robot.kaChunker.isForward()); //Set to the opposite of the current state
	}

	@Override
	protected boolean isFinished() {
		return true;
	}
}
