package org.usfirst.frc4904.robot.commands.controlpanel;

public class SpinPanelMotorReverse extends SpinPanelMotor {
    protected static final double REVERSE_SPEED = 0.0;

    public SpinPanelMotorReverse() {
        super("SpinPanelMotorReverse", REVERSE_SPEED);
    }
}