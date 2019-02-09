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
	// public static final int ELEVATOR_ENCODER_CHANNEL_A = 4;
	// public static final int ELEVATOR_ENCODER_CHANNEL_B = 5;

	/* Sensors */
	public static final int ELEVATOR_BOTTOM_SENSOR_PORT = 4;
	public static final int MANIPULATOR_CARGO_SENSOR_PORT = 6;
	public static final int FRONT_DOWN_CHANNEL = 7;
	public static final int BACK_DOWN_CHANNEL = 8;
	public static final int MANTIS_ARM_DOWN_SWITCH = 9;
	public static final int MANIPULATOR_HATCH_SENSOR_PORT = 5;

	////////////////////////
	// PNEUMATIC CHANNELS //
	////////////////////////

	/* Solenoids */
	public static final int KACHUNKER_SOLENOID_GRAB_CHANNEL = 0;
	public static final int KACHUNKER_SOLENOID_DROP_CHANNEL = 1;
	public static final int WRIST_SOLENOID_DOWN_CHANNEL = 2;
	public static final int WRIST_SOLENOID_UP_CHANNEL = 3;
	public static final int DISC_BRAKE_SOLENOID_RELEASE_CHANNEL = 4;
	public static final int STINGER_SOLENOID_DROP_CHANNEL = 5;

	//TODO: get official numbers
	public static final int ELEVATOR_TILT_SOLENOID_FORWARD_CHANNEL = 98;
	public static final int ELEVATOR_TILT_SOLENOID_BACKWARD_CHANNEL = 99;
	
	//Will we need more? Say, stinger up for instance

	/////////////
	// CAN IDs //
	/////////////

	/* TalonSRXs */
	public static final int DRIVE_MANTIS_SRX_LEFT_ID = 1;
	public static final int DRIVE_MANTIS_SRX_RIGHT_ID = 2;
	public static final int MANIPULATOR_C_SRX_TOP_ID = 3;
	public static final int MANIPULATOR_C_SRX_BOTTOM_ID = 4;
	public static final int ELEVATOR_A_MOTOR_CAN_ID = 5;
	public static final int ELEVATOR_B_MOTOR_CAN_ID = 6;
	public static final int ELEVATOR_C_MOTOR_CAN_ID = 7;

	///////////////
	// CONSTANTS //
	///////////////

	/* C speed */
	public static final double C_INTAKE = 1.0;
	public static final double C_STOP = 0.0;
	public static final double C_OUTTAKE = -1.0;
	
	/* Elevator speed */
	public static final double ELEVATOR_UP_SPEED = 1.0;
	public static final double ELEVATOR_DOWN_SPEED = -1.0;
	public static final double ELEVATOR_STOP = 0.0;
	

	/* Mantis speed */
	public static final double MANTIS_ARM_DOWN = -1.0;
	public static final double MANTIS_ARM_UP = 1.0;
	public static final double MANTIS_WHEELS_FORWARD = 1.0;
	public static final double MANTIS_WHEELS_STOP = 0.0;
	public static final double MANTIS_WHEELS_BACKWARDS = -1.0;

	public static final double ZERO_SPEED = 0.0;

	public static final double ELEVATOR_MAX_HEIGHT = 100; //temporary
	public static final double ELEVATOR_TOP_UPPER_SLOW = 95;
	public static final double ELEVATOR_TOP_LOWER_SLOW = 90;
	public static final double ELEVATOR_BOTTOM_UPPER_SLOW = 10;
	public static final double ELEVATOR_BOTTOM_LOWER_SLOW = 5;
}
