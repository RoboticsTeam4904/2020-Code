package org.usfirst.frc4904.robot.commands;

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
  Winch(Motor winchMotor, double speed) {
    super("Winch", winchMotor, speed);
  }

  /**
   * Winch the robot to hang on the generator switch
   * 
   * @param winchMotor The winch motor
   */
  Winch(Motor winchMotor) {
    this(winchMotor, DEFAULT_WINCH_SPEED);
  }

  @Override
  public void execute() {
    winchMotor.set(speed);
  }
}