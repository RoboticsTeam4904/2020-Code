package org.usfirst.frc4904.robot.subsystems;

import java.util.Set;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

/**
 * Indexer - Wraps the indexer flippers and the run up belt.
 * 
 */
public class Indexer {
  public static final double DEFAULT_LIFT_SPEED = 0.0; // TODO: Untested value
  public static final double DEFAULT_OFF_SPEED = 0.0;

  public final SolenoidSubsystem flippers;
  public final Motor liftBelts;
  public final CustomDigitalLimitSwitch limitSwitch;

  /**
   * Indexer - Wraps the indexer flippers and the run up belt.
   * 
   * @param flippers The SolenoidSubsystem controlling the flippers
   * @param liftBelt The motor controlling the run up belt
   */
  public Indexer(Motor liftBelts, SolenoidSubsystem flippers, CustomDigitalLimitSwitch limitSwitch) {
    this.liftBelts = liftBelts;
    this.flippers = flippers;
    this.limitSwitch = limitSwitch;
  }

  public Set<SubsystemBase> getSubsystems() {
    return Set.of(liftBelts, flippers);
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