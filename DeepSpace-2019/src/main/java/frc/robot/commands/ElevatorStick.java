/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands;

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
	protected void initialize() {
		Robot.elevator.remindFollow();
	}

	@Override
	protected void execute() {
		//In case we reach the bottom of the elevator, reset the encoder
		if(Robot.elevator.isAtBottom()) {
			Robot.elevator.resetEncoder();
		}

		Robot.elevator.setSpeedScaled(-Robot.oi.getCoDriverAxis(Axis.LEFT_Y) * RobotMap.ELEVATOR_SPEED_MULTIPLIER); //Poll co-driver's left Y axis to raise/lower elevator. Negative to account for axis directionality
	}

	@Override
	protected boolean isFinished() {
		return false; //Never finish. This command ends only when interupted.
	}

	@Override
	protected void end() {
		Robot.elevator.setSpeed(RobotMap.ZERO_SPEED); //Stop the elevator on end (interrupt included)
	}
}
