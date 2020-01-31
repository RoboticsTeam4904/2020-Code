package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Winch extends CommandBase {
  public static final double DEFAULT_WINCH_SPEED = 0; // TODO: This is an untested value
  protected final Motor winchMotor;
  protected double speed;

  /**
   * Winch the robot to hang on the generator switch
   * 
   * @param winchMotor The winch motor
   * @param speed      The speed to winch up with
   */
  Winch(Motor winchMotor, double speed) {
    super();
    setName("Winch");
    addRequirements(winchMotor);
    this.winchMotor = winchMotor;
    this.speed = speed;
  }

  /**
   * Winch the robot to hang on the generator switch
   * 
   * @param winchMotor The winch motor
   */
  Winch(Motor winchMotor) {
    this(winchMotor, DEFAULT_WINCH_SPEED);
  }

  public void initialize() {
    winchMotor.set(speed);
  }
}