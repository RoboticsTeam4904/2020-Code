package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Hood.LimitType;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

public class ZeroHood extends SequentialCommandGroup {
    public ZeroHood() {
        super(new HoodZeroConstant(LimitType.LOWER), new WaitUntilCommand(() -> {
            return RobotMap.Component.hood.isLimitDown();
        }), new HoodZeroConstant(LimitType.UPPER), new WaitUntilCommand(() -> {
            return RobotMap.Component.hood.isUpperLimitDown(); // TODO: We may have to switch this to isLimitDown(), though we also want to make sure there's some delay so it doesn't get triggered immediately.
        }));
    }
}