package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.standard.commands.motor.MotorVelocitySet;

public class FlywheelMaintainSpeed extends MotorVelocitySet {

  /**
   * Spin up the flywheel to a speed
   * 
   * @param flywheel The flywheel to manipulate
   * @param speed    The speed to spin the flywheel up to
   */
  public FlywheelMaintainSpeed(Flywheel flywheel, double speed) {
    super("FlywheelMaintainSpeed", flywheel, speed);
  }

  public FlywheelMaintainSpeed(double speed) {
    this(RobotMap.Component.flywheel, speed);
  }
}