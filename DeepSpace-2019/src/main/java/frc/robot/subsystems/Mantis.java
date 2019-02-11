/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.robot.RobotMap;

/**
 * <h1>Mantis</h1>
 * This fancy piece of kit is used to push the robot up to
 * level three of the habitat, directly from level one.
 * It's named after the fact that it looks like a
 * preying mantis.<br>
 * <br>
 * But wait... the <i>robot</i> is named mantis... and the
 * <i>subsystem</i> is named mantis... which is which?
 */
public class Mantis extends Subsystem {
	private static DoubleSolenoid stinger; //Drops the back piston
	private static Talon arm; //Throws the mantis arms down
	private static DigitalInput down;
	 //front, back, and down sensors for mantis driving on
	/**
	 * Assign the stinger and winch their channel/port
	 * given {@link RobotMap}
	 */
	public Mantis() {
		stinger = new DoubleSolenoid(RobotMap.STINGER_SOLENOID_DROP_CHANNEL, RobotMap.STINGER_SOLENOID_RAISE_CHANNEL);
		arm = new Talon(RobotMap.MANTIS_TALON_CHANNEL);
		down = new DigitalInput(RobotMap.MANTIS_ARM_DOWN_SWITCH);
	}

	/**
	 * Set the speed at which the arm is winched<br>
	 * Positive up, negative down
	 * @param speed percentage [-1, 1]
	 */
	public void setArmSpeed(double speed) {
		arm.set(speed);
	}

	/**
	 * Flick the piston
	 * @param isForward {@code true} if stinger should extend
	 * TODO: forward/backward
	 */
	public void setStinger(boolean isForward) {
		stinger.set(isForward ? Value.kForward : Value.kReverse);
	}

	/**
	 * Returns whether or not the Mantis down arm is all the way down.
	 * @return {@code true} if the arm is down.
	 */
	public boolean isDown() {
		return down.get();
	}

	@Override
	public void initDefaultCommand() {}
}
