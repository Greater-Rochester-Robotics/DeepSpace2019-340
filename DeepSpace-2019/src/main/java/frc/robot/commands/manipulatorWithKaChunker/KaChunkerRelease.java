/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.manipulatorWithKaChunker;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class KaChunkerRelease extends Command {

	/**
	 * Step 1: piston goes in
	 */
  public KaChunkerRelease() {
	  requires(Robot.manipulatorWithKaChunker);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
	  Robot.manipulatorWithKaChunker.setKachunkerDrop();
  }

  
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }
}
