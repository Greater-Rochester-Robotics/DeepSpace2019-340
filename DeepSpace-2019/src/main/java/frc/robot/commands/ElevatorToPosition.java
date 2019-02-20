/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;

import static frc.robot.Robot.elevator;

public class ElevatorToPosition extends Command {
	private double pos;

	public ElevatorToPosition(double pos) {
		requires(elevator);
		this.pos = pos;
	}

	@Override
	protected void initialize() {
		elevator.goToPos(pos);
	}

	//Done when within half a motor turn of intended position
	@Override
	protected boolean isFinished() {
		return elevator.getRawPos() <= pos + .5 && elevator.getRawPos() >= pos - .5;
	}

	// Called once after isFinished returns true
	@Override
	protected void end() {
		elevator.stop();
	}
}
