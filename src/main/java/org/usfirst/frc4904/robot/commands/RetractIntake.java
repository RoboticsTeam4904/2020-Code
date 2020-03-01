package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Intake;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class RetractIntake extends SolenoidRetract {
  /**
   * Retract the intake solenoid to flip up the intake rollers.
   * 
   * @param intake The intake to manipulate
   */
  public RetractIntake(Intake intake) {
    super("RetractIntake", intake.solenoid);
  }
}