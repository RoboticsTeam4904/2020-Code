package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Indexer;

import edu.wpi.first.wpilibj2.command.CommandBase;


/**
 * TODO Summary
 * 
 * This branch is supposed to be put together once we have both the flywheel and
 * indexer subsystems in place. It will contain commands to:
 * - [ ] Spin up the flywheel to a speed
 * - [ ] Spin up the flywheel for a distance
 * - [ ] Spin up the flywheel for a generic box shot (while touching the base of the box)
 * - [ ] Index and shoot one ball (this file) (checking that the flywheel is at speed before shooting)
 * 
 * Other TODOs: 
 * - add everything for the indexer, index solenoid, and flywheel to robotmap
 * - bind the commands for the shooting routines in humaninterface
 * - have a button for spinning up the flywheel and a button for shooting once (aka calling this command)
 * package org.usfirst.frc4904.robot.commands;
*/

public class IndexOne extends CommandGroupBase {
  protected final Indexer indexer;
  protected final Flywheel flywheel;

  IndexOne(Indexer indexer, Flywheel flywheel) {
    super();
    setName("IndexOne");
    this.indexer = indexer;
    this.flywheel = flywheel;
    addRequirements(indexer, flywheel);
  }

  public void onInitialize() {
    // indexer.
    
  }
}