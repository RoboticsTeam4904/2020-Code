package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorVelocitySet;

// import org.usfirst.frc4904.standard.commands.motor.MotorVelocitySet;
public class FlywheelSpinUp extends MotorVelocitySet {
  public static final double DEFAULT_FLYWHEEL_SPEED = 0.0; // TODO: This is an untested value

  /**
   * Spin up the flywheel to a speed
   * 
   * @param flywheel The flywheel to manipulate
   * @param speed    The speed to spin the flywheel up to
   */
  public FlywheelSpinUp(double speed) {
    super("FlywheelSpinUp", RobotMap.Component.flywheel, speed);
  }

  /**
   * Spin up the flywheel to the default speed
   * 
   * @param flywheel The flywheel to manipulate
   */
  public FlywheelSpinUp() {
    this(DEFAULT_FLYWHEEL_SPEED);
  }
}