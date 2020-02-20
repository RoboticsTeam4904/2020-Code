package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorControl;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;

public class ClimberMoveWinch extends MotorControl {
    public ClimberMoveWinch() {
        super("ClimberMoveWinch", RobotMap.Component.winchMotor, RobotMap.HumanInput.Driver.xbox,
                CustomXbox.RIGHT_Y_AXIS);
        // addRequirements(RobotMap.Component.winchMotor);
    }
}