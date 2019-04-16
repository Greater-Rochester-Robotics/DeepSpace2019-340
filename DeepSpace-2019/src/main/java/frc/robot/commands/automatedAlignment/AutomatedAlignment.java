/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.automatedAlignment;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.OI.Axis;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class AutomatedAlignment extends Command {
  public AutomatedAlignment() {
	requires (Robot.drive);
	/**
	 * step 1: right trigger is pressed
	 * step 2: robot uses data from limelight to drive forward and adjust as needed
	 * setp 3: stops when trigger is released or in position to score
	 */

  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
	  //turn on limelight, make sure leds are on 
	  //get starting point (or set)
	  //set pipeline as zeor woowo
	  //add as needed
	  NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0); //set pipeline to zeoroo wow !
	  NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3); //turns on limelight led boi
	  NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0); //makes sure that its in robot looks around mode

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
	  // drive forward constnagt slow speed 
	  // adjust angle robot is at as needed
	  double haveTarget = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
	  if(haveTarget == 0) {
		Robot.drive.arcadeDrive(0, 0);
		//add vibrate driver joystick	
	  } else { 
		double rotateValue=0;
		//Pull value of limelight left/right and use to create rotate value

		// hi limit speed to .7 or something for rotating thanks dont destroy the robot
		// minimum speed for rotating is like .15 rob says we  can experiment bro
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
		if(	Math.abs(Robot.oi.getDriverAxis(Axis.LEFT_Y)) >= .05) {
				Robot.drive.arcadeDrive(Robot.oi.getDriverAxis(Axis.LEFT_Y)*.65, rotateValue);
		} else if(Math.abs(Robot.oi.getDriverAxis(Axis.RIGHT_Y)) >= .15) {
				Robot.drive.arcadeDrive(Robot.oi.getDriverAxis(Axis.RIGHT_Y)*.3, rotateValue);
		} else {
			Robot.drive.arcadeDrive(0, rotateValue);	
		}
	  }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
	  //when right trigger is released
	  //or when ready to score
	  //turn off led (no blindness please)
	  NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1); //turns off limelight led boi
  }
}
