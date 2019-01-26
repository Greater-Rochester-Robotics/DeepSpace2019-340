/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * Add your docs here.
 */
public class CIntake extends Subsystem {

	private static TalonSRX talonUp, talonDown;

	public CIntake(){
		talonUp = new TalonSRX(42);
		talonDown = new TalonSRX(19);
	}
	
	public void setSpeed(double speed){
		talonUp.set(ControlMode.Velocity, speed);
		talonDown.set(ControlMode.Velocity, speed);
	}
	/* sets speed for both talonSRX's with the same variable*/

	@Override
	public void initDefaultCommand() {}
}
