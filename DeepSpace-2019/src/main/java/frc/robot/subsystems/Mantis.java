/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Talon;
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
	private static Solenoid stingerDrop, stingerRaise; //Controls the piston at the back of the bot
	private static Talon arm; //Throws the mantis arms down
	private static DigitalInput front, back, down; //front, back, and down sensors for mantis driving on
	/**
	 * Assign the stinger and winch their channel/port
	 * given {@link RobotMap}
	 */
	public Mantis() {
		stingerDrop = new Solenoid(RobotMap.STINGER_SOLENOID_DROP_CHANNEL);
		arm = new Talon(RobotMap.MANTIS_TALON_CHANNEL);
		front = new DigitalInput(RobotMap.MANTIS_FRONT_CHANNEL);
		back = new DigitalInput(RobotMap.MANTIS_BACK_CHANNEL);
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
	 * @param isForward {@code true} if stringer should extend
	 * TODO: forward/backward
	 */
	public void setStinger(boolean isForward) {
		stingerDrop.set(isForward);
	}

	/**
	 * Returns whether or not the Mantis down arm is all the way down.
	 * @return True if the arm is down.
	 */
	public boolean isDown() {
		return down.get();
	}

	/**
	 * Returns whether or not the front sensor can see the ground.
	 * @return False if the front is on the ground.
	 */
	public boolean isFrontHigh() {
		return front.get();
	}

	/**
	 * Returns whether or not the back sensor can see the ground.
	 * @return False if the back is on the ground.
	 */
	public boolean isBackHigh() {
		return back.get();
	}

	@Override
	public void initDefaultCommand() {}
}
