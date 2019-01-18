/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.DPad;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick driver = new Joystick(0);
	private Joystick coDriver = new Joystick(1);

	////////////////////
	// DRIVER BUTTONS //
	////////////////////

	private Button driverA = new JoystickButton(driver, 1);
	private Button driverB = new JoystickButton(driver, 2);
	private Button driverX = new JoystickButton(driver, 3);
	private Button driverY = new JoystickButton(driver, 4);
	private Button driverLB = new JoystickButton(driver, 5);
	private Button driverRB = new JoystickButton(driver, 6);
	private Button driverBack = new JoystickButton(driver, 7);
	private Button driverStart = new JoystickButton(driver, 8);
	private Button driverLS = new JoystickButton(driver, 9);
	private Button driverRS = new JoystickButton(driver, 10);
	private Button driverDUp = new DPad(driver, DPad.Direction.UP);
	private Button driverDDown = new DPad(driver, DPad.Direction.DOWN);
	private Button driverDLeft = new DPad(driver, DPad.Direction.LEFT);
	private Button driverDRight = new DPad(driver, DPad.Direction.RIGHT);

	///////////////////////
	// CO-DRIVER BUTTONS //
	///////////////////////

	private Button coDriverA = new JoystickButton(coDriver, 1);
	private Button coDriverB = new JoystickButton(coDriver, 2);
	private Button coDriverX = new JoystickButton(coDriver, 3);
	private Button coDriverY = new JoystickButton(coDriver, 4);
	private Button coDriverLB = new JoystickButton(coDriver, 5);
	private Button coDriverRB = new JoystickButton(coDriver, 6);
	private Button coDriverBack = new JoystickButton(coDriver, 7);
	private Button coDriverStart = new JoystickButton(coDriver, 8);
	private Button coDriverLS = new JoystickButton(coDriver, 9);
	private Button coDriverRS = new JoystickButton(coDriver, 10);
	private Button coDriverDUp = new DPad(coDriver, DPad.Direction.UP);
	private Button coDriverDDown = new DPad(coDriver, DPad.Direction.DOWN);
	private Button coDriverDLeft = new DPad(coDriver, DPad.Direction.LEFT);
	private Button coDriverDRight = new DPad(coDriver, DPad.Direction.RIGHT);

	public OI() {
		//TODO: wait until Chase tells me what to put here. NO TOUCHIES
	}
}
