package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Hood;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class HoodZeroConstant extends MotorConstant {
    protected final boolean limitType;
    protected final Hood hood;

    public HoodZeroConstant(String name, Hood hood, double motorSpeed, boolean limitType) {
        super(name, hood.getServo(), motorSpeed);
        this.hood = hood;
        this.limitType = limitType;
    }

    public HoodZeroConstant(Hood hood, double motorspeed, boolean limitType) {
        this("HoodZeroConstant", hood, motorspeed, limitType);
    }

    @Override
    public void end(boolean interrupted) {
        if (!interrupted) {
            super.motor.set(0.0);
            hood.setLimit(limitType);
        }
    }

}