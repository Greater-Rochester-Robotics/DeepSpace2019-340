/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pathing.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.command.WaitForChildren;
import frc.robot.commands.DriveAutoAlign;
import frc.robot.commands.ElevatorExitStartConfig;
import frc.robot.commands.manual.ManualManipulatorWristDown;
import frc.robot.commands.pathing.PathList;
import frc.robot.commands.pathing.RunPath;

public class AutoSequenceRight extends CommandGroup {
	public AutoSequenceRight() {
		addParallel(new RunPath(PathList.LEFT_ROCKET.FAR_HATCH));
		addParallel(new ManualManipulatorWristDown());
		addSequential(new ElevatorExitStartConfig());
		addSequential(new WaitForChildren());
		addSequential(new DriveAutoAlign());
	}
}
