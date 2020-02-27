package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorVelocitySet;

public class FlywheelMaintainSpeed extends MotorVelocitySet {

  /**
   * Spin up the flywheel to a speed
   * 
   * @param flywheel The flywheel to manipulate
   * @param speed    The speed to spin the flywheel up to
   */
  public FlywheelMaintainSpeed(double speed) {
    super("FlywheelMaintainSpeed", RobotMap.Component.flywheel, speed);
    //addRequirements(RobotMap.Component.flywheelMotorA, RobotMap.Component.flywheelMotorB);
  }
}