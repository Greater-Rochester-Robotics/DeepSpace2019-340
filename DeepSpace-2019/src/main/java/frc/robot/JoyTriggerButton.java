/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import frc.robot.OI.Axis;

/**
 * Converts a trigger, locked to a joystick,
 * into a true/false button as if by
 * {@code axis >= triggerPercent}
 */
public class JoyTriggerButton extends Button {
	private Joystick stick;
	private double percent;
	private int axis;

	public JoyTriggerButton(Joystick joystick, double triggerPercent, int axis) {
		stick = joystick;
		percent = triggerPercent;
		this.axis = axis;
	}

	public JoyTriggerButton(Joystick joystick, double triggerPercent, Axis axis) {
		this(joystick, triggerPercent, axis.getAxisNumber());
	}

	/**
	 * @return {@code true} if axis >= givenPercent 
	 */
	public boolean get() {
		return stick.getRawAxis(axis) >= percent;
	}
}
