package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Indexer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CloseIndexer extends CommandBase {
  protected final Indexer indexer;

  /**
   * Extend the indexer solenoid to open the indexer flippers.
   * 
   * @param indexer The indexer to manipulate
   */
  public CloseIndexer(Indexer indexer) {
    super();
    setName("CloseIndexer");
    addRequirements(indexer.flippers);
    this.indexer = indexer;
  }

  public void initialize() {
    indexer.closeFlippers();
  }
}
