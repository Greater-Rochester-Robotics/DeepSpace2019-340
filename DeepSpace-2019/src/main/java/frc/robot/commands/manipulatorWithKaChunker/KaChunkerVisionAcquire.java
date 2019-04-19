/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.manipulatorWithKaChunker;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.networktables.NetworkTableInstance;

/**
 * Using limelight automatically grabs hatch when proper distance from reflective tape
 */
public class KaChunkerVisionAcquire extends Command {
	double pixelDistance = 0;
	
	public KaChunkerVisionAcquire() {
	  requires(Robot.manipulatorWithKaChunker);
	  
  	}

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("pipeline").setNumber(0); //set pipeline to zero
	  	
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(0); //makes sure that its in robot looks around mode
		 
		
		Robot.manipulatorWithKaChunker.setWristDown();
		Robot.manipulatorWithKaChunker.setKachunkerDrop();
		System.out.println("Vision Acquire Started");
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3); //turns on limelight led
		// have a default value for the x corner coordinate
		double[] defaultValue = new double[0];
		//pull the x corner coodinate of every contour corner
		double[] tcornx = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tcornx").getDoubleArray(defaultValue);
		double total = 0;
		//find average of all x corners
		double cornAverage = getAverage(tcornx);

		//divide all corners into those bigger than average and less than average(i.e. right and left)
		//and get average of right values and average of left values
		double rightTotal = 0;
		double leftTotal = 0;
		int rightCount = 0;
		int leftCount = 0;

		for(int i = 0; i < tcornx.length; i++){
			if(tcornx[i] < cornAverage){ //sums the left
				leftTotal = leftTotal + tcornx[i];
				//gets how many are on left
				leftCount++;
			}
			else{ //sums the right
				rightTotal = rightTotal + tcornx[i];
				//gets how many are on right
				rightCount++;
			}
		}
		double rightAverage = rightTotal / rightCount;
		double leftAverage = leftTotal / leftCount;
		
		//get difference between right and left averages in pixels
		pixelDistance = rightAverage - leftAverage;

		// System.out.println("distance:"+pixelDistance);
	}

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
	double haveTarget = NetworkTableInstance.getDefault().getTable("limelight").getEntry("tv").getDouble(0);

	return (pixelDistance > 120) && (haveTarget != 0); //120 is grabbing range, greater than means it is closer to vision target 
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
	Robot.manipulatorWithKaChunker.setKachunkerGrab(); // Grabs hatch because we know we are in range
	NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(1); //turns on limelight led boi
	System.out.println("Vision Acquire Ended");
  }

  /**
   * A funtion f=to get the average of all elements of the array
   * @param arr
   * @return
   */
  private double getAverage(double[] arr){ 
	double total = 0;
		for(int i = 0; i < arr.length; i++){
			total = total + arr[i]; 
			
		}
		double average = total / arr.length;
		return average; //average is for determining what points are left and right of centre 
  }

}
