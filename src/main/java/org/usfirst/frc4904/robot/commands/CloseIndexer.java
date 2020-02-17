package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Indexer;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class CloseIndexer extends SolenoidExtend {
  /**
   * Retract the indexer solenoid to close the indexer flippers.
   * 
   * @param indexer The indexer to manipulate
   */
  public CloseIndexer(Indexer indexer) {
    super("CloseIndexer", indexer.flippers);
  }
}
