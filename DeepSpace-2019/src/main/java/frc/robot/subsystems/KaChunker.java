/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * <h1>KaChunker</h1>
 * This is a representation of the ka-chunker.<br>
 * Hatch holder and dropper.<br>
 * It's got a solenoid. Connected to a piston. What else do you want?
 */
public class KaChunker extends Subsystem {
	private static Solenoid solenoid;

	/**
	 * Instantiate the solenoid on channel specified
	 * in {@code RobotMap}
	 */
	public KaChunker() {
		solenoid = new Solenoid(RobotMap.KACHUNKER_SOLENOID_CHANNEL);
	}

	/**
	 * Set the piston forward
	 */
	public void setForward() {
		solenoid.set(true); //True means forward
	}

	/**
	 * Set the piston backward
	 */
	public void setBackward() {
		solenoid.set(false);
	}

	/**
	 * @return whether the piston is forward
	 */
	public boolean isForward() {
		return solenoid.get();
	}

	@Override
	public void initDefaultCommand() {} //This is unused; it's totally useless for the ka-chunker
}
