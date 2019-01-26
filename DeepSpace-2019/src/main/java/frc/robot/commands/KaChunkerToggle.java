/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class KaChunkerToggle extends Command {
  public KaChunkerToggle() {
    requires(Robot.kaChunker);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
	if(Robot.kaChunker.isForward()) {
		Robot.kaChunker.setBackward();
	} else {
		Robot.kaChunker.setForward();
	}
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }
}
