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
		RobotMap.HumanInput.Operator.joystick.button12
				.whileHeld(new MotorConstant(RobotMap.Component.intakeRollerMotor, 0.7));
		RobotMap.HumanInput.Operator.joystick.button12.whileHeld(new MotorConstant(RobotMap.Component.funnelMotor, 0.8));
		RobotMap.HumanInput.Operator.joystick.button12
				.whileHeld(new MotorConstant(RobotMap.Component.liftBeltMotor, 0.6));
				RobotMap.HumanInput.Operator.joystick.button2
				.whileHeld(new MotorConstant(RobotMap.Component.intakeRollerMotor, 0.7));
		// Shooting
		// RobotMap.HumanInput.Operator.joystick.button1.whileHeld(new
		// MotorConstant(RobotMap.Component.flywheelMotorA, 1));
		// RobotMap.HumanInput.Operator.joystick.button1.whileHeld(new
		// MotorConstant(RobotMap.Component.flywheelMotorB, 1));
		RobotMap.HumanInput.Operator.joystick.button3.whileHeld(new MotorConstant(RobotMap.Component.funnelMotor, 1));
		RobotMap.HumanInput.Operator.joystick.button3
				.whileHeld(new MotorConstant(RobotMap.Component.runUpBeltMotor, 1));
		RobotMap.HumanInput.Operator.joystick.button3
				.whileHeld(new MotorConstant(RobotMap.Component.liftBeltMotor, 1));
		// Oh no
		RobotMap.HumanInput.Operator.joystick.button4
				.whileHeld(new MotorConstant(RobotMap.Component.liftBeltMotor, -0.5));
		RobotMap.HumanInput.Operator.joystick.button4
				.whileHeld(new MotorConstant(RobotMap.Component.runUpBeltMotor, -0.5));

		// RobotMap.HumanInput.Operator.joystick.button12.whileHeld(new
		// FlywheelSpinUp(SmartDashboard.getNumber("flywheelSpeed", 0)));
		// Climber
		// RobotMap.HumanInput.Operator.joystick.button11.whileHeld(new
		// MotorConstant(RobotMap.Component.hookMotor, 0.4));
		// RobotMap.HumanInput.Operator.joystick.button12.whileHeld(new
		// MotorConstant(RobotMap.Component.hookMotor, -0.4));
		// RobotMap.HumanInput.Operator.joystick.button3.whileHeld(new
		// FlywheelSpinUp(50));
		RobotMap.HumanInput.Operator.joystick.button1
				.whileHeld(new MotorConstant(RobotMap.Component.flywheelMotorA, 0.5));
		RobotMap.HumanInput.Operator.joystick.button1
				.whileHeld(new MotorConstant(RobotMap.Component.flywheelMotorB, 0.5));
		RobotMap.HumanInput.Operator.joystick.button5
				.whileHeld(new MotorConstant(RobotMap.Component.controlPanel, 0.75));
		// RobotMap.HumanInput.Operator.joystick.button3.onlyWhileHeld(new
		// MotorConstant(RobotMap.Component.flywheelMotorB, 0.5));
	}
}