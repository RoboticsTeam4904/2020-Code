package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Hood;

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
  }

  @Override
  public void execute() {
    RobotMap.Component.hood.set(RobotMap.Component.hoodPID.get());
    Exception potentialSensorException = RobotMap.Component.hood.checkSensorException();
    if (potentialSensorException != null) {
      cancel();
    }
  }

  @Override
  public boolean isFinished() {
    return Math.abs(RobotMap.Component.hood.getHoodAngle() - angle) < Hood.tolerance;
  }

  @Override
  public void end(boolean interrupted) {
    RobotMap.Component.hood.disableMotionController();
  }

}