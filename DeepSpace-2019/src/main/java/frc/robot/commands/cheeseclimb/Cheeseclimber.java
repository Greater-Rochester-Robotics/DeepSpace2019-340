/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.cheeseclimb;

import edu.wpi.first.wpilibj.VictorSP;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 * 340's cheesecake climber. Essentially an arm that drops onto the HAB lv3 and
 * applies suction to enable the user to raise above the lv3 HAB (while fully
 * supported by it) while leaving room for another robot.<br>
 * <br>
 * TL;DR - 24pt climb tool
 */
public class Cheeseclimber extends Subsystem {
	private static VictorSP actuator, pump, winch;

	/**
	 * Creates a new Cheeseclimber object based on the provided PWM channels<br>
	 * <br>
	 * The Cheeseclimber uses three VictorSPXes, all connected via PWM. The first is
	 * used like a linear actuator, raising and lowering the arm body. The second
	 * activates the pump, and all it needs to do is provide maximum VBus to its
	 * output. Finally, the third is a winch, used to angle the user up while at
	 * maximum climb to ensure its bumpers are above the HAB lv3
	 * 
	 * @param actuatorChannel actuator SPX's PWM channel
	 * @param pumpChannel     pump SPX's PWM channel
	 * @param winchChannel    winch SPX's PWM channel
	 */
	public Cheeseclimber(final int actuatorChannel, final int pumpChannel, final int winchChannel) {
		actuator = new VictorSP(actuatorChannel);
		pump = new VictorSP(pumpChannel);
		winch = new VictorSP(winchChannel);
	}

	/**
	 * No default command; we wouldn't use this until endgame (releases Apr 26)
	 */
	@Override
	public void initDefaultCommand() {}

	/**
	 * Puts the actuator to a given speed
	 * 
	 * @param speed percent VBus for actuator; positive moves the arm up
	 */
	public void setActuator(double speed) {
		actuator.set(speed);
	}

	/**
	 * Stop the actuator
	 */
	public void stopActuator() {
		setActuator(0);
	}

	/**
	 * Suction as fast as possible
	 */
	public void startPump() {
		pump.set(1);
	}

	/**
	 * Cease the suction
	 */
	public void stopPump() {
		pump.set(0);
	}

	/**
	 * Run the winch at {@code speed} to angle the robot
	 * 
	 * @param speed speed at which to angle; positive tilts robot up
	 */
	public void setWinch(double speed) {
		winch.set(speed);
	}

	/**
	 * Stop winching/angling
	 */
	public void stopWinch() {
		setWinch(0);
	}
}
