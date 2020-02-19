package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class RetractIntake extends SolenoidRetract {
  /**
   * Retract the intake solenoid to flip up the intake rollers.
   */
  public RetractIntake() {
    super("RetractIntake", RobotMap.Component.intake.solenoid);
  }
}