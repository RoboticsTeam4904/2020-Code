package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;


public class Winch extends MotorConstant {
  public static final double DEFAULT_WINCH_SPEED = 0; // TODO: This is an untested value

  /**
   * Winch the robot to hang on the generator switch
   * 
   * @param name
   * @param speed      The speed to winch up with
   */
  public Winch(String name, double speed) {
    super(name, RobotMap.Component.winchMotor, speed);
  }

  /**
   * Winch the robot to hang on the generator switch
   * 
   * @param speed      The speed to winch up with
   */
  public Winch(double speed) {
    this("Winch", speed);
  }

  /**
   * Winch the robot to hang on the generator switch
   * 
   * @param name 
   */
  public Winch(String name) {
    this(name, DEFAULT_WINCH_SPEED);
  }

  /**
   * Winch the robot to hang on the generator switch
   * 
   */
  public Winch() {
    this(DEFAULT_WINCH_SPEED);
  }

}