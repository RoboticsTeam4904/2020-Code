package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.robot.subsystems.Indexer;
import org.usfirst.frc4904.robot.subsystems.Flywheel.FlywheelStatus;
import java.util.function.BooleanSupplier;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import edu.wpi.first.wpilibj2.command.WaitUntilCommand;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.robot.subsystems.Shooter;
import org.usfirst.frc4904.robot.commands.OpenIndexer;
import org.usfirst.frc4904.robot.commands.CloseIndexer;

/**
 * This command opens indexer flippers, runs the belt motors, waits until the
 * limit switch is hit, and closes the indexer flippers.
 * 
 * TODO Summary
 * 
 * This branch is supposed to be put together once we have both the flywheel and
 * indexer subsystems in place. It will contain commands to: - [ ] Spin up the
 * flywheel to a speed - [ ] Spin up the flywheel for a distance - [ ] Spin up
 * the flywheel for a generic box shot (while touching the base of the box) - [
 * ] Index and shoot one ball (this file) (checking that the flywheel is at
 * speed before shooting)
 * 
 * Other TODOs: - add everything for the indexer, index solenoid, and flywheel
 * to robotmap - bind the commands for the shooting routines in humaninterface -
 * have a button for spinning up the flywheel and a button for shooting once
 * (aka calling this command) package org.usfirst.frc4904.robot.commands;
 */

public class IndexOne extends SequentialCommandGroup {
  public IndexOne(Indexer indexer, Shooter shooter) {
    super(new OpenIndexer(indexer),
        new MotorConstant("IndexerMotorConstant", indexer.liftBelts, Indexer.DEFAULT_LIFT_SPEED),

        new WaitUntilCommand(() -> {
          return shooter.limitSwitch.get();
        }), new CloseIndexer(indexer));
    setName("IndexOne");
    addRequirements(indexer.liftBelts);
    addRequirements(indexer.flippers);
  }
}