/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.mantis;

import edu.wpi.first.wpilibj.command.Command;
import static frc.robot.Robot.mantis;
import static frc.robot.Robot.elevator;

import frc.robot.RobotMap;

/**
 * TODO: add elevator height for climbing<br>
 * Might need to move this to a commandgroup?
 */
public class MantisSemiAutoClimb extends Command {
	public MantisSemiAutoClimb() {
		requires(mantis);
		requires(elevator);
	}

	@Override
	protected void initialize() {
		setTimeout(1.7);
		elevator.disengageBrake();
	}

	@Override
	protected void execute() {

		//From here on out, lets never put a motor set that is not zero in initialize
		if(mantis.isDown()) {
			mantis.setArmSpeed(RobotMap.MANTIS_ARM_DOWN_SPEED);
		} else {
			mantis.setArmSpeed(RobotMap.ZERO_SPEED);	
		}

		if(isTimedOut()) {
			mantis.setStinger(true);
		}
	}

	@Override
	protected boolean isFinished() {
		return false;
	}
}
