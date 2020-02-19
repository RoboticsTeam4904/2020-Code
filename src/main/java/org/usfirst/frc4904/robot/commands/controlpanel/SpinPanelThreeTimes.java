package org.usfirst.frc4904.robot.commands.controlpanel;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import org.usfirst.frc4904.standard.commands.RunUntil;

import org.usfirst.frc4904.robot.RobotMap;

/**
 * Spin the Control Panel three times based on encoder readings and the ratio of
 * control panel diameter to our control panel motor diameter
 */

public class SpinPanelThreeTimes extends SequentialCommandGroup {

    protected static final double TOTAL_REVOLUTIONS = 3.0;
    protected static final double TOTAL_DEGREES = ColorTracker.DEGREES_IN_A_CIRCLE * TOTAL_REVOLUTIONS;

    public SpinPanelThreeTimes() {
        RobotMap.Component.controlPanelEncoder.reset();
        addRequirements(RobotMap.Component.controlPanel);
        addCommands(new RunUntil(new SpinPanelMotorForward(), () -> {
            return RobotMap.Component.controlPanelEncoder.pidGet() / ColorTracker.PANEL_SPINNER_RATIO >= TOTAL_DEGREES;
        }), new StopPanelMotor());
    }
}
