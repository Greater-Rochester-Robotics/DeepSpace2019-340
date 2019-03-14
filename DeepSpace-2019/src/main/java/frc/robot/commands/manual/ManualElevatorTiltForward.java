/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.manual;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ManualElevatorTiltForward extends Command {
	public ManualElevatorTiltForward() {
		requires(Robot.elevator);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.elevator.tiltForward();
		// System.out.println("[" + getClass().getName() + "] -Initialize-");
		// System.out.println("[" + getClass().getName() + "] -ElevatorTiltForward-");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		// System.out.println("[" + getClass().getName() + "] -Execute-");
		// System.out.println("[" + getClass().getName() + "] -ElevatorTiltForward- " + Robot.elevator.isTiltedForward());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return timeSinceInitialized() >= 1;
	}
}
