/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.elevator;

public class ElevatorExitStartConfig extends Command {
	public ElevatorExitStartConfig() {
		requires(elevator);
	}

	@Override
	protected void initialize() {
		elevator.tiltForward();
	}

	@Override
	protected void execute() {
		if(timeSinceInitialized() >= 1 && !elevator.isAtBottom()) {
			elevator.setSpeed(-.25);
		} else {
			elevator.stop();
		}
	}

	@Override
	protected boolean isFinished() {
		return elevator.isAtBottom(); //Not sure how well I trust setting timeout in initialize, soooo
	}

	@Override
	protected void end() {
		elevator.stop();
	}
}
