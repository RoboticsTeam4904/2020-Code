package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.RobotMap;

/**
 * A command that will start the control panel motor (pretty self-explanatory).
 */
public class StartPanelMotor extends CommandBase {
	/**
	 * @param motor
	 */
	public StartPanelMotor(Motor motor) {
		Double speed = -1d; // TODO: determine the actual optimal speed for the control panel motor
		motor.set(speed);
	}
	public StartPanelMotor() {
        Double speed = -1d; // TODO: determine the actual optimal speed for the control panel motor
		RobotMap.Component.controlPanel.set(speed);
	}
}
