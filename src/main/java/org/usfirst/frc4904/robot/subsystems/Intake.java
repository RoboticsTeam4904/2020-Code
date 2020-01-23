package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class Intake extends SubsystemBase {
  private static final double DEFAULT_ON_SPEED = 0.5; // TODO: test this value
  private static final double DEFAULT_OFF_SPEED = 0.0;

  protected final Motor intake;
  protected final SolenoidSubsystem piston;

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
    piston = intakeSolenoid;
  }

  public void setSpeed(double speed) {
    intake.set(speed);
  }

  public void start() {
    setSpeed(DEFAULT_ON_SPEED);
  }

  public void stop() {
    setSpeed(DEFAULT_OFF_SPEED);
  }

  /**
   * Extend the intake solenoid
   */
  public void extend() {
    //call the ExtendPiston class because that is how we should extend pistons.
      ExtendPiston.ExtendPiston(piston)
  }

}