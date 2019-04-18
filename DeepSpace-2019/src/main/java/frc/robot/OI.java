/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.GenericHID.RumbleType;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.robot.commands.manipulatorWithKaChunker.CIntakeWall;
import frc.robot.commands.DriveXOne;
import frc.robot.commands.DriveXOneWithMantis;
import frc.robot.commands.ElevatorStick;
import frc.robot.commands.ElevatorToPosition;
import frc.robot.commands.DriveAutoAlign;
import frc.robot.commands.manipulatorWithKaChunker.CIntakeFloor;
import frc.robot.commands.manipulatorWithKaChunker.CRocketRelease;
import frc.robot.commands.manipulatorWithKaChunker.CShipRelease;
import frc.robot.commands.manipulatorWithKaChunker.CStall;
import frc.robot.commands.manipulatorWithKaChunker.KaChunkerAutoAcquire;
import frc.robot.commands.mantis.MantisSemiAutoClimb;
import frc.robot.commands.mantis.MantisStopClimb;
import frc.robot.commands.manual.ManualCIntakeIn;
import frc.robot.commands.manual.ManualCIntakeStop;
import frc.robot.commands.manual.ManualElevatorTiltBack;
import frc.robot.commands.manual.ManualElevatorTiltForward;
import frc.robot.commands.manual.ManualKaChunkerGrab;
import frc.robot.commands.manual.ManualKaChunkerRelease;
import frc.robot.commands.manual.ManualManipulatorWristDown;
import frc.robot.commands.manual.ManualManipulatorWristUp;
import frc.robot.commands.manual.ManualMantisArmDown;
import frc.robot.commands.manual.ManualMantisArmStop;
import frc.robot.commands.manual.ManualMantisArmUp;
import frc.robot.commands.manual.ManualMantisStingerUp;
import frc.robot.commands.pathing.groups.AutoSequenceLeft;
import frc.robot.commands.pathing.groups.AutoSequenceRight;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	private Joystick driver = new Joystick(0);
	private Joystick coDriver = new Joystick(1);

	////////////////////
	// DRIVER BUTTONS //
	////////////////////

	private Button driverA = new JoystickButton(driver, 1);
	private Button driverB = new JoystickButton(driver, 2);
	private Button driverX = new JoystickButton(driver, 3);
	private Button driverY = new JoystickButton(driver, 4);
	private Button driverLB = new JoystickButton(driver, 5);
	private Button driverRB = new JoystickButton(driver, 6);
	private Button driverBack = new JoystickButton(driver, 7);
	private Button driverStart = new JoystickButton(driver, 8);
	private Button driverLS = new JoystickButton(driver, 9);
	private Button driverRS = new JoystickButton(driver, 10);
	private Button driverDUp = new DPad(driver, DPad.Direction.UP);
	private Button driverDDown = new DPad(driver, DPad.Direction.DOWN);
	private Button driverDLeft = new DPad(driver, DPad.Direction.LEFT);
	private Button driverDRight = new DPad(driver, DPad.Direction.RIGHT);
	private Button driverLTButton = new JoyTriggerButton(driver, .3, Axis.LEFT_TRIGGER);
	private Button driverRTButton = new JoyTriggerButton(driver, .3, Axis.RIGHT_TRIGGER);

	///////////////////////
	// CO-DRIVER BUTTONS //
	///////////////////////

	private Button coDriverA = new JoystickButton(coDriver, 1);
	private Button coDriverB = new JoystickButton(coDriver, 2);
	private Button coDriverX = new JoystickButton(coDriver, 3);
	private Button coDriverY = new JoystickButton(coDriver, 4);
	private Button coDriverLB = new JoystickButton(coDriver, 5);
	private Button coDriverRB = new JoystickButton(coDriver, 6);
	private Button coDriverBack = new JoystickButton(coDriver, 7);
	private Button coDriverStart = new JoystickButton(coDriver, 8);
	private Button coDriverLS = new JoystickButton(coDriver, 9);
	private Button coDriverRS = new JoystickButton(coDriver, 10);
	private Button coDriverDUp = new DPad(coDriver, DPad.Direction.UP);
	private Button coDriverDDown = new DPad(coDriver, DPad.Direction.DOWN);
	private Button coDriverDLeft = new DPad(coDriver, DPad.Direction.LEFT);
	private Button coDriverDRight = new DPad(coDriver, DPad.Direction.RIGHT);
	private Button coDriverLTButton = new JoyTriggerButton(coDriver, .7, Axis.LEFT_TRIGGER);
	private Button coDriverRTButton = new JoyTriggerButton(coDriver, .7, Axis.RIGHT_TRIGGER);
	
	public OI() {
		//Creation of Driver Buttons Commands
		driverA.whenPressed(new CIntakeFloor());
		driverA.whenReleased(new CStall());
		driverB.whenPressed(new CRocketRelease());
		driverB.whenReleased(new ManualCIntakeStop());
		driverX.whenPressed(new CIntakeWall());
		driverX.whenReleased(new CStall());
		driverY.whenPressed(new CShipRelease());
		driverY.whenReleased(new ManualCIntakeStop());
		driverRB.whenPressed(new KaChunkerAutoAcquire());
		driverRB.whenReleased(new ManualKaChunkerGrab());
		driverLB.whenPressed(new ManualKaChunkerRelease());
		driverLB.whenPressed(new ManualKaChunkerGrab());
		driverDDown.whenPressed(new ManualManipulatorWristDown());
		driverDUp.whenPressed(new ManualManipulatorWristUp());
		driverLTButton.whenPressed(new DriveAutoAlign());
		driverLTButton.whenReleased(new DriveXOne());
		// driverRTButton.whenPressed(new ManualCIntakeIn());
		

		driverDRight.whenPressed(new DriveXOneWithMantis());
		driverDLeft.whenPressed(new DriveXOne());

		//Creation of CoDriver Buttons Commands
		coDriverA.whenPressed(new ManualMantisArmDown());
		coDriverA.whenReleased(new ManualMantisArmStop());
		coDriverB.whenPressed(new ElevatorToPosition(RobotMap.ELEVATOR_LEVEL_2_HEIGHT));
		coDriverX.whenPressed(new ElevatorStick());
		coDriverY.whenPressed(new ElevatorToPosition(RobotMap.ELEVATOR_LEVEL_3_HEIGHT));
		coDriverLB.whenPressed(new ManualElevatorTiltBack());
		coDriverRB.whenPressed(new ManualElevatorTiltForward());
		coDriverDDown.whenPressed(new MantisSemiAutoClimb());
		coDriverDDown.whenReleased(new MantisStopClimb());
		coDriverDUp.whenPressed(new ManualMantisStingerUp());
		coDriverDLeft.whenPressed(new ManualMantisArmUp());
		coDriverDLeft.whenReleased(new ManualMantisArmStop());
		coDriverLTButton.whenPressed(new AutoSequenceLeft());
		coDriverLTButton.whenReleased(new DriveXOne());
		coDriverRTButton.whenPressed(new AutoSequenceRight());
		coDriverRTButton.whenReleased(new DriveXOne());
	}

	public enum Axis {
		LEFT_X(0),
		LEFT_Y(1),
		LEFT_TRIGGER(2),
		RIGHT_TRIGGER(3),
		RIGHT_X(4),
		RIGHT_Y(5);

		private int axis;

		private Axis(int axis) {
			this.axis = axis;
		}

		public int getAxisNumber() {
			return axis;
		}
	}

	/**
	 * 
	 * @param axis
	 * @return
	 */
	public double getDriverAxis(Axis axis) {
		return (driver.getRawAxis(axis.getAxisNumber()) < -.1 || driver.getRawAxis(axis.getAxisNumber()) > .1 ) ? driver.getRawAxis(axis.getAxisNumber()) : 0;
	}

	/**
	 * Accessor method to set driver rumble function
	 * @param leftRumble
	 * @param rightRumble
	 */
	public void setDriverRumble (double leftRumble, double rightRumble){
		driver.setRumble(RumbleType.kLeftRumble, leftRumble);
		driver.setRumble(RumbleType.kRightRumble, rightRumble);
	}
	/**
	 * 
	 * @param axis
	 * @return
	 */
	public double getCoDriverAxis(Axis axis) {
		return (coDriver.getRawAxis(axis.getAxisNumber()) < -.1 || coDriver.getRawAxis(axis.getAxisNumber()) > .1 ) ? coDriver.getRawAxis(axis.getAxisNumber()) : 0;
	}
}
