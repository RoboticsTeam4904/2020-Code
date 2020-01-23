package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.InvalidSensorException;
import org.usfirst.frc4904.standard.subsystems.motor.VelocitySensorMotor;

import edu.wpi.first.wpilibj.SpeedController;

public class Flywheel extends VelocitySensorMotor {
  // this should take in a solenoidSet
  private final double BOX_SHOT_SPEED = -1;
  private final double SPEED_ERROR_THRESHOLD = -1;
  private double targetSpeed;

  public Flywheel(MotionController motionController, SpeedController... speedControllers) {
    super(motionController, speedControllers);
  }

  public void spinDown() {
    this.targetSpeed = 0.0;
    super.set(targetSpeed);
  }

  public boolean isSpunUp() {
    try {
      if (Math.abs(super.motionController.getSafely() - this.targetSpeed) < SPEED_ERROR_THRESHOLD) {
        return true;
      }
    } catch (InvalidSensorException e) {
      LogKitten.e(e.getMessage());
    }
    return false;
  }

  public void spinUpForDistance(double distance) {
    // TODO: Calculate RPM
  }

  public void spinUpForBoxShot() {
    this.targetSpeed = BOX_SHOT_SPEED;
    super.set(targetSpeed);
  }
}