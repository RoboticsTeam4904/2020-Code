package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.RobotMap;

/**
 * A command that will stop the control panel motor.
 */
public class StopPanelMotor extends CommandBase {
    private Motor motor;

    /**
     * @param motor The motor to spin the control panel.
     */

    public StopPanelMotor(Motor motor) {
        super();
        setName("StopPanelMotor");
        addRequirements(motor);

        this.motor = motor;
    }

    public StopPanelMotor() {
        super();
        setName("StopPanelMotor");
        this.motor = RobotMap.Component.controlPanel;
        addRequirements(this.motor); // neccesary?
    }

    @Override
    public void initialize() {
        this.motor.stopMotor();
    }
}
