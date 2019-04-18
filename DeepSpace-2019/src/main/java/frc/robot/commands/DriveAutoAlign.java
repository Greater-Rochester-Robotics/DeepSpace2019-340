/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;


import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;
import frc.robot.OI.Axis;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.ControllerPower;

public class DriveAutoAlign extends Command {
	
	double hadTarget = 0;

	public DriveAutoAlign() {
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
	  NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0); //set pipeline to zero
	  NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3); //turns on limelight led boi
	  NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0); //makes sure that its in robot looks around mode

  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
	  // drive forward constnagt slow speed 
	  // adjust angle robot is at as needed
	  double haveTarget = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);
	  if(haveTarget == 0 && hadTarget == 0) {
		//Rumble soft if NO target
		Robot.oi.setDriverRumble(0, 1);
		
		// controller.disable();
		//Allow driver control and drive until target discovered
		if(Math.abs(Robot.oi.getDriverAxis(Axis.LEFT_X)) >= .05 ||
			Math.abs(Robot.oi.getDriverAxis(Axis.LEFT_Y)) >= .05) {
				Robot.drive.arcadeDrive(Robot.oi.getDriverAxis(Axis.LEFT_Y)*.65, Robot.oi.getDriverAxis(Axis.LEFT_X)*.7569);
		} else if(Math.abs(Robot.oi.getDriverAxis(Axis.RIGHT_X)) >= .15 ||
			Math.abs(Robot.oi.getDriverAxis(Axis.RIGHT_Y)) >= .15) {
				Robot.drive.arcadeDrive(Robot.oi.getDriverAxis(Axis.RIGHT_Y)*.3, Robot.oi.getDriverAxis(Axis.RIGHT_X)*.45);
		} else {
			Robot.drive.setDriveBoth(0);
		}
	  } else { 
		//   if(NetworkTableInstance.getDefault().getTable("limelight").getEntry("ta").getDouble(0)>=17.75){
		// 	Robot.oi.setDriverRumble(1, 0);
		//   }else{
		// 	Robot.oi.setDriverRumble(0, 0);
		//   }
		double rotateValue=0;
		double angleToTarget=NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
		// write a function for rotateValue, so that it is driven by angleToTarget
		if (Math.abs(angleToTarget) < .75){
			rotateValue = 0;
		}else{
			rotateValue = (angleToTarget/35)*.29;//*12.5/ControllerPower.getInputVoltage();
			if(Math.abs(rotateValue) < .07){
				if(rotateValue > 0){
					rotateValue = .07;
				}
				else{
					rotateValue = -.07;
				}
			}
		}
		// hi limit speed to .7 or something for rotating thanks dont destroy the robot
		// minimum speed for rotating is like .15 rob says we  can experiment bro
		
		// COMPARE CORNERS TO ELIMINATE FALSE TARGETS

		if(	Math.abs(Robot.oi.getDriverAxis(Axis.LEFT_Y)) >= .05) {
				Robot.drive.arcadeDrive(Robot.oi.getDriverAxis(Axis.LEFT_Y)*.65, rotateValue);
		} else if(Math.abs(Robot.oi.getDriverAxis(Axis.RIGHT_Y)) >= .15) {
				Robot.drive.arcadeDrive(Robot.oi.getDriverAxis(Axis.RIGHT_Y)*.3, rotateValue);
		} else {
			Robot.drive.arcadeDrive(0, rotateValue);	
		}
	  }
	  hadTarget = haveTarget;
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return false;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() { //deprecated (idk where this goes)
	Robot.oi.setDriverRumble(0, 0);
	// NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);
	  //when right trigger is released
	  //or when ready to score
	  //turn off led (no blindness please)
	NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1); //turns off limelight led boi
  }
}
