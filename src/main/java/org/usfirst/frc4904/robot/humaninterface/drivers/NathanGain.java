package org.usfirst.frc4904.robot.humaninterface.drivers;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.ClimberMoveHook;
import org.usfirst.frc4904.robot.commands.ClimberMoveWinch;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.humaninput.Driver;

public class NathanGain extends Driver {
	public static final double SPEED_GAIN = 1;
	public static final double SPEED_EXP = 2;
	public static final double TURN_GAIN = 0.7;
	public static final double TURN_EXP = 1;
	public static final double Y_SPEED_SCALE = 1;
	public static final double TURN_SPEED_SCALE = 1;

	public NathanGain() {
		super("NathanGain");
	}

	protected double scaleGain(double input, double gain, double exp) {
		return Math.pow(Math.abs(input), exp) * gain * Math.signum(input);
	}

	@Override
	public void bindCommands() {
		RobotMap.HumanInput.Driver.xbox.lb.whileHeld(new ClimberMoveHook());
		RobotMap.HumanInput.Driver.xbox.rb.whileHeld(new RunIf(new ClimberMoveWinch(), () -> {
			return RobotMap.HumanInput.Driver.xbox.getAxis(CustomXbox.RIGHT_Y_AXIS) >= 0;
		}));
	}

	@Override
	public double getX() {
		return 0;
	}

	@Override
	public double getY() {
		double rawSpeed = RobotMap.HumanInput.Driver.xbox.rt.getX() - RobotMap.HumanInput.Driver.xbox.lt.getX();
		double speed = scaleGain(rawSpeed, NathanGain.SPEED_GAIN, NathanGain.SPEED_EXP) * NathanGain.Y_SPEED_SCALE;
		return speed;
	}

	@Override
	public double getTurnSpeed() {
		double rawTurnSpeed = RobotMap.HumanInput.Driver.xbox.leftStick.getX();
		double turnSpeed = scaleGain(rawTurnSpeed, NathanGain.TURN_GAIN, NathanGain.TURN_EXP)
				* NathanGain.TURN_SPEED_SCALE;
		return turnSpeed;
	}
}