package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class IndexOne extends SequentialCommandGroup {
  /**
   * Open the flippers, run the run up belt until the limit switch is activated,
   * then close the flippers.
   */
  public IndexOne() {
    super(new OpenIndexer(), new MotorConstant("RunIndexer", RobotMap.Component.intake.lift, Intake.DEFAULT_LIFT_SPEED),
        new WaitUntilCommand(() -> {
          return RobotMap.Component.indexer.limitSwitch.get();
        }), new CloseIndexer());
    setName("IndexOne");
  }
}