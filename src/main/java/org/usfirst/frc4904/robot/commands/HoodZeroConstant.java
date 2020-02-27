package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

/**
 * Goes to the lower limit and zeroes
 */
public class HoodZeroConstant extends MotorConstant {
    public final static double DEFAULT_SPEED = 0;

    public HoodZeroConstant() {
        super("HoodZeroConstant", RobotMap.Component.hood.getServo(), DEFAULT_SPEED);
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        if (!interrupted) {
            RobotMap.Component.hood.setLimit();
        }
    }

}