package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class LowerHook extends MotorConstant {
  public static final double DEFAULT_DOWN_SPEED = -0; // TODO: This is an untested value
  public Motor tubeMotor;
  public double speed;

  /**
   * Lower the deploy tube to hook onto the generator switch
   * 
   * @param name
   * @param speed The speed to lower the deploy tube at
   */
  public LowerHook(String name, Double speed) {
    super(name, RobotMap.Component.hookMotor, speed);
  }

  /**
   * Lower the deploy tube to hook onto the generator switch
   * 
   * @param name
   */
  public LowerHook(String name) {
    this(name, DEFAULT_DOWN_SPEED);
  }

  /**
   * Lower the deploy tube to hook onto the generator switch
   * 
   * @param speed The speed to lower the deploy tube at
   */
  public LowerHook(Double speed) {
    this("LowerHook", speed);
  }

  /**
   * Lower the deploy tube to hook onto the generator switch
   * 
   */
  public LowerHook() {
    this("LowerHook", DEFAULT_DOWN_SPEED);
  }
}