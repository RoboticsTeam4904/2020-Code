package org.usfirst.frc4904.robot.commands.controlpanel;

import org.usfirst.frc4904.standard.commands.motor.MotorIdle;
import org.usfirst.frc4904.robot.RobotMap;

/**
 * A command that will stop the control panel motor.
 */
public class StopPanelMotor extends MotorIdle {

    public StopPanelMotor() {
        super("StopPanelMotor", RobotMap.Component.controlPanel);
    }
}
