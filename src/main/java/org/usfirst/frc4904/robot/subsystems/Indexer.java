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
  protected final SolenoidSubsystem flippers;
  protected final Motor belts;
  protected final CustomDigitalLimitSwitch limitSwitch;

  /**
   * Indexer - Wraps the indexer flippers and the run up belt.
   * 
   * @param name              The Indexer name
   * @param solenoidSubsystem The SolenoidSubsystem controlling the flippers
   * @param motor             The motor controlling the run up belt
   * @param switch            The limit switch testing for balls
   */
  Indexer(String name, SolenoidSubsystem solenoidSubsystem, Motor motor, CustomDigitalLimitSwitch limitSwitch) {
    super();
    setName(name);
    flippers = solenoidSubsystem;
    belts = motor;
    this.limitSwitch = limitSwitch;
  }

  /**
   * Indexer - Wraps the indexer flippers and the run up belt.
   * 
   * @param name              The Indexer name
   * @param solenoidSubsystem The SolenoidSubsystem controlling the flippers
   * @param motor             The motor controlling the run up belt
   * @param switch            The limit switch testing for balls
   */
  Indexer(SolenoidSubsystem solenoidSubsystem, Motor motor, CustomDigitalLimitSwitch limitSwitch) {
    this("Indexer", solenoidSubsystem, motor, limitSwitch);
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

  public void setMotorSpeed(double speed) {
    belts.set(speed);
  }

  /**
   * Open the flippers and run the run up belt to advance balls to the flywheel.
   * 
   * @param speed Speed to run the run up belt at.
   */
  public void start(double speed) {
    openFlippers();
    setMotorSpeed(speed);
  }

  /**
   * Open the flippers and run the run up belt to advance balls to the flywheel.
   */
  public void start() {
    openFlippers();
    setMotorSpeed(0.7);
  }

  /**
   * Close flippers and stop the run up belt.
   */
  public void stop() {
    closeFlippers();
    setMotorSpeed(0.0);
  }
}