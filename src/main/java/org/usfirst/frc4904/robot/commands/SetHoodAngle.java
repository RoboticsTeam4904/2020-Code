package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.custom.sensors.InvalidSensorException;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetHoodAngle extends CommandBase {
  protected double angle;

  public SetHoodAngle(double angle) {
    super();
    setName("SetHoodAngle");
    addRequirements(RobotMap.Component.hood);
    this.angle = angle;
  }

  @Override
  public void initialize() {
    RobotMap.Component.hood.enableMotionController();
    RobotMap.Component.hood.setPosition(angle);
    LogKitten.wtf("Hood Angle Goal: " + angle);
  }

  @Override
  public void execute() {
    RobotMap.Component.hood.getMotor().set(RobotMap.Component.hood.get());
    LogKitten.wtf(RobotMap.Component.hood.get());
    Exception potentialSensorException = RobotMap.Component.hood.checkSensorException();
    if (potentialSensorException != null) {
      cancel();
    }
  }

  @Override
  public boolean isFinished() {
    RobotMap.Component.hood.getMotor().set(0.0);
    return RobotMap.Component.hood.onTarget();
  }

}