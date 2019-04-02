/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.manipulatorWithKaChunker;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.manipulatorWithKaChunker;
import frc.robot.RobotMap;

/**
 * Use the C to intake cargo<br>
 * It's not impossible to imagine this will have some PID at some point
 */
public class CIntakeFloor extends Command {
	
	/**
	 * Step 1: intake<br>
	 * Step 2: stop intake when sensors scream<br>
	 * Step 3: flip wrist up
	 */
	public CIntakeFloor() {
		requires(manipulatorWithKaChunker);
	}

	@Override
	protected void initialize() {
		manipulatorWithKaChunker.setWristDown(); //Wrist tips down if not already
		manipulatorWithKaChunker.setCSpeed(RobotMap.C_INTAKE_SPEED, false); //Roll wheels inward the instant this command begins
	}

	@Override
	protected boolean isFinished() {
		return manipulatorWithKaChunker.hasCargo(); //Continue rolling until acquisition complete
	}

	@Override
	protected void end() {
		manipulatorWithKaChunker.setCSpeed(RobotMap.C_STALL_SPEED, true); //On interrupt or cargo acquisition, stall the wheels
		manipulatorWithKaChunker.setWristUp();
	}

	@Override
	protected void interrupted() {} //Do nothing on interrupt
}
