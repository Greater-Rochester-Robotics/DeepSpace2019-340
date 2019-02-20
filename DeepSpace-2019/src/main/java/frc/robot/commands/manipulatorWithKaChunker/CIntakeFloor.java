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
		manipulatorWithKaChunker.setWristDown();
		manipulatorWithKaChunker.setCSpeed(RobotMap.C_INTAKE_SPEED); //Roll wheels inward the instant this command begins
	}

	//Will this work? :thonk:
	@Override
	protected void execute() {
		if(manipulatorWithKaChunker.hasCargo()) {
			setTimeout(.1 + timeSinceInitialized());
		}
	}

	@Override
	protected boolean isFinished() {
		return manipulatorWithKaChunker.hasCargo() && isTimedOut(); //Continue rolling until interrupt or cargo acquisition
	}

	@Override
	protected void end() {
		manipulatorWithKaChunker.setCSpeed(RobotMap.ZERO_SPEED); //On interrupt or cargo acquisition, stop the wheels
		manipulatorWithKaChunker.setWristUp();
	}

	@Override
	protected void interrupted() {
		manipulatorWithKaChunker.setCSpeed(RobotMap.ZERO_SPEED);
	}
}
