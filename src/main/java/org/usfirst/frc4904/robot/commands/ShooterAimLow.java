package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Shooter;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidRetract;

public class ShooterAimLow extends SolenoidRetract {
  /**
   * Retract the aim solenoid to aim the shooter down
   * 
   * @param shooter
   */
  public ShooterAimLow(Shooter shooter) {
    super("ShooterAimLow", shooter.aimSolenoid);
  }
}