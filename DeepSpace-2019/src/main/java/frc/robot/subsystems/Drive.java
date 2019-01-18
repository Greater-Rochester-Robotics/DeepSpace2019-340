/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.analog.adis16448.frc.ADIS16448_IMU;

import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;
import frc.robot.commands.DriveXOne;

/**
 * <h1>Drive</h1>
 * Moves the robot between two places. Always uses the Xbox ONE controller
 * command unless explicitly told otherwise
 */
public class Drive extends Subsystem {
	private double leftSpeed, rightSpeed; //Makes math easier for fancy drive modes

	private static Talon talonLeft, talonRight;
	private static Encoder encLeft, encRight; //TODO: adjust for circumference
	private static ADIS16448_IMU imu;

	public Drive() {
		talonLeft = new Talon(RobotMap.DRIVE_TALON_LEFT_CHANNEL);
		talonRight = new Talon(RobotMap.DRIVE_TALON_RIGHT_CHANNEL);

		encLeft = new Encoder(RobotMap.DRIVE_ENCODER_LEFT_CHANNEL_A, RobotMap.DRIVE_ENCODER_LEFT_CHANNEL_B);
		encRight = new Encoder(RobotMap.DRIVE_ENCODER_RIGHT_CHANNEL_A, RobotMap.DRIVE_ENCODER_RIGHT_CHANNEL_B);

		imu = new ADIS16448_IMU(ADIS16448_IMU.Axis.kY); //The parameter here is the axis the IMU interprets as being yaw. This will depend on how the RIO is oriented
	}

	@Override
	public void initDefaultCommand() {
		setDefaultCommand(new DriveXOne());
	}

	/**
	 * @return left encoder raw count
	 */
	public int getLeftEncoder() {
		return encLeft.get();
	}

	/**
	 * @return right encoder raw count
	 */
	public int getRightEncoder() {
		return encRight.get();
	}

	/**
	 * @return encoder-derived left rail speed
	 */
	public double getLeftSpeed() {
		return encLeft.getRate();
	}

	/**
	 * @return encoder-derived right rail speed
	 */
	public double getRightSpeed() {
		return encRight.getRate();
	}

	/**
	 * @return left encoder distance
	 */
	public double getLeftDistance() {
		return encLeft.getDistance();
	}

	/**
	 * @return right encoder distance
	 */
	public double getRightDistance() {
		return encRight.getDistance();
	}

	/**
	 * Zero the left encoder
	 */
	public void resetLeftEncoder() {
		encLeft.reset();
	}

	/**
	 * Zero the right encoder
	 */
	public void resetRightEncoder() {
		encRight.reset();
	}

	/**
	 * Zero both encoders
	 */
	public void resetBothEncoders() {
		encLeft.reset();
		encRight.reset();
	}

	/**
	 * Set the speed, as a percentage of max forward speed, of the left drive rail
	 * @param speed percentage of max forward speed
	 */
	public void setDriveLeft(double speed) {
		if(speed < -1) {
			speed = -1;
		} else if (speed > 1) {
			speed = 1;
		}

		talonLeft.set(speed);
	}

	/**
	 * Set the speed, as a percentage of max forward speed, of the right drive rail
	 * @param speed percentage of max forward speed
	 */
	public void setDriveRight(double speed) {
		if(speed < -1) {
			speed = -1;
		} else if (speed > 1) {
			speed = 1;
		}

		talonRight.set(speed);
	}

	/**
	 * Set the drive train to a given speed, as a percentage of max forward speed<br>
	 * Both rails will be at equal speed
	 */
	public void setDriveBoth(double speed) {
		setDriveLeft(speed);
		setDriveRight(speed);
	}

	/**
	 * Set the drive train to a given speed, as a percentage of max forward speed<br>
	 * Rails are independently sped
	 */
	public void setDriveBoth(double lSpeed, double rSpeed) {
		setDriveLeft(lSpeed);
		setDriveRight(rSpeed);
	}

	/**
	 * Stop the drive train
	 */
	public void stopDrive() {
		setDriveBoth(0);
	}

	/**
	 * Get the robot's yaw angle
	 */
	public double getRotation() {
		return imu.getYaw();
	}

	/**
	 * Zero the IMU
	 */
	public void imuReset() {
		imu.reset();
	}

	/**
     * One joystick drive mode. One stick axis speeds forward/backwards, the other adds rotation on robot yaw axis
     * @param moveValue forward/backward speed, as a percentage of max forward speed
     * @param rotateValue rotation speed, as a percentage of max rightward rotation speed
     */
    public void arcadeDrive(double moveValue, double rotateValue) {
		if(moveValue > 0.0) {
		    if(rotateValue > 0.0) {
		    	leftSpeed = moveValue - rotateValue;
		    	rightSpeed = Math.max(moveValue, rotateValue);
		    } else {
		    	leftSpeed = Math.max(moveValue, -rotateValue);
		    	rightSpeed = moveValue + rotateValue;
		    }
		} else {
		    if(rotateValue > 0.0) {
		    	leftSpeed = -Math.max(-moveValue, rotateValue);
		    	rightSpeed = moveValue + rotateValue;
		    } else {
		    	leftSpeed = moveValue - rotateValue;
		    	rightSpeed = -Math.max(-moveValue, -rotateValue);
		    }
		}

		setDriveBoth(leftSpeed, rightSpeed);
	}

	/**
	 * Experiental GTA-esque drive scheme from 2017. Probably not for competition use
	 * @param speed forward/backward speed, as a percentage of max forward speed
	 * @param rotateValue rotation speed, as a percentage of max rightward rotation speed
	 */
	public void gtaDrive(double speed, double rotateValue) {
		if(speed > 0) {
			if(rotateValue > 0) {
				//TODO: write this
			}
		}
	}
}
