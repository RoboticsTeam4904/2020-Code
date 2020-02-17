package org.usfirst.frc4904.robot.subsystems;

import java.util.Set;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;

/**
 * Indexer - Wraps the indexer flippers and the run up belt.
 * 
 */
public class Indexer {

  public final SolenoidSubsystem flippers;
  public final CustomDigitalLimitSwitch limitSwitch;

  /**
   * Indexer - Wraps the indexer flippers and the lift belts.
   * 
   * @param flippers The SolenoidSubsystem controlling the flippers
   */
  public Indexer(SolenoidSubsystem flippers, CustomDigitalLimitSwitch limitSwitch) {
    this.flippers = flippers;
    this.limitSwitch = limitSwitch;
  }

  public Set<SubsystemBase> getSubsystems() {
    return Set.of(flippers);
  }

  public SolenoidState getFlippersState() {
    return flippers.getState();
  }

  public void closeFlippers() {
    flippers.set(SolenoidState.EXTEND);
  }

  public void openFlippers() {
    flippers.set(SolenoidState.RETRACT);
  }
}