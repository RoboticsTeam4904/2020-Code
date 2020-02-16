package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class LowerHook extends MotorConstant {
  public static final double DEFAULT_DOWN_SPEED = -0; // TODO: This is an untested value
  public Motor tubeMotor;
  public double speed;

  /**
   * Lower the deploy tube to hook onto the generator switch
   * 
   * @param tubeMotor The motor to use to lower
   * @param speed     The speed to lower the deploy tube at
   */
  LowerHook(Motor tubeMotor, double speed) {
    super("LowerHook", tubeMotor, speed);
  }

  /**
   * Lower the deploy tube to hook onto the generator switch
   * 
   * @param tubeMotor The motor to use to lower
   */
  LowerHook(Motor tubeMotor) {
    this(tubeMotor, DEFAULT_DOWN_SPEED);
  }

}