/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

import com.ctre.phoenix.ErrorCode;
import com.ctre.phoenix.Logger;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;
import frc.robot.OI.Axis;

/**
 * Move the elevator via co-driver's left
 * stick on their Xbox ONE controller<br>
 * <br>
 * This class and/or {@link frc.robot.subsystems.Elevator} may become
 * a lot more complex, provided this alone isn't sufficient
 */
public class ElevatorStick extends Command {

	/**
	 * Continuously set the elevator winch's speed based on co-driver input
	 */
	public ElevatorStick() {
		requires(Robot.elevator);
	}

	@Override
	protected void execute() {
		if(Robot.elevator.isAtBottom()) {
			Robot.elevator.resetEncoder();
		}
		
		Robot.elevator.setSpeed(Robot.oi.getCoDriverAxis(Axis.LEFT_Y)); //Poll co-driver's left Y axis to raise/lower elevator
		
		Logger.log(ErrorCode.GeneralWarning, "Elevator encoder: " + Robot.elevator.getPos());
	}

	@Override
	protected boolean isFinished() {
		return false; //Never finish. Why would we?
	}

	@Override
	protected void end() {
		Robot.elevator.setSpeed(RobotMap.ELEVATOR_STOP); //Stop the elevator on end (interrupt included)
	}
}
