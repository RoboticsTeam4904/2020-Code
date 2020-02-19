package org.usfirst.frc4904.robot.commands.controlpanel;

import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.RobotMap;

/**
 * A command that will start the control panel motor.
 */
public class SpinPanelMotor extends MotorConstant {
	protected static final double START_SPEED = 0; // TODO: Find motor speed value
	protected Motor motor;

	public SpinPanelMotor(String name, double speed) {
		super(name, RobotMap.Component.controlPanel, speed);
	}
}
