package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

/**
 * Indexer - Wraps the indexer flippers and the run up belt.
 */
public class Indexer extends SubsystemBase {
  private static final double DEFAULT_ON_SPEED = 0.7;
  private static final double DEFAULT_OFF_SPEED = 0.0;

  protected final SolenoidSubsystem flippers;
  protected final Motor belts;
  protected final CustomDigitalLimitSwitch limitSwitch;

  /**
   * Indexer - Wraps the indexer flippers and the run up belt.
   * 
   * @param solenoidSubsystem The SolenoidSubsystem controlling the flippers
   * @param motor             The motor controlling the run up belt
   * @param switch            The limit switch testing for balls
   */
  Indexer(SolenoidSubsystem solenoidSubsystem, Motor motor, CustomDigitalLimitSwitch limitSwitch) {
    super();
    setName("Indexer");
    flippers = solenoidSubsystem;
    belts = motor;
    this.limitSwitch = limitSwitch;
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

  public void setSpeed(double speed) {
    belts.set(speed);
  }

  /**
   * Open the flippers and run the run up belt to advance balls to the flywheel.
   */
  public void start() {
    openFlippers();
    setSpeed(DEFAULT_ON_SPEED);
  }

  /**
   * Close flippers and stop the run up belt.
   */
  public void stop() {
    closeFlippers();
    setSpeed(DEFAULT_OFF_SPEED);
  }
}