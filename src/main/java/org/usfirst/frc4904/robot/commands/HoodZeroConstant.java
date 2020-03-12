package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Hood.LimitType;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

/**
 * Goes to the lower limit and zeroes
 */
public class HoodZeroConstant extends MotorConstant {
    public final static double DEFAULT_SPEED = 0.07;
    public LimitType limitType;

    public HoodZeroConstant(LimitType limitType) {
        super("HoodZeroConstant", RobotMap.Component.hood.getMotor(), DEFAULT_SPEED * (limitType == LimitType.UPPER ? 1.0 : -1.0));
        this.limitType = limitType;
    }

    @Override
    public boolean isFinished() {
        return RobotMap.Component.hood.isLimitDown();
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        if (!interrupted) {
            RobotMap.Component.hood.setLimit(limitType);
        }
    }

}