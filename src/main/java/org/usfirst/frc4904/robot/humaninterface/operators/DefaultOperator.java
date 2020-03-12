package org.usfirst.frc4904.robot.humaninterface.operators;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.FlywheelMaintainSpeed;
import org.usfirst.frc4904.robot.commands.FlywheelSpinUp;
import org.usfirst.frc4904.robot.commands.FlywheelThroughThreshold;
import org.usfirst.frc4904.robot.commands.FlywheelToSpeed;
import org.usfirst.frc4904.robot.commands.SetHoodAngle;
import org.usfirst.frc4904.robot.commands.ZeroHood;
import org.usfirst.frc4904.standard.humaninput.Operator;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.standard.commands.chassis.ChassisShift;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.commands.motor.MotorControl;
import org.usfirst.frc4904.standard.commands.motor.MotorVelocitySet;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;


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
		// RobotMap.HumanInput.Operator.joystick.button3.whileHeld(new
		// FlywheelSpinUp(70.0));
		// RobotMap.HumanInput.Operator.joystick.button3.onlyWhileHeld(new
		// MotorVelocitySet(RobotMap.Component.flywheelMotorB, 50));

		RobotMap.HumanInput.Operator.joystick.button12
				.whileHeld(new MotorConstant(RobotMap.Component.intakeRollerMotor, 0.7));
		RobotMap.HumanInput.Operator.joystick.button12
				.whileHeld(new MotorConstant(RobotMap.Component.funnelMotor, 0.8));
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
		RobotMap.HumanInput.Operator.joystick.button3.whileHeld(new MotorConstant(RobotMap.Component.liftBeltMotor, 1));
		// Oh no
		RobotMap.HumanInput.Operator.joystick.button4
				.whileHeld(new MotorConstant(RobotMap.Component.liftBeltMotor, -0.5));
		RobotMap.HumanInput.Operator.joystick.button4
				.whileHeld(new MotorConstant(RobotMap.Component.runUpBeltMotor, -0.5));

		// RobotMap.HumanInput.Operator.joystick.button7.whileHeld(new MotorControl(RobotMap.Component.hood, RobotMap.HumanInput.Operator.joystick, 1, .2));

		// RobotMap.HumanInput.Operator.joystick.button8.whenPressed(new ZeroHood());

		// RobotMap.HumanInput.Operator.joystick.button9.whenPressed(new SetHoodAngle(10));

		// RobotMap.HumanInput.Operator.joystick.button12.whileHeld(new
		// FlywheelSpinUp(SmartDashboard.getNumber("flywheelSpeed", 0)));
		// Climber
		// RobotMap.HumanInput.Operator.joystick.button7.whenPressed(new ChassisShift(RobotMap.Component.chassis.getShifter(), SolenoidShifters.SolenoidState.RETRACT));
		// RobotMap.HumanInput.Operator.joystick.button8.whenPressed(new ChassisShift(RobotMap.Component.chassis.getShifter(), SolenoidShifters.SolenoidState.EXTEND));
		// RobotMap.HumanInput.Operator.joystick.button9.whenPressed(new SolenoidRetract(RobotMap.Component.intakeSolenoid));
		// RobotMap.HumanInput.Operator.joystick.button10.whenPressed(new SolenoidExtend(RobotMap.Component.intakeSolenoid));
		
		// RobotMap.HumanInput.Operator.joystick.button11.whileHeld(new
		// MotorConstant(RobotMap.Component.hookMotor, 0.4));
		// RobotMap.HumanInput.Operator.joystick.button12.whileHeld(new
		// MotorConstant(RobotMap.Component.hookMotor, -0.4));
		// RobotMap.HumanInput.Operator.joystick.button1.whileHeld(new FlywheelThroughThreshold(RobotMap.Component.flywheel, 58.0));
		// RobotMap.HumanInput.Operator.joystick.button1.whileHeld(new FlywheelSpinUp(58.0));
		// RobotMap.HumanInput.Operator.joystick.button1.whileHeld(new FlywheelToSpeed(RobotMap.Component.flywheel, 58.0));
		RobotMap.HumanInput.Operator.joystick.button1.whileHeld(new FlywheelMaintainSpeed(RobotMap.Component.flywheel, 58.0));
		RobotMap.HumanInput.Operator.joystick.button5.whenPressed(new SolenoidExtend(RobotMap.Component.intakeSolenoid));
		RobotMap.HumanInput.Operator.joystick.button6.whenPressed(new SolenoidRetract(RobotMap.Component.intakeSolenoid));

		// RobotMap.HumanInput.Operator.joystick.button2.whileHeld(new MotorConstant(RobotMap.Component.flywheel, ((CustomPIDController) RobotMap.Component.flywheel.getMC()).getF() * 58.0));
		// RobotMap.HumanInput.Operator.joystick.button1.whileHeld(new RunUntil("runtest", new MotorConstant(RobotMap.Component.flywheel, ((CustomPIDController) RobotMap.Component.flywheel.getMC()).getF() * 58.0), () -> {
		// 	return RobotMap.HumanInput.Operator.joystick.button11.get();
		// }, false));
		// RobotMap.HumanInput.Operator.joystick.button1.whileHeld(new MotorConstant(RobotMap.Component.testMotor, 0.5));
		// RobotMap.HumanInput.Operator.joystick.button5
		// .whileHeld(new MotorConstant(RobotMap.Component.controlPanel, 0.75));

	}
}