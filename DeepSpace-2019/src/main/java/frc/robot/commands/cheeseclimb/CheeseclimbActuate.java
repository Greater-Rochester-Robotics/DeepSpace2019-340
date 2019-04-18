/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.cheeseclimb;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.cheeseclimber;

/**
 * Actuate the Cheeseclimber at a given speed. This command ends immediately,
 * leaving the actuation going
 */
public class CheeseclimbActuate extends Command {
	private double speed;

	/**
	 * @param speed actuation percent VBus; positive raises arm
	 */
	public CheeseclimbActuate(double speed) {
		requires(cheeseclimber);
		this.speed = speed;
	}

	/**
	 * Start actuating the arm, and don't stop
	 */
	@Override
	protected void initialize() {
		cheeseclimber.setActuator(speed);
	}

	/**
	 * Be done immediately
	 */
	@Override
	protected boolean isFinished() {
		return true;
	}
}
