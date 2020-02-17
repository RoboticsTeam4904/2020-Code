package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Hood;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class HoodZeroConstant extends MotorConstant {
    protected final Hood.limitType type;
    protected final Hood hood;
    public final static double DEFAULT_SPEED = 0;

    public HoodZeroConstant(String name, Hood hood, Hood.limitType type) {
        super(name, hood.getServo(), type == Hood.limitType.UPPER ? DEFAULT_SPEED : -DEFAULT_SPEED);
        this.hood = hood;
        this.type = type;
    }

    public HoodZeroConstant(Hood hood, Hood.limitType type) {
        this("HoodZeroConstant", hood, type);
    }

    @Override
    public void end(boolean interrupted) {
        if (!interrupted) {
            super.motor.set(0.0);
            hood.setLimit(type);
        }
    }

}