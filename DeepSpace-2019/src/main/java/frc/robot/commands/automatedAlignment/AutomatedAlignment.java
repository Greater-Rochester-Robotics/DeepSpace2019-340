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
import edu.wpi.first.wpilibj.ControllerPower;
import edu.wpi.first.wpilibj.PIDController;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.PIDSource;
@Deprecated
public class AutomatedAlignment extends Command {
	
	double hadTarget = 0;
	// private PIDController controller;
	
	// /** An output which calls {@link PIDCommand#usePIDOutput(double)} */
    // private PIDOutput output = new PIDOutput() {

    //     public void pidWrite(double output) {
    //         usePIDOutput(output);
    //     }
    // };
    // /** A source which calls {@link PIDCommand#returnPIDInput()} */
    // private PIDSource source = new PIDSource() {

    //     public double pidGet() {
    //         return returnPIDInput();
    //     }
    // };
	public AutomatedAlignment() {
		// controller = new PIDController(.0083, 0, 0, source, output);
		
		// controller.setSetpoint(0);
		
		// controller.setInputRange(0, 40);
		
		// controller.setOutputRange(.05, .4);

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

	//   controller.disable();

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
		Robot.oi.setDriverRumble(0, 0);
		
		// controller.enable();
		double rotateValue=0;
		double angleToTarget=NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
		// write a function for rotateValue, so that it is driven by angleToTarget
		if (Math.abs(angleToTarget) < .75){
			rotateValue = 0;
		}
		else{
			rotateValue = (angleToTarget/35)*.25;//*12.5/ControllerPower.getInputVoltage();
			if(Math.abs(rotateValue) < .05){
				if(rotateValue > 0){
					rotateValue = .05;
				}
				else{
					rotateValue = -.05;
				}
			}
		}
		// hi limit speed to .7 or something for rotating thanks dont destroy the robot
		// minimum speed for rotating is like .15 rob says we  can experiment bro
		
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
  protected void end() {
	Robot.oi.setDriverRumble(0, 0);
	NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);
	// controller.disable();
	  //when right trigger is released
	  //or when ready to score
	  //turn off led (no blindness please)
	  NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1); //turns off limelight led boi
  }

//   public double returnPIDInput(){
// 	  if (Math.abs(NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0)) < .75){
// 		return 0;
// 	  }
// 	  else{
// 	 	 return NetworkTableInstance.getDefault().getTable("limelight").getEntry("tx").getDouble(0);
// 	  }
//   }

//   public void usePIDOutput(double output){  
// 	if(	Math.abs(Robot.oi.getDriverAxis(Axis.LEFT_Y)) >= .05) {
// 		Robot.drive.arcadeDrive(Robot.oi.getDriverAxis(Axis.LEFT_Y)*.65, output);
// 	} else if(Math.abs(Robot.oi.getDriverAxis(Axis.RIGHT_Y)) >= .15) {
// 		Robot.drive.arcadeDrive(Robot.oi.getDriverAxis(Axis.RIGHT_Y)*.3, output);
// 	} else {	
// 		Robot.drive.arcadeDrive(0, output);	
// 	}
//   }
}
