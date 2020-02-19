package org.usfirst.frc4904.robot.subsystems;

import java.util.Set;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class Intake {
  public static final double DEFAULT_INTAKE_SPEED = 0.0; // TODO: test this value
  public static final double DEFAULT_OUTTAKE_SPEED = -0.0; // TODO: test this value
  public static final double DEFAULT_FUNNEL_SPEED = 0.0; // TODO: test this value
  public static final double DEFAULT_FUNNEL_REVERSE_SPEED = -0.0; // TODO: test this value
  public static final double DEFAULT_LIFT_SPEED = 0.0; // TODO: test this value
  public static final double DEFAULT_LIFT_REVERSE_SPEED = -0.0; // TODO: test this value
  public static final double DEFAULT_OFF_SPEED = 0.0;

  public final Motor intake;
  public final Motor funnel;
  public final Motor lift;
  public final SolenoidSubsystem solenoid;

  /**
   * Intake - Wraps the two intake SRXs (front intake and the funnel), the intake
   * solenoid, and the SRX controlling the lift belts
   *
   * @param intakeMotor    The front intake motor that extends with the intake
   *                       solenoid
   * @param funnelMotor    The funnel motor
   * @param liftBelts      The motor controlling the lift belts
   * 
   * @param intakeSolenoid The solenoid that controls the position of the
   *                       intakeMotor rollers
   */
  public Intake(Motor intakeMotor, Motor funnelMotor, Motor liftBelts, SolenoidSubsystem intakeSolenoid) {
    intake = intakeMotor;
    funnel = funnelMotor;
    lift = liftBelts;
    solenoid = intakeSolenoid;
  }

  public Set<SubsystemBase> getSubsystems() {
    return Set.of(intake, funnel, lift, solenoid);
  }

  public void setIntakeSpeed(double speed) {
    intake.set(speed);
  }

  public void setFunnelSpeed(double speed) {
    funnel.set(speed);
  }
  public void setLiftBeltSpeed(double speed) {
    lift.set(speed);
  }

  public void setSpeed(double intakeSpeed, double funnelSpeed, double liftBeltSpeed) {
    setIntakeSpeed(intakeSpeed);
    setFunnelSpeed(funnelSpeed);
    setLiftBeltSpeed(liftBeltSpeed);
  }

  public void setSpeed(double speed) {
    setSpeed(speed, speed, speed);
  }

  public void setSpeed() {
    setSpeed(DEFAULT_INTAKE_SPEED, DEFAULT_FUNNEL_SPEED, DEFAULT_LIFT_SPEED);
  }

  public void stop() {
    setSpeed(DEFAULT_OFF_SPEED);
  }

  public void reverse() {
    setSpeed(DEFAULT_OUTTAKE_SPEED, DEFAULT_FUNNEL_REVERSE_SPEED, DEFAULT_LIFT_REVERSE_SPEED);
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