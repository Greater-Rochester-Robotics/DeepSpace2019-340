/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 * 
 * This will eventually be replaced with some kind of scheme relating to auto-detection of comp/prac bot
 */
public class RobotMap {
	
	//////////////////
	// PWM CHANNELS //
	//////////////////

	/* Talons */
	public static final int DRIVE_TALON_LEFT_CHANNEL = 0;
	public static final int DRIVE_TALON_RIGHT_CHANNEL = 1;

	/* Encoders */
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_A = 2;
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_B = 3;
	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_A = 4;
	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_B = 5;
}
