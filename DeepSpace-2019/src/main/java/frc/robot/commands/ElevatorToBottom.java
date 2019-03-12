/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.elevator;

public class ElevatorToBottom extends Command {
	public ElevatorToBottom() {
		requires(elevator);
	}

	@Override
	protected void initialize() {
		elevator.setSpeed(-.3);
	}

	@Override
	protected boolean isFinished() {
		return elevator.isAtBottom() || elevator.getRawPos() <= .2;
	}

	@Override
	protected void end() {
		elevator.stop();
	}
}
