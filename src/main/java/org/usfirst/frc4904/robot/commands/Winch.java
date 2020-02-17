package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class Winch extends MotorConstant {
  public static final double DEFAULT_WINCH_SPEED = 0; // TODO: This is an untested value
  protected Motor winchMotor;
  protected double speed;

  /**
   * Winch the robot to hang on the generator switch
   * 
   * @param winchMotor The winch motor
   * @param speed      The speed to winch up with
   */
  Winch() {
    super("Winch", RobotMap.Component.winchMotor, DEFAULT_WINCH_SPEED);
  }

  /**
   * Winch the robot to hang on the generator switch
   * 
   * @param winchMotor The winch motor
   */

}