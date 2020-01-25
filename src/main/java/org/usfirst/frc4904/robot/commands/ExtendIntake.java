package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * A command that will retract the intake piston that serves as a gate between
 * the indexer and shooter.
 */

public class ExtendIntake extends CommandBase {
  protected final Intake intake;

  public ExtendIntake(Intake intake) {
    super();
    setName("ExtendIntake");
    addRequirements(intake.solenoid);
    this.intake = intake;
  }

  public void onInitialize() {
    intake.extend();
  }
}
