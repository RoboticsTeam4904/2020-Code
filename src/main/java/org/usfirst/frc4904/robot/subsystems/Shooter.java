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
  public final Motor runUpBelt;
  public Hood hood;

  public Shooter(Flywheel flywheel, Motor runUpBelt, Hood hood) {
    this.flywheel = flywheel;
    this.runUpBelt = runUpBelt;
    this.hood = hood;
  }

  public Set<SubsystemBase> getSubsystems() {
    return Set.of(flywheel, runUpBelt, hood);
  }

  public FlywheelStatus getFlywheelStatus() {
    return flywheel.getStatus();
  }

  public double getFlywheelSpeed() {
    return flywheel.getVelocity();
  }

  public double getFlywheelTargetSpeed() {
    return flywheel.getTargetVelocity();
  }

  public void setFlywheelSpeed(double speed) {
    flywheel.setVelocity(speed);
  }

  public void setFlywheelSpeedForDistance(double distance) {
    //TODO: Add this
  }

  public void setRunUpBeltSpeed(double speed) {
    runUpBelt.set(speed);
  }

  public void setRunUpBeltSpeed() {
    setRunUpBeltSpeed(DEFAULT_RUN_UP_BELT_SPEED);
  }
}
