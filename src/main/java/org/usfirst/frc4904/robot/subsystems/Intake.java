package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class Intake extends SubsystemBase {
  private static final double defaultOnSpeed = 0.7;
  private static final double defaultOffSpeed = 0.0;

  protected final Motor intake, funnel, belt;
  protected final SolenoidSubsystem solenoid;

  /**
   * Intake - Wraps the three intake SRXs (front intake, funnel, belt) and the
   * intake solenoid
   * 
   * @param name           The name of the Intake
   * @param intakeMotor    The front intake motor that extends with the intake
   *                       solenoid
   * @param funnelMotor    The motor that controls the funnel rollers
   * @param beltMotor      The motor that drives the base and lift belts
   * @param intakeSolenoid The solenoid that controls the position of the
   *                       intakeMotor rollers
   */
  Intake(String name, Motor intakeMotor, Motor funnelMotor, Motor beltMotor, SolenoidSubsystem intakeSolenoid) {
    super();
    setName(name);
    intake = intakeMotor;
    funnel = funnelMotor;
    belt = beltMotor;
    solenoid = intakeSolenoid;
  }

  /**
   * Intake - Wraps the three intake SRXs (front intake, funnel, belt) and the
   * intake solenoid
   * 
   * @param intakeMotor    The front intake motor that extends with the intake
   *                       solenoid
   * @param funnelMotor    The motor that controls the funnel rollers
   * @param beltMotor      The motor that drives the base and lift belts
   * @param intakeSolenoid The solenoid that controls the position of the
   *                       intakeMotor rollers
   */
  Intake(Motor intakeMotor, Motor funnelMotor, Motor beltMotor, SolenoidSubsystem intakeSolenoid) {
    this("Intake", intakeMotor, funnelMotor, beltMotor, intakeSolenoid);
  }

  public void setSpeed(double speed) {
    intake.set(speed);
    funnel.set(speed);
    belt.set(speed);
  }

  public void start(double speed) {
    setSpeed(speed);
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