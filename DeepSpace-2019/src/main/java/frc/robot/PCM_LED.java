/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Solenoid;

/**
 * LEDs powered via PCM
 */
public class PCM_LED extends Solenoid {

	/**
	 * Makes LEDs powered via PCM
	 * @param canID the CAN ID of the PCM in use. Default is probably 0
	 * @param channel the PCM channel in use
	 */
	public PCM_LED(final int canID, final int channel) {
		super(canID, channel);
	}
}
