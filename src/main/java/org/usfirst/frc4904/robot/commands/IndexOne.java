package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Indexer;
import org.usfirst.frc4904.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.robot.commands.OpenIndexer;
import org.usfirst.frc4904.robot.commands.CloseIndexer;

public class IndexOne extends SequentialCommandGroup {
  /**
   * Open the flippers, run the run up belt until the limit switch is activated,
   * then close the flippers.
   * 
   * @param indexer
   */
  public IndexOne(Indexer indexer, Intake intake) {
    super(new OpenIndexer(indexer), new MotorConstant("RunIndexer", intake.lift, Intake.DEFAULT_LIFT_SPEED),
        new WaitUntilCommand(() -> {
          return indexer.limitSwitch.get();
        }), new CloseIndexer(indexer));
    setName("IndexOne");
  }
}