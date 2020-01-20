package org.usfirst.frc4904.robot.subsystems;

import edu.wpi.first.wpilibj.SpeedController;

import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.subsystems.motor.VelocitySensorMotor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.SpeedModifier;

/**
 * Flywheel Base Class
 * ! **This class does not include a piston, use FlywheelSubsystem for the 2020 season specific flywheel subsystem**
 * 
 */
public class Flywheel extends VelocitySensorMotor {
  public enum FlywheelStatus {
    SPINNING_UP, AT_SPEED
  }

  public static final double boxShotSpeed = 10.0; // TODO: figure out the speed needed for the box shot

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

  protected void syncStatus() {
    if (motionController.onTarget()) {
      currentStatus = FlywheelStatus.AT_SPEED;
    } else {
      currentStatus = FlywheelStatus.SPINNING_UP;
    }
  }

  public FlywheelStatus getStatus() {
    syncStatus();
    return currentStatus;
  }

  public void setSpeed() {
    super.enableMotionController();
    super.set(targetSpeed);
    syncStatus();
  }

  public void setSpeed(double speed) {
    targetSpeed = speed;
    setSpeed();
  }

  public void setSpeedForDistance(double distance) {
    setSpeed(2 * distance); // TODO: set speed value based on distance
  }
}