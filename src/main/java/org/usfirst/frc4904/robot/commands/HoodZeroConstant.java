package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Hood.LimitType;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class HoodZeroConstant extends MotorConstant {
    protected final LimitType type;
    public final static double DEFAULT_SPEED = 0;

    public HoodZeroConstant(LimitType type) {
        super("HoodZeroConstant", RobotMap.Component.hood.getServo(),
                type == LimitType.UPPER ? DEFAULT_SPEED : -DEFAULT_SPEED);
        this.type = type;
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        if (!interrupted) {
            RobotMap.Component.hood.setLimit(type);
        }
    }

}