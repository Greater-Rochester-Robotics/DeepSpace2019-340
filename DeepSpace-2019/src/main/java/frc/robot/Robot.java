/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.commands.DriveXOne;
import frc.robot.commands.cheeseclimb.Cheeseclimber;
import frc.robot.subsystems.ManipulatorWithKaChunker;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elevator;
import frc.robot.subsystems.Mantis;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {
	public static Cheeseclimber cheeseclimber;
	public static Drive drive;
	public static Elevator elevator;
	public static ManipulatorWithKaChunker manipulatorWithKaChunker;
	public static Mantis mantis;

	private static DigitalInput frontSensor = new DigitalInput(RobotMap.FRONT_DOWN_CHANNEL);
	private static DigitalInput backSensor = new DigitalInput(RobotMap.BACK_DOWN_CHANNEL);

	public static Compressor compressor;

	public static OI oi;

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be used
	 * for any initialization code.
	 */
	@Override
	public void robotInit() {
		cheeseclimber = new Cheeseclimber(0, 1, 2);
		drive = new Drive();
		elevator = new Elevator();
		manipulatorWithKaChunker = new ManipulatorWithKaChunker();
		mantis = new Mantis();
		compressor = new Compressor(RobotMap.SECONDARY_PCM_ID);
		oi = new OI();
		// SmartDashboard.putData(drive);
		// SmartDashboard.putData(elevator);
		// SmartDashboard.putData(manipulatorWithKaChunker);
		// SmartDashboard.putData(mantis);
		m_chooser.setDefaultOption("Default Auto", new DriveXOne()); //I suppose that's one way to do it
		// chooser.addOption("My Auto", new MyAutoCommand());
		SmartDashboard.putData("Auto mode", m_chooser);

		drive.gyroCalibrate();
		drive.gyroReset();

		CameraServer.getInstance().startAutomaticCapture();
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("ledMode").setNumber(3);
	}

	/**
	 * This function is called every robot packet, no matter the mode. Use this for
	 * items like diagnostics that you want ran during disabled, autonomous,
	 * teleoperated and test.
	 *
	 * <p>
	 * This runs after the mode specific periodic functions, but before LiveWindow
	 * and SmartDashboard integrated updating.
	 */
	@Override
	public void robotPeriodic() {
	}

	/**
	 * This function is called once each time the robot enters Disabled mode. You
	 * can use it to reset any subsystem information you want to clear when the
	 * robot is disabled.
	 */
	@Override
	public void disabledInit() {
		compressor.stop();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable chooser
	 * code works with the Java SmartDashboard. If you prefer the LabVIEW Dashboard,
	 * remove all of the chooser code and uncomment the getString code to get the
	 * auto name from the text box below the Gyro
	 *
	 * <p>
	 * You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons to
	 * the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		m_autonomousCommand = m_chooser.getSelected();

		compressor.start();
		NetworkTableInstance.getDefault().getTable("limelight").getEntry("camMode").setNumber(1);

		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector", "Default");
		 * switch(autoSelected) { case "My Auto": autonomousCommand = new
		 * MyAutoCommand(); break; case "Default Auto": default: autonomousCommand = new
		 * ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (m_autonomousCommand != null) {
			m_autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		Scheduler.getInstance().run();
	}

	@Override
	public void teleopInit() {
		compressor.start();

		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		if (m_autonomousCommand != null && !(m_autonomousCommand instanceof DriveXOne)) { //Keep driving if that's our auto
			m_autonomousCommand.cancel();
		}

		// new AutoSequence().start(); //start autos
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		SmartDashboard.putNumber("leftenc",  drive.getLeftDistance());
		SmartDashboard.putNumber("rightenc", drive.getRightDistance());
		SmartDashboard.putNumber("yaw", drive.getRotation());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}

	/**
	 * Returns whether or not the front sensor can see the ground.
	 * 
	 * @return False if the front is on the ground.
	 */
	public static boolean isFrontHigh() {
		return Robot.frontSensor.get();
	}

	/**
	 * Returns whether or not the back sensor can see the ground.
	 * 
	 * @return False if the back is on the ground.
	 */
	public static boolean isBackHigh() {
		return Robot.backSensor.get();
	}
}
