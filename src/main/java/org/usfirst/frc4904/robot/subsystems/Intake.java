package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class Intake extends SubsystemBase {
  private static final double defaultOnSpeed = 0.5; // TODO: test this value
  private static final double defaultOffSpeed = 0.0;

  protected final Motor intake;
  protected final SolenoidSubsystem solenoid;

  /**
   * Intake - Wraps the three intake SRXs (front intake, funnel, belt) and the
   * intake solenoid
   *
   * @param intakeMotor    The front intake motor that extends with the intake
   *                       solenoid
   * @param intakeSolenoid The solenoid that controls the position of the
   *                       intakeMotor rollers
   */
  Intake(Motor intakeMotor, SolenoidSubsystem intakeSolenoid) {
    super();
    setName("Intake");
    intake = intakeMotor;
    solenoid = intakeSolenoid;
  }

  public void setSpeed(double speed) {
    intake.set(speed);
  }

  public void start() {
    setSpeed(defaultOnSpeed);
  }

  public void stop() {
    setSpeed(defaultOffSpeed);
  }

  /**
   * Extend the intake solenoid
   */
  public void extend() {
    solenoid.set(SolenoidState.EXTEND);
  }

  /**
   * Retract the intake solenoid
   */
  public void retract() {
    solenoid.set(SolenoidState.RETRACT);
  }
}