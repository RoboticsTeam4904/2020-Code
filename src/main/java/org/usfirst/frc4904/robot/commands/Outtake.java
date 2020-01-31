package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Outtake extends CommandBase {
  protected final Intake intake;

  /**
   * Reverses the intake.
   * 
   * @param intake The intake to manipulate
   */
  Outtake(Intake intake) {
    super();
    setName("Outtake");
    addRequirements(intake.intake);
    this.intake = intake;
  }

  public void initialize() {
    intake.reverse();
  }
}