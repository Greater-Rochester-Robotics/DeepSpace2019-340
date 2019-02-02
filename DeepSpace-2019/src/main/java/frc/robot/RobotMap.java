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
	public static final int MANIPULATOR_CARGO_SENSOR_PORT = 6;
	public static final int MANTIS_FRONT_CHANNEL = 7;
	public static final int MANTIS_BACK_CHANNEL = 8;
	public static final int MANTIS_ARM_DOWN_SWITCH = 9;
	////////////////////////
	// PNEUMATIC CHANNELS //
	////////////////////////

	/* Solenoids */
	public static final int ELEVATOR_SOLENOID_LEFT = 0;
	public static final int ELEVATOR_SOLENOID_RIGHT = 1;
	public static final int MANIPULATOR_KACHUNKER_SOLENOID_CHANNEL = 2;
	public static final int MANIPULATOR_WRIST_SOLENOID_CHANNEL = 3;
	public static final int MANTIS_SOLENOID_CHANNEL = 4;

	/////////////
	// CAN IDs //
	/////////////

	/* TalonSRXs */
	public static final int DRIVE_MANTIS_SRX_LEFT_ID = 1;
	public static final int DRIVE_MANTIS_SRX_RIGHT_ID = 2;
	public static final int MANIPULATOR_C_SRX_TOP_ID = 3;
	public static final int MANIPULATOR_C_SRX_BOTTOM_ID = 4;

	/////////////////////
	// SPEED VARIABLES //
	/////////////////////

	/* C speed */
	public static final double C_INTAKE = 1.0;
	public static final double C_STOP = 0.0;
	public static final double C_OUTTAKE = -1.0;
	
	/* Elevator speed */
	public static final double ELEVATOR_UP_SPEED = 1.0;
	public static final double ELEVATOR_DOWN_SPEED = -1.0;
	public static final double ELEVATOR_STOP = 0.0;

	/* Mantis speed*/
	public static final double MANTIS_ARM_DOWN = -1.0;
	public static final double MANTIS_ARM_UP = 1.0;
	public static final double MANTIS_WHEELS_FORWARD = 1.0;
	public static final double MANTIS_WHEELS_STOP = 0.0;
	public static final double MANTIS_WHEELS_BACKWARDS = -1.0;
}
