package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Hood;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class HoodZeroConstant extends MotorConstant {
    protected final Hood.limitType type;
    public final static double DEFAULT_SPEED = 0;

    public HoodZeroConstant(Hood.limitType type) {
        super("HoodZeroConstant", RobotMap.Component.hood.getServo(),
                type == Hood.limitType.UPPER ? DEFAULT_SPEED : -DEFAULT_SPEED);
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