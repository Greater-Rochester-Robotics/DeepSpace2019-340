/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.mantis;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

/**
 * TODO: this could use a rework
 */
public class ClimbStingerAndMantisArmsDown extends Command {
  public ClimbStingerAndMantisArmsDown() {
    requires(Robot.mantis);
    // Use requires() here to declare subsystem dependencies
    // eg. requires(chassis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
    if(!Robot.mantis.isDown()) {
      Robot.mantis.setArmSpeed(RobotMap.MANTIS_ARM_DOWN_SPEED);
	}
	
    Robot.mantis.setStinger(true);
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return (!Robot.isBackHigh());
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
	Robot.mantis.setArmSpeed(RobotMap.ZERO_SPEED);
  }
}
