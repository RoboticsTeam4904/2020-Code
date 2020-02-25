package org.usfirst.frc4904.robot.humaninterface.operators;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.FlywheelSpinUp;
import org.usfirst.frc4904.standard.humaninput.Operator;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
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
		// Indexing + intaking
		RobotMap.HumanInput.Operator.joystick.button2
				.whileHeld(new MotorConstant(RobotMap.Component.intakeRollerMotor, 0.5));
		RobotMap.HumanInput.Operator.joystick.button2.whileHeld(new MotorConstant(RobotMap.Component.funnelMotor, 0.5));
		RobotMap.HumanInput.Operator.joystick.button2
				.whileHeld(new MotorConstant(RobotMap.Component.liftBeltMotor, 0.4));
		// Shooting
		// RobotMap.HumanInput.Operator.joystick.button1.whileHeld(new
		// MotorConstant(RobotMap.Component.flywheelMotorA, 1));
		// RobotMap.HumanInput.Operator.joystick.button1.whileHeld(new
		// MotorConstant(RobotMap.Component.flywheelMotorB, 1));
		RobotMap.HumanInput.Operator.joystick.button1
				.whileHeld(new MotorConstant(RobotMap.Component.runUpBeltMotor, 0.8));
		RobotMap.HumanInput.Operator.joystick.button1
				.whileHeld(new MotorConstant(RobotMap.Component.liftBeltMotor, 0.4));
		// Oh no
		RobotMap.HumanInput.Operator.joystick.button3
				.whileHeld(new MotorConstant(RobotMap.Component.liftBeltMotor, -0.3));

		// RobotMap.HumanInput.Operator.joystick.button12.whileHeld(new
		// FlywheelSpinUp(SmartDashboard.getNumber("flywheelSpeed", 0)));
		// Climber
		// RobotMap.HumanInput.Operator.joystick.button11.whileHeld(new
		// MotorConstant(RobotMap.Component.hookMotor, 0.4));
		// RobotMap.HumanInput.Operator.joystick.button12.whileHeld(new
		// MotorConstant(RobotMap.Component.hookMotor, -0.4));
	}
}