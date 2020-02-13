package org.usfirst.frc4904.robot.subsystems;

import java.util.Set;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.robot.subsystems.Flywheel.FlywheelStatus;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class Shooter {
  public final static double DEFAULT_RUN_UP_BELT_SPEED = 0.0; // TODO: Untested value
  public final static double DEFAULT_OFF_SPEED = 0.0;

  public final Flywheel flywheel;
  public final SolenoidSubsystem aimSolenoid;
  public final Motor runUpBelt;
  public Hood hood;

  /**
   * Shooter
   * 
   * Wraps a Flywheel and a SolenoidSubsystem together for the shooter on 4904's
   * 2020 robot
   * 
   * @param flywheel          The actual flywheel for this subsystem
   * @param solenoidSubsystem The SolenoidSubsystem for aiming the shooter
   */
  public Shooter(Flywheel flywheel, SolenoidSubsystem solenoidSubsystem, Motor motor, Hood hood) {
    this.flywheel = flywheel;
    this.aimSolenoid = solenoidSubsystem;
    this.runUpBelt = motor;
  }

  public Set<SubsystemBase> getSubsystems() {
    return Set.of(flywheel, aimSolenoid, runUpBelt);
  }

  public SolenoidState getSolenoidState() {
    return aimSolenoid.getState();
  }

  public void setSolenoidHigh() {
    aimSolenoid.set(SolenoidState.EXTEND);
  }

  public void setSolenoidLow() {
    aimSolenoid.set(SolenoidState.RETRACT);
  }

  public FlywheelStatus getFlywheelStatus() {
    return flywheel.getStatus();
  }

  public double getFlywheelSpeed() {
    return flywheel.getSpeed();
  }

  public double getFlywheelTargetSpeed() {
    return flywheel.getTargetSpeed();
  }

  public void setFlywheelSpeed(double speed) {
    flywheel.setSpeed(speed);
  }

  public void setFlywheelSpeedForDistance(double distance) {
    flywheel.setSpeedForDistance(distance);
  }

  public void setRunUpBeltSpeed(double speed) {
    runUpBelt.set(speed);
  }

  public void setRunUpBeltSpeed() {
    setRunUpBeltSpeed(DEFAULT_RUN_UP_BELT_SPEED);
  }
}
