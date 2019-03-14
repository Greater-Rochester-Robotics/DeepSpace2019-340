/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pathing.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.ElevatorToBottom;
import frc.robot.commands.manual.ManualElevatorTiltForward;
import frc.robot.commands.manual.ManualManipulatorWristDown;
import frc.robot.commands.pathing.PathList;
import frc.robot.commands.pathing.RunPath;

public class AutoSequenceRight extends CommandGroup {

	public AutoSequenceRight() {
		addParallel(new RunPath(PathList.RIGHT_ROCKET.CLOSE_HATCH_LEFT_BASED, x -> .4));
		addParallel(new ManualManipulatorWristDown());
		addSequential(new ManualElevatorTiltForward());
		addSequential(new ElevatorToBottom());
	}
}
