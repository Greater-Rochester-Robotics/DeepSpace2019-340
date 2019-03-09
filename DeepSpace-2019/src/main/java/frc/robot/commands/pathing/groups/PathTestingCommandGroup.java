/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.pathing.groups;

import edu.wpi.first.wpilibj.command.CommandGroup;
import frc.robot.commands.pathing.PathList;
import frc.robot.commands.pathing.RunPath;

public class PathTestingCommandGroup extends CommandGroup {

	/**
	 * Add your docs here.
	 */
	public PathTestingCommandGroup() {
		// addSequential(new RunPath(PathList.LEFT_ROCKET.TWO_HATCH_INITIAL_TESTING, x -> .5));
		addSequential(new RunPath(PathList.RIGHT_ROCKET.ONE_HATCH_INITIAL_TESTING, x -> {
			if(x < .1) {
				return .3;
			} else if(x < .85) {
				return .7;
			} else {
				return .3;
			}
		}));
		// addSequential(new RunPath(new Path(new PathSegment(t -> 0.0, 20)), x -> .7));
	}
}