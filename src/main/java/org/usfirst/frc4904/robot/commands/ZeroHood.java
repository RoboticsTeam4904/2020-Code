package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Hood.LimitType;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

public class ZeroHood extends SequentialCommandGroup {
    public ZeroHood() {
        super(new HoodZeroConstant(LimitType.LOWER));
    }
}