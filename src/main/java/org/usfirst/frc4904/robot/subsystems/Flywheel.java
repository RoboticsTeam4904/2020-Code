package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;

import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.subsystems.motor.VelocitySensorMotor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.SpeedModifier;

/**
 * Flywheel Base Class
 * 
 * ! This class does not include a piston, use Shooter.java for the 2020-season
 * ! specific flywheel subsystem.
 */
public class Flywheel extends VelocitySensorMotor {
  public enum FlywheelStatus {
    SPINNING_UP, AT_SPEED
  }

  public static final double BOX_SHOT_SPEED = 0.7; // TODO: figure out the speed needed for the box shot

  protected FlywheelStatus currentStatus = FlywheelStatus.AT_SPEED;
  protected double targetSpeed = 0.0;

  /**
   * Flywheel constructor - extends VelocitySensorMotor
   * 
   * @param name             The name of the flywheel
   * @param SpeedModifier    The speedModifier
   * @param motionController The motionController
   * @param motors           Motors to control
   */
  public Flywheel(String name, SpeedModifier speedModifier, MotionController motionController,
      SpeedController... motors) {
    super(name, speedModifier, motionController, motors);
    super.enableMotionController();
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

  @Override
  public void periodic() {
    if (motionController.onTarget()) {
      currentStatus = FlywheelStatus.AT_SPEED;
    } else {
      currentStatus = FlywheelStatus.SPINNING_UP;
    }
  }

  public FlywheelStatus getStatus() {
    return currentStatus;
  }

  public double getSpeed() {
    return motionController.getSensorValue();
  }

  public double getTargetSpeed() {
    return targetSpeed;
  }

  public void setSpeed(double speed) {
    targetSpeed = speed;
    super.set(targetSpeed);
  }

  public void setSpeedBoxshot() {
    setSpeed(BOX_SHOT_SPEED);
  }

  public void setSpeedForDistance(double distance) {
    setSpeed(2 * distance); // TODO: set speed value based on distance
  }
}