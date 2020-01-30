package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Indexer;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;

import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.robot.subsystems.Shooter;
import org.usfirst.frc4904.robot.commands.OpenIndexer;
import org.usfirst.frc4904.robot.commands.CloseIndexer;

// TODO: Logic needs to be written
public class IndexOne extends SequentialCommandGroup {
  public IndexOne(Indexer indexer, Shooter shooter) {
    super(new OpenIndexer(indexer),
        new MotorConstant("IndexerMotorConstant", indexer.liftBelts, Indexer.DEFAULT_LIFT_SPEED),
        new WaitUntilCommand(() -> {
          return shooter.limitSwitch.get();
        }), new CloseIndexer(indexer));
    setName("IndexOne");
    addRequirements(indexer.liftBelts, indexer.flippers);
  }
}