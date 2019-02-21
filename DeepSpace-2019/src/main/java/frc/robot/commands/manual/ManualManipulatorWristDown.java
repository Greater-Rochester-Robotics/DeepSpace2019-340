/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.manual;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class ManualManipulatorWristDown extends Command {
	public ManualManipulatorWristDown() {
		requires(Robot.manipulatorWithKaChunker);
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
	}

	// Called just before this Command runs the first time
	@Override
	protected void initialize() {
		Robot.manipulatorWithKaChunker.setWristDown();
		// System.out.println("[" + getClass().getName() + "] -Initialize-");
		// System.out.println("[" + getClass().getName() + "] -WristDown-");
	}

	// Called repeatedly when this Command is scheduled to run
	@Override
	protected void execute() {
		// System.out.println("[" + getClass().getName() + "] -Execute-");
		// System.out.println("[" + getClass().getName() + "] -WristDown- " +
		// Robot.manipulatorWithKaChunker.isWristDown());
	}

	// Make this return true when this Command no longer needs to run execute()
	@Override
	protected boolean isFinished() {
		return true;
	}
}
