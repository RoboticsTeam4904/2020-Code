package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class ExtendIntake extends SolenoidExtend {
  /**
   * Extend the intake solenoid to deploy the intake rollers.
   */
  public ExtendIntake() {
    super("ExtendIntake", RobotMap.Component.intake.solenoid);
  }
}
