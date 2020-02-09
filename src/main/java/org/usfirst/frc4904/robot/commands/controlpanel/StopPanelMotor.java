package org.usfirst.frc4904.robot.commands.controlpanel;

import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.RobotMap;

/**
 * A command that will stop the control panel motor.
 */
public class StopPanelMotor extends MotorIdle {

    /**
     * @param name
     * @param motor The motor that spins the control panel.
     */
    public StopPanelMotor(String name, Motor motor) {
        super(name, motor);
    }

    /**
     * @param motor The motor that spins the control panel.
     */
    public StopPanelMotor(Motor motor) {
        this("StopPanelMotor", motor);
    }

    /**
     * @param name The name of the command
     */
    public StopPanelMotor(String name) {
        this(name, RobotMap.Component.controlPanel);
    }

    public StopPanelMotor() {
        this("StopPanelMotor");
    }
}
