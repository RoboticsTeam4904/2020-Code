package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Hood;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

public class ZeroHood extends SequentialCommandGroup {
    protected double ZERO_SERVO_CONSTANT = 0;

    public ZeroHood() {
        super(new HoodZeroConstant(Hood.limitType.UPPER), new WaitUntilCommand(() -> {
            return RobotMap.Component.hood.isUpperLimitDown();
        }), new HoodZeroConstant(Hood.limitType.LOWER), new WaitUntilCommand(() -> {
            return RobotMap.Component.hood.isLowerLimitDown();
        }));
    }
}