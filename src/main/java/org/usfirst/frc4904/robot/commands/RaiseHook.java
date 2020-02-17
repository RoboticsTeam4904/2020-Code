package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class RaiseHook extends MotorConstant {
  public static final double DEFAULT_UP_SPEED = 0; // TODO: This is an untested value
  protected Motor tubeMotor;
  protected double speed;

  /**
   * Raise the deploy tube to hook onto the generator switch
   * 
   * @param name      The name the motor uses
   * @param speed     The speed to raise the deploy tube at
   */
  public RaiseHook(String name, Double speed) {
    super(name, RobotMap.Component.hookMotor, speed);
  }

  /**
   * Raise the deploy tube to hook onto the generator switch
   * 
   * @param name      The name the motor uses
   */
  public RaiseHook(Double speed) {
    this("RaiseHook", speed);
  }

  /**
   * Raise the deploy tube to hook onto the generator switch
   * 
   * @param name      The name the motor uses
   */
  public RaiseHook(String name) {
    this(name, DEFAULT_UP_SPEED);
  }

  /**
   * Raise the deploy tube to hook onto the generator switch
   * 
   */
  public RaiseHook() {
    this("RaiseHook", DEFAULT_UP_SPEED);
  }
}