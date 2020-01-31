package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.RobotMap;

/**
 * A command that will start the control panel motor.
 */
public class StartPanelMotor extends MotorConstant {
	protected static final double SPEED = -1d; //TODO: Find motor speed value
	protected Motor motor;

	/**
	 * @param motor The motor to spin the control panel.
	 */
	public StartPanelMotor(Motor motor) {
		super("StartPanelMotor", motor, StartPanelMotor.SPEED); 
	}

	public StartPanelMotor() {
		super("StartPanelMotor", RobotMap.Component.controlPanel, StartPanelMotor.SPEED);
	}
}
