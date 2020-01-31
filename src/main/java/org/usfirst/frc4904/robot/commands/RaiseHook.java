package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class RaiseHook extends CommandBase {
  public static final double DEFAULT_UP_SPEED = 0; // TODO: This is an untested value
  protected final Motor tubeMotor;
  protected double speed;

  /**
   * Raise the deploy tube to hook onto the generator switch
   * 
   * @param tubeMotor The motor to use to raise
   * @param speed     The speed to raise the deploy tube at
   */
  RaiseHook(Motor tubeMotor, double speed) {
    super();
    setName("RaiseHook");
    addRequirements(tubeMotor);
    this.tubeMotor = tubeMotor;
    this.speed = speed;
  }

  /**
   * Raise the deploy tube to hook onto the generator switch
   * 
   * @param tubeMotor The motor to use to raise
   */
  RaiseHook(Motor tubeMotor) {
    this(tubeMotor, DEFAULT_UP_SPEED);
  }

  @Override
  public void execute() {
    tubeMotor.set(speed);
  }
}