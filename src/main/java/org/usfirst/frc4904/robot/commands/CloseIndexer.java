package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Indexer;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class CloseIndexer extends CommandBase {
  protected final Indexer indexer;

  /**
   * Retract the indexer solenoid to close the indexer flippers.
   * 
   * @param indexer The indexer to manipulate
   */
  public CloseIndexer(Indexer indexer) {
    super();
    setName("CloseIndexer");
    addRequirements(indexer.flippers);
    this.indexer = indexer;
  }

  @Override
  public void initialize() {
    indexer.closeFlippers();
  }
}
