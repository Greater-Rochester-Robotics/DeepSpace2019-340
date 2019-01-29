/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * <h1>C</h1>
 * No, not the proglang. Though I'm glad it isn't.<br>
 * This is the cargo intake. Two arrays of wheels, one
 * on top and one in bottom, manipulating the cargo.
 * Why the name then? It looks like a C.
 */
public class C extends Subsystem {
	private static DigitalInput sensor; //Sensor type not yet determined. Probably a long clicky dude
	private static TalonSRX talonUp, talonDown;

	/**
	 * Set up the SRXs and DIO with the ports
	 * specified in {@code RobotMap}
	 */
	public C() {
		sensor = new DigitalInput(RobotMap.C_CARGO_SENSOR_PORT);
		talonUp = new TalonSRX(RobotMap.C_SRX_TOP_ID);
		talonDown = new TalonSRX(RobotMap.C_SRX_BOTTOM_ID);

		talonDown.set(ControlMode.Follower, RobotMap.C_SRX_TOP_ID); //Enslave the down SRX to the top
		talonDown.setInverted(true); //Negate all speeds to reflect position
	}
	
	/**
	 * Give the SRXs their speed. The speed will
	 * always match either side
	 * @param speed the speed as a percentage [0, 1]
	 */
	public void setSpeed(double speed) {
		talonUp.set(ControlMode.PercentOutput, speed);
	}
	
	/**
	 * @return whether the cargo is secure
	 */
	public boolean hasCargo() {
		return sensor.get();
	}

	@Override
	public void initDefaultCommand() {}
}
