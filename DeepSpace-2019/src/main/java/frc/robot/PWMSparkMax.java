/*----------------------------------------------------------------------------*/
/* Copyright (c) 2018 FIRST. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

import edu.wpi.first.hal.HAL;
import edu.wpi.first.hal.FRCNetComm.tResourceType;
import edu.wpi.first.wpilibj.Spark;

/**
 * Sparx MAX controlled via PWM<br>
 * A few numbers switched and voila
 */
public class PWMSparkMax extends Spark {

	/**
	 * @param channel PWM channel controlling the Spark MAX
	 */
	public PWMSparkMax(final int channel) {
		super(channel);
	}

	/**
	 * Identical to {@link Spark#initSpark()} except for the PWM timing bounds.
	 * These bounds were found on the REV Robotics website<br>
	 * http://www.revrobotics.com/sparkmax-users-manual/#section-3-3-1<br>
	 * <br>
	 * Max, 2.003ms | neutral high, 1.525ms<br>
	 * center, 1.5ms | neutral low, 1.475ms<br>
	 * minimum, .999ms<br>
	 * <br>
	 * Two of these numbers are noticably a few microseconds from their official
	 * values. I do this for no other reason than the official libraries doing
	 * so when the Spark and Spark MAX have matching numbers
	 */
	@Override
	protected void initSpark() {
		setBounds(2.003, 1.525, 1.5, 1.475, .999);
		setPeriodMultiplier(PeriodMultiplier.k1X);
		setSpeed(0.0);
		setZeroLatch();

		HAL.report(tResourceType.kResourceType_RevSPARK, getChannel());
		setName("Spark", getChannel());
	}
}
