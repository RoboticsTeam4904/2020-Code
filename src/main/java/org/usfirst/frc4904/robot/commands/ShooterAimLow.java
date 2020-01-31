package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterAimLow extends CommandBase {
  protected final Shooter shooter;

  /**
   * Retract the aim solenoid to aim the shooter down
   * 
   * @param shooter
   */
  public ShooterAimLow(Shooter shooter) {
    super();
    setName("ShooterAimLow");
    addRequirements(shooter.aimSolenoid);
    this.shooter = shooter;
  }

  public void initialize() {
    shooter.setSolenoidLow();
  }
}