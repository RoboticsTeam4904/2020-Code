package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

public class ZeroHood extends SequentialCommandGroup {
    public ZeroHood() {
        super(new HoodZeroConstant(), new WaitUntilCommand(() -> {
            return RobotMap.Component.hood.isUpperLimitDown();
        }));
    }
}