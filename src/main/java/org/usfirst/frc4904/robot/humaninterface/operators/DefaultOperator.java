package org.usfirst.frc4904.robot.humaninterface.operators;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.FlywheelMaintainSpeed;
import org.usfirst.frc4904.robot.commands.FlywheelSpinUp;
import org.usfirst.frc4904.standard.humaninput.Operator;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.commands.motor.MotorVelocitySet;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;

public class DefaultOperator extends Operator {
	public DefaultOperator() {
		super("DefaultOperator");
	}

	public DefaultOperator(String name) {
		super(name);
	}

	@Override
	public void bindCommands() {
		// RobotMap.HumanInput.Operator.joystick.button3.whileHeld(new
		// MotorConstant(RobotMap.Component.flywheelMotorA, 0.5));
		// RobotMap.HumanInput.Operator.joystick.button4.whileHeld(new
		// MotorConstant(RobotMap.Component.flywheelMotorB, 0.5));
		RobotMap.HumanInput.Operator.joystick.button3.whileHeld(new FlywheelSpinUp(70.0));
		// RobotMap.HumanInput.Operator.joystick.button3.onlyWhileHeld(new
		// MotorVelocitySet(RobotMap.Component.flywheelMotorB, 50));

	}
}