/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class DriveBackVibrate extends Command {
  public DriveBackVibrate() {
	  requires(Robot.drive);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
	  System.out.println("DriveBackVibrate Started");
	Robot.oi.setDriverRumble(0, 1);
	
	setTimeout(1);
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
	Robot.drive.setDriveBoth(.5,.5);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return isTimedOut();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
	  System.out.println("DriveBackVibrate Ended");
	Robot.drive.setDriveBoth(0,0);
	Robot.oi.setDriverRumble(0,0);

  }
}
