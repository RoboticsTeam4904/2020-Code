package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Intake;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RetractIntake extends CommandBase {
  protected final Intake intake;

  /**
   * Retract the intake solenoid to flip up the intake rollers.
   * 
   * @param intake The intake to manipulate
   */
  public RetractIntake(Intake intake) {
    super();
    setName("RetractIntake");
    addRequirements(intake.solenoid);
    this.intake = intake;
  }

  public void onInitialize() {
    intake.retract();
  }
}