package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class LowerHook extends CommandBase {
  public static final double DEFAULT_DOWN_SPEED = -0; // TODO: This is an untested value
  protected final Motor tubeMotor;
  protected double speed;

  /**
   * Lower the deploy tube to hook onto the generator switch
   * 
   * @param tubeMotor The motor to use to lower
   * @param speed     The speed to lower the deploy tube at (should be a positive
   *                  number)
   */
  LowerHook(Motor tubeMotor, double speed) {
    super();
    setName("LowerHook");
    addRequirements(tubeMotor);
    this.tubeMotor = tubeMotor;
    this.speed = -speed;
  }

  /**
   * Lower the deploy tube to hook onto the generator switch
   * 
   * @param tubeMotor The motor to use to lower
   */
  LowerHook(Motor tubeMotor) {
    this(tubeMotor, DEFAULT_DOWN_SPEED);
  }

  @Override
  public void execute() {
    tubeMotor.set(speed);
  }
}