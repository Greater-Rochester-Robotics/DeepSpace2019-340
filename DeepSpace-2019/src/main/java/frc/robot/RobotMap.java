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
	public static final int ELEVATOR_TALON_CHANNEL = 2;
	public static final int MANTIS_TALON_CHANNEL = 3;

	///////////////
	// DIO PORTS //
	///////////////

	/* Encoders */
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_A = 0;
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_B = 1;
	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_A = 2;
	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_B = 3;
	public static final int ELEVATOR_ENCODER_CHANNEL_A = 4;
	public static final int ELEVATOR_ENCODER_CHANNEL_B = 5;

	/* Sensors */
	public static final int C_CARGO_SENSOR_PORT = 6;

	////////////////////////
	// PNEUMATIC CHANNELS //
	////////////////////////

	/* Solenoids */
	public static final int KACHUNKER_SOLENOID_CHANNEL = 0;
	public static final int MANTIS_SOLENOID_CHANNEL = 1;

	/////////////
	// CAN IDs //
	/////////////

	/* TalonSRXs */
	public static final int C_SRX_TOP_ID = 1;
	public static final int C_SRX_BOTTOM_ID = 2;
	public static final int DRIVE_MANTIS_SRX_LEFT_ID = 3;
	public static final int DRIVE_MANTIS_SRX_RIGHT_ID = 4;
}
