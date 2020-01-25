package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class Intake {
  private static final double DEFAULT_INTAKE_SPEED = 0.5; // TODO: test this value
  private static final double DEFAULT_OUTTAKE_SPEED = -0.5; //TODO: test this value
  private static final double DEFAULT_FUNNEL_SPEED = 0.5; // TODO: test this value
  private static final double DEFAULT_FUNNEL_REVERSE_SPEED = -0.5; // TODO: test this value
  private static final double DEFAULT_OFF_SPEED = 0.0;

  public final Motor intake;
  public final Motor funnel;
  public final SolenoidSubsystem solenoid;

  /**
   * Intake - Wraps the two intake SRXs (front intake and the funnel) and the
   * intake solenoid
   *
   * @param intakeMotor    The front intake motor that extends with the intake
   *                       solenoid
   * @param funnelMotor    The funnel motor
   * @param intakeSolenoid The solenoid that controls the position of the
   *                       intakeMotor rollers
   */
  Intake(Motor intakeMotor, Motor funnelMotor, SolenoidSubsystem intakeSolenoid) {
    intake = intakeMotor;
    funnel = funnelMotor;
    solenoid = intakeSolenoid;
  }

  public void setIntakeSpeed(double speed) {
    intake.set(speed);
  }

  public void setFunnelSpeed(double speed) {
    funnel.set(speed);
  }

  public void setSpeed(double intakeSpeed, double funnelSpeed) {
    setIntakeSpeed(intakeSpeed);
    setFunnelSpeed(funnelSpeed);
  }

  public void setSpeed(double speed) {
    setSpeed(speed, speed);
  }

  public void start() {
    setSpeed(DEFAULT_INTAKE_SPEED, DEFAULT_FUNNEL_SPEED);
  }

  public void stop() {
    setSpeed(DEFAULT_OFF_SPEED);
  }

  public void reverse(){
    setSpeed(DEFAULT_OUTTAKE_SPEED, DEFAULT_FUNNEL_REVERSE_SPEED);
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