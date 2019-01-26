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
 * Add your docs here.
 */
public class C extends Subsystem {
	private static DigitalInput sensor; //Sensor type not yet determined
	private static TalonSRX talonUp, talonDown;

	public C() {
		sensor = new DigitalInput(RobotMap.C_CARGO_SENSOR_PORT);
		talonUp = new TalonSRX(RobotMap.C_SRX_TOP_ID);
		talonDown = new TalonSRX(RobotMap.C_SRX_BOTTOM_ID);
	}
	
	public void setSpeed(double speed) {
		talonUp.set(ControlMode.Velocity, speed);
		talonDown.set(ControlMode.Velocity, speed);
	}
	
	public boolean hasCargo() {
		return sensor.get();
	}

	@Override
	public void initDefaultCommand() {}
}
