/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.OI.Axis;

public class ElevatorStick extends Command {
	public ElevatorStick() {
		requires(Robot.elevator);
	}

	@Override
	protected void execute() {
		Robot.elevator.setSpeed(Robot.oi.getCoDriverAxis(Axis.LEFT_Y));
	}

	@Override
	protected boolean isFinished() {
		return false;
	}

	@Override
	protected void end() {
		Robot.elevator.setSpeed(0); //Stop the elevator on end (interrupt included)
	}
}
