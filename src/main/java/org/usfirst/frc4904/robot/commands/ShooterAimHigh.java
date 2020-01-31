package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Shooter;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class ShooterAimHigh extends SolenoidExtend {
  /**
   * Extend the aim solenoid to aim the shooter up
   * 
   * @param shooter
   */
  public ShooterAimHigh(Shooter shooter) {
    super("ShooterAimHigh", shooter.aimSolenoid);
  }
}