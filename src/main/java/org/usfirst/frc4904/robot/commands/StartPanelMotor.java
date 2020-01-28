package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.RobotMap;

/**
 * A command that will start the control panel motor.
 */
public class StartPanelMotor extends CommandBase {
	private final double SPEED = -1d;
	private Motor motor;

	/**
	 * @param motor The motor to spin the control panel.
	 */
	public StartPanelMotor(Motor motor) {
		super();
		setName("StartPanelMotor");
		addRequirements(motor);

		this.motor = motor;
	}

	@Override
	public void initialize(){
		this.motor.set(SPEED);
	}
}
