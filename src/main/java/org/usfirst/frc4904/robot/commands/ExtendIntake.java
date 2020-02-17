package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Intake;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class ExtendIntake extends SolenoidExtend {
  /**
   * Extend the intake solenoid to deploy the intake rollers.
   * 
   * @param intake The intake to manipulate
   */
  public ExtendIntake(Intake intake) {
    super("ExtendIntake", intake.solenoid);
  }
}
