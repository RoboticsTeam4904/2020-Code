package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;

import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.subsystems.motor.VelocitySensorMotor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.IdentityModifier;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.SpeedModifier;

/**
 * Flywheel Base Class
 * 
 * ! This class does not include a piston, use Shooter.java for the 2020-season
 * ! specific flywheel subsystem.
 * 
 * This class is designed to go into standard, eventually.
 */
public class Flywheel extends VelocitySensorMotor {
  public static enum FlywheelStatus {
    IDLE, SPINNING_UP, AT_SPEED
  }

  protected FlywheelStatus currentStatus = FlywheelStatus.IDLE;
  protected double targetSpeed = 0.0;

  /**
   * Flywheel constructor - extends VelocitySensorMotor
   * motionController.absoluteTolerance should be set.
   * 
   * @param name             The name of the flywheel
   * @param SpeedModifier    The speedModifier
   * @param motionController The motionController
   * @param motors           Motors to control
   */
  public Flywheel(String name, SpeedModifier speedModifier, MotionController motionController,
      SpeedController... motors) {
    super(name, speedModifier, motionController, motors);
    // super.enableMotionController();
  }

  /**
   * Flywheel constructor - extends VelocitySensorMotor
   * 
   * @param SpeedModifier    The speedModifier
   * @param motionController The motionController
   * @param motors           Motors to control
   */
  public Flywheel(SpeedModifier speedModifier, MotionController motionController, SpeedController... motors) {
    this("Flywheel", speedModifier, motionController, motors);
  }

  /**
   * Flywheel constructor - extends VelocitySensorMotor
   * 
   * @param name             The name of the flywheel
   * @param motionController The motionController
   * @param motors           Motors to control
   */
  public Flywheel(String name, MotionController motionController, SpeedController... motors) {
    this(name, new IdentityModifier(), motionController, motors);
  }

  /**
   * Flywheel constructor - extends VelocitySensorMotor
   * 
   * @param motionController The motionController
   * @param motors           Motors to control
   */
  public Flywheel(MotionController motionController, SpeedController... motors) {
    this("Flywheel", motionController, motors);
  }

  @Override
  public void periodic() {
    syncStatus();
  }

  protected void syncStatus() {
    // TODO:// Infinitely idle?
    if (Math.abs(targetSpeed) < motionController.getAbsoluteTolerance() || currentStatus == FlywheelStatus.IDLE) {
      currentStatus = FlywheelStatus.IDLE;
      return;
    }
    if (motionController.onTarget()) {
      currentStatus = FlywheelStatus.AT_SPEED;
    } else {
      currentStatus = FlywheelStatus.SPINNING_UP;
    }
  }

  public FlywheelStatus getStatus() {
    return currentStatus;
  }

  public double getVelocity() {
    return motionController.getSensorValue();
  }

  public double getTargetVelocity() {
    return targetSpeed;
  }

  public void setVelocity() {
    super.set(targetSpeed);
  }

  public void setVelocity(double speed) {
    targetSpeed = speed;
    setVelocity();
  }

  public MotionController getMC() {
    return motionController;
  }
}