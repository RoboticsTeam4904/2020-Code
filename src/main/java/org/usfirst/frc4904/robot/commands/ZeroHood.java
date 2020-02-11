package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Hood;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

public class ZeroHood extends SequentialCommandGroup {
    protected Hood hood;
    protected double ZERO_SERVO_CONSTANT = 0;

    public ZeroHood(Hood hood) {
        super(new HoodZeroConstant(hood, hood.DEFAULT_SPEED, true), new WaitUntilCommand(() -> {
            return hood.isLimitButtonDown();
        }), new HoodZeroConstant(hood, -hood.DEFAULT_SPEED, false), new WaitUntilCommand(() -> {
            return hood.isLimitButtonDown();
        }));
    }

    @Override
    public void end(boolean interrupted) {
        super.end(interrupted);
        hood.setRange();
    }

}