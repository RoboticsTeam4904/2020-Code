package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Indexer;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class OpenIndexer extends SolenoidExtend {

  /**
   * Extend the indexer solenoid to open the indexer flippers.
   * 
   * @param indexer The indexer to manipulate
   */
  public OpenIndexer(Indexer indexer) {
    super("OpenIndexer", indexer.flippers);
  }
}
