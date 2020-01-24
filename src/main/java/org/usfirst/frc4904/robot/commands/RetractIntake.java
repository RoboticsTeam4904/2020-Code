package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A command that will retract the intake piston that serves as a gate between
 * the indexer and shooter.
 */
public class RetractIntake extends CommandBase {
    public RetractIntake(Intake intake) {
        intake.retract();
    }
}