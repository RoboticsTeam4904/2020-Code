package org.usfirst.frc4904.robot.commands.controlpanel;

public class SpinPanelMotorForward extends SpinPanelMotor {
    protected static final double FORWARD_SPEED = 0.0; //TODO: update consts
    public SpinPanelMotorForward() {
        super("SpinPanelMotorForward", FORWARD_SPEED);
    }
}