/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.manipulatorWithKaChunker;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;

import static frc.robot.Robot.manipulatorWithKaChunker;

public class CIntakeWall extends Command {

	/**
	 * Step 1: intake
	 * Step 2: stop intaking when sensors get vv upset
	 */
	public CIntakeWall() {
		requires(manipulatorWithKaChunker);
	}

	@Override
	protected void initialize() {
		manipulatorWithKaChunker.setWristUp(); //Wrist tips up if not already
		manipulatorWithKaChunker.setCSpeed(RobotMap.C_INTAKE_SPEED, false); //Spin wheels as soon as command starts
	}

	@Override
	protected boolean isFinished() {
		return manipulatorWithKaChunker.hasCargo(); //Continue rolling until acquisition complete
	}

	@Override
	protected void end() {
		manipulatorWithKaChunker.setCSpeed(RobotMap.C_STALL_SPEED, true); //Stall the wheels when done
	}

	@Override
	protected void interrupted() {} //Do nothing on interrupt
}
