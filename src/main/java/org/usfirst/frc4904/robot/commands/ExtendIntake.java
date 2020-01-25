package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ExtendIntake extends CommandBase {
  protected final Intake intake;

  /**
   * Extend the intake solenoid to deploy the intake rollers.
   * 
   * @param intake The intake to manipulate
   */
  public ExtendIntake(Intake intake) {
    super();
    setName("ExtendIntake");
    addRequirements(intake.solenoid);
    this.intake = intake;
  }

  public void initialize() {
    intake.extend();
  }
}
