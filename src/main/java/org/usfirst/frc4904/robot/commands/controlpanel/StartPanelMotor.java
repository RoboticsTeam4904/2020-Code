package org.usfirst.frc4904.robot.commands.controlpanel;

import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.RobotMap;

/**
 * A command that will start the control panel motor.
 */
public class StartPanelMotor extends MotorConstant {
	protected static final double SPEED = -1d; // TODO: Find motor speed value
	protected Motor motor;

	/**
	 * @param name
	 * @param motor The motor to spin the control panel.
	 */
	public StartPanelMotor(String name, Motor motor) {
		super(name, motor, StartPanelMotor.SPEED);
	}

	/**
	 * @param motor The motor to spin the control panel.
	 */
	public StartPanelMotor(Motor motor) {
		this("StartPanelMotor", motor);
	}

	/**
	 * @param name
	 */
	public StartPanelMotor(String name) {
		this(name, RobotMap.Component.controlPanel);
	}

	public StartPanelMotor() {
		this("StartPanelMotor");
	}
}
