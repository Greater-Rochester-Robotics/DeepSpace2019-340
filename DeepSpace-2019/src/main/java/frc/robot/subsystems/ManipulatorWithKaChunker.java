/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * <h1>Manipulator + Ka-Chunker</h1>
 * <i>Because we just had to get the word "ka-chunker" in there</i><br>
 * <br>
 * This is the combined cargo and hatch manipulation subsystem, featuring
 * a wrist-like piston actuation
 */
public class ManipulatorWithKaChunker extends Subsystem {
	private static DigitalInput cargoSensor; //Triggers when the cargo is secured
	private static DigitalInput hatchSensor; //Triggers witht the hatch. TODO: when?
	private static DoubleSolenoid wrist;
	private static Solenoid kaChunker; //true == drop false == grab
	private static TalonSRX cBottom, cTop; //Top and bottom wheels of the C intake

	/**
	 * Assigns the sensor, solenoids, and SRXs their port, channels, and IDs
	 * as per the {@link RobotMap} specs
	 */
	public ManipulatorWithKaChunker() {
		cargoSensor = new DigitalInput(RobotMap.MANIPULATOR_CARGO_SENSOR_PORT);
		hatchSensor = new DigitalInput(RobotMap.MANIPULATOR_HATCH_SENSOR_PORT);

		kaChunker = new Solenoid(RobotMap.KACHUNKER_SOLENOID_GRAB_CHANNEL);
		wrist = new DoubleSolenoid(RobotMap.WRIST_SOLENOID_DOWN_CHANNEL, RobotMap.WRIST_SOLENOID_UP_CHANNEL);

		cBottom = new TalonSRX(RobotMap.MANIPULATOR_C_SRX_BOTTOM_ID);
		cTop = new TalonSRX(RobotMap.MANIPULATOR_C_SRX_TOP_ID);

		cBottom.set(ControlMode.Follower, RobotMap.MANIPULATOR_C_SRX_TOP_ID); //Enslave bottom SRX to top SRX

	}

	////////////
	// SENSOR //
	////////////

	/**
	 * @return {@code true} if the cargo has been secured
	 */
	public boolean hasCargo() {
		return cargoSensor.get();
	}

	////////////////
	// KA-CHUNKER //
	////////////////

	/**
	 * @return {@code true} if ka-chunker is grabbing
	 */
	public boolean isKachunkerGrabbing() {
		return (!kaChunker.get());
	}

	/**
	 * Set the ka-chunker's state
	 * @param isGrabbing {@code true} for grab, {@code false} for drop
	 */
	private void setKachunker(boolean isGrabbing) {
		kaChunker.set(!isGrabbing);
	}

	/**
	 * Grab with the ka-chunker
	 */
	public void setKachunkerGrab() {
		setKachunker(true);
	}

	/**
	 * Drop with the ka-chunker
	 */
	public void setKachunkerDrop() {
		setKachunker(false);
	}

	/**
	 * Set the ka-chunker to whichever state it currently isn't
	 */
	public void toggleKachunker() {
		setKachunker(!isKachunkerGrabbing());
	}

	/**
	 * @return {@code true} when hatch sensor is clicked in
	 */
	public boolean hasHatch() {
		return hatchSensor.get();
	}

	///////////
	// WRIST //
	///////////

	/**
	 * @return {@code true} if the manipulator is pointed down
	 */
	public boolean isWristDown() {
		return wrist.get().equals(Value.kForward);
	}

	/**
	 * Set the wrist's direction
	 * @param isDown {@code true} for down, {@code false} for up
	 */
	private void setWrist(boolean isDown) {
		wrist.set(isDown ? Value.kForward : Value.kReverse);
	}

	/**
	 * Flick the wrist down
	 */
	public void setWristDown() {
		setWrist(true);
	}

	/**
	 * Flick the wrist up
	 */
	public void setWristUp() {
		setWrist(false);
	}

	/**
	 * Flick the wrist to whichever direction it isn't
	 */
	public void toggleWrist() {
		setWrist(!isWristDown());
	}

	///////
	// C //
	///////

	/**
	 * @return the current output percentage of the C motors
	 */
	public double getCSpeed() {
		return cTop.getMotorOutputPercent();
	}

	/**
	 * Set the percent output of the C<br>
	 * Negative in, positive out
	 * @param speed the percent output from [-1, 1]
	 */
	public void setCSpeed(double speed) {
		cTop.set(ControlMode.PercentOutput, speed);
	}

	@Override
	public void initDefaultCommand() {} //No need for a default command
}
