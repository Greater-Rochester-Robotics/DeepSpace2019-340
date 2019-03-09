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
	public static final int DRIVE_SPARK_LEFT_CHANNEL = 0;
	public static final int DRIVE_SPARK_RIGHT_CHANNEL = 1;

	///////////////
	// DIO PORTS //
	///////////////

	/* Encoders */
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_A = 8;
	public static final int DRIVE_ENCODER_LEFT_CHANNEL_B = 9;
	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_A = 6;
	public static final int DRIVE_ENCODER_RIGHT_CHANNEL_B = 7;

	/* Sensors */
	public static final int MANIPULATOR_HATCH_SENSOR_PORT = 2;
	public static final int MANIPULATOR_CARGO_LEFT_SENSOR_PORT = 1;
	public static final int MANIPULATOR_CARGO_RIGHT_SENSOR_PORT = 0;
	public static final int FRONT_DOWN_CHANNEL = 4;
	
	public static final int BACK_DOWN_CHANNEL = 5;
	public static final int MANTIS_ARM_DOWN_SWITCH = 3;

	////////////////////////
	// PNEUMATIC CHANNELS //
	////////////////////////

	/* Solenoids */
	public static final int KACHUNKER_SOLENOID_GRAB_CHANNEL = 1; //Single 0
	public static final int WRIST_SOLENOID_DOWN_CHANNEL = 6; //3
	public static final int WRIST_SOLENOID_UP_CHANNEL = 5; //4
	public static final int DISC_BRAKE_SOLENOID_RELEASE_CHANNEL = 2; //Single 5
	public static final int STINGER_SOLENOID_DROP_CHANNEL = 0; //1
	public static final int STINGER_SOLENOID_RAISE_CHANNEL = 7;
	public static final int ELEVATOR_TILT_SOLENOID_FORWARD_CHANNEL = 4; //2
	public static final int ELEVATOR_TILT_SOLENOID_BACKWARD_CHANNEL = 3; //6

	/////////////
	// CAN IDs //
	/////////////

	/* TalonSRXs */

	//Commented numbers are on prac bot. THEY ARE NOT NOT PERMANENT ON EITHER BOT
	public static final int DRIVE_MANTIS_SRX_LEFT_ID = 4; //1
	public static final int DRIVE_MANTIS_SRX_RIGHT_ID = 5; //2
	public static final int MANIPULATOR_C_SRX_TOP_ID = 1; //4
	public static final int MANIPULATOR_C_SRX_BOTTOM_ID = 2; //3
	public static final int MANTIS_ARM_SRX_LEFT_ID = 6; //5
	public static final int MANTIS_ARM_SRX_RIGHT_ID = 3; //6

	/* Spark MAXes */
	public static final int ELEVATOR_A_MOTOR_CAN_ID = 13; //mid
	public static final int ELEVATOR_B_MOTOR_CAN_ID = 12; //left
	public static final int ELEVATOR_C_MOTOR_CAN_ID = 14; //right

	/* Compressor/LED PCM */
	public static final int SECONDARY_PCM_ID = 10;

	///////////////
	// CONSTANTS //
	///////////////

	/* C speed */
	public static final double C_INTAKE_SPEED = -.6;
	public static final double C_OUTTAKE_SPEED = 1.0;
	public static final double C_STALL_SPEED = -.15;

	/* Elevator speed */
	public static final double ELEVATOR_SPEED_MULTIPLIER = .75; //Also used as max up speed for manual overrides and kP
	public static final double ELEVATOR_MAX_DOWN_SPEED = -.55;
	

	/* Mantis speed */
	public static final double MANTIS_ARM_DOWN_SPEED = .8; //Positive down
	public static final double MANTIS_ARM_UP_SPEED = -.5; //Negative up
	public static final double MANTIS_WHEELS_FORWARD_SPEED = 1.0;
	public static final double MANTIS_WHEELS_BACKWARDS_SPEED = -1.0;

	/* The Titular Zero Speed */
	public static final double ZERO_SPEED = 0.0;

	/* Wrist tilt timing */
	public static final double WRIST_TILT_UP_TIME_S = 1.05;
	public static final double WRIST_TILT_DOWN_TIME_S = .6;

	/* Elevator heights */
	//All currently temporary
	//All built around hatches
	public static final double ELEVATOR_MAX_HEIGHT = 45;

	public static final double ELEVATOR_LEVEL_2_HEIGHT = 9.214322090148926 + 8.875 + 6.842069666;
	public static final double ELEVATOR_LEVEL_3_HEIGHT = 43.023406982421875;
	public static final double ELEVATOR_CLIMB_HEIGHT = 13.42069;

	public static final double ELEVATOR_TOP_UPPER_SLOW = 44;
	public static final double ELEVATOR_TOP_LOWER_SLOW = 35;
	public static final double ELEVATOR_BOTTOM_UPPER_SLOW = 6;
	public static final double ELEVATOR_BOTTOM_LOWER_SLOW = 2;
}
