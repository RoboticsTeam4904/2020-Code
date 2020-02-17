package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.motor.MotorSet;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class MoveHook extends MotorSet {
  public static final double DEFAULT_UP_SPEED = 0; // TODO: This is an untested value
  protected Motor tubeMotor;
  protected double speed;

  /**
   * Raise the deploy tube to hook onto the generator switch
   * 
   * @param tubeMotor The motor to use to raise
   * @param speed     The speed to raise the deploy tube at
   */
  public MoveHook(Motor tubeMotor) {
    super("RaiseHook", tubeMotor);
    this.set(DEFAULT_UP_SPEED);
  }

  @Override
  public void execute() {
    super.execute();
    this.set(RobotMap.HumanInput.Driver.xbox.rightStick.getY() / 2.0);
  }
}