package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.RobotMap;

public class StopPanelMotor extends CommandBase {
    /**
     * @param motor
     */
    public StopPanelMotor(Motor motor) {
        motor.stopMotor();
    }

    public StopPanelMotor() {
        RobotMap.Component.controlPanel.stopMotor();
    }
}
