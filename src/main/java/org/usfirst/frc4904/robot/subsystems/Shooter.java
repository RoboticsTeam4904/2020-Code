package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.robot.subsystems.Flywheel.FlywheelStatus;;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;


public class Shooter {
  protected final Flywheel flywheel;
  protected final SolenoidSubsystem solenoidSubsystem;
  protected final Motor motor;

  /**
   * Shooter
   * 
   * Wraps a Flywheel and a SolenoidSubsystem together for the shooter on 4904's
   * 2020 robot
   * 
   * @param flywheel          The actual flywheel for this subsystem
   * @param solenoidSubsystem The SolenoidSubsystem for aiming the shooter
   */

  Shooter(Flywheel flywheel, SolenoidSubsystem solenoidSubsystem, Motor motor) {
    this.flywheel = flywheel;
    this.solenoidSubsystem = solenoidSubsystem;
    this.motor = motor;
  }

  public SolenoidState getSolenoidState() {
    return solenoidSubsystem.getState();
  }

  public void setSolenoidHigh() {
    solenoidSubsystem.set(SolenoidState.EXTEND);
  }

  public void setSolenoidLow() {
    solenoidSubsystem.set(SolenoidState.RETRACT);
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

  public void setMotorSpeed(double speed) {
    motor.set(speed);
  }
}