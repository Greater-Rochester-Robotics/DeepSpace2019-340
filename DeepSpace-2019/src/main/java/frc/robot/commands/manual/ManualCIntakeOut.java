/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot.commands.manual;

import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import frc.robot.RobotMap;

public class ManualCIntakeOut extends Command {
  public ManualCIntakeOut() {
	  requires(Robot.manipulatorWithKaChunker);
  }

  // Called just before this Command runs the first time
  @Override
  protected void initialize() {
	  Robot.manipulatorWithKaChunker.setCSpeed(RobotMap.C_OUTTAKE_SPEED, false);
	  System.out.println("[" + getClass().getName() + "] -Initialize-");
	  System.out.println("[" + getClass().getName() + "] -CIntakeOut-");
	  System.out.println("[" + getClass().getName() + "] -CIntakeSensors- " + Robot.manipulatorWithKaChunker.hasCargo());
  }

  // Called repeatedly when this Command is scheduled to run
  @Override
  protected void execute() {
	  System.out.println("[" + getClass().getName() + "] -Execute-");
	  System.out.println("[" + getClass().getName() + "] -CIntakeSpeed- " + Robot.manipulatorWithKaChunker.getCSpeed());
  }
  // Make this return true when this Command no longer needs to run execute()
  @Override
  protected boolean isFinished() {
    return true;
  }

  // Called once after isFinished returns true
  @Override
  protected void end() {
  }

  // Called when another command which requires one or more of the same
  // subsystems is scheduled to run
  @Override
  protected void interrupted() {
  }
}
