/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.mantis;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.RobotMap;
import frc.robot.Robot;

public class ClimbMantisArmsDown extends Command {
  public ClimbMantisArmsDown() {
    requires(Robot.mantis);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
    if(!Robot.mantis.isDown()) {
        Robot.mantis.setArmSpeed(RobotMap.MANTIS_ARM_DOWN);
    }
  }

  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return Robot.mantis.isDown() || Robot.isFrontHigh() || Robot.isBackHigh();
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
    Robot.mantis.setArmSpeed(RobotMap.ZERO_SPEED);
  }
}
