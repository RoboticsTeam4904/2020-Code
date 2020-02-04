package org.usfirst.frc4904.robot.commands.controlpanel;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.RobotMap;

/**
 * A command that will stop the control panel motor.
 */
public class StopPanelMotor extends CommandBase {
    private Motor motor;

    /**
     * @param name
     * @param motor The motor that spins the control panel.
     */
    public StopPanelMotor(String name, Motor motor) {
        super();
        setName(name);
        addRequirements(motor);
        this.motor = motor;
    }

    /**
     * @param motor The motor that spins the control panel.
     */
    public StopPanelMotor(Motor motor) {
        this("StopPanelMotor", motor);
    }

    /**
     * @param name
     */
    public StopPanelMotor(String name) {
        this(name, RobotMap.Component.controlPanel);
    }

    public StopPanelMotor() {
        this("StopPanelMotor");
    }

    @Override
    public void initialize() {
        this.motor.stopMotor();
    }
}
