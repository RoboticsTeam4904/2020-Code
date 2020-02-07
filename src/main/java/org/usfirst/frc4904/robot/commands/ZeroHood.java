package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Hood;
import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class ZeroHood extends SequentialCommandGroup{
    private Hood hood;
    private double ZERO_SERVO_CONSTANT = 0;

    public ZeroHood(Hood hood) {
        super(new RunUntil(new HoodMotorConstant(hood.getServo()), ()->{}));
        addRequirements(hood);
    }

}