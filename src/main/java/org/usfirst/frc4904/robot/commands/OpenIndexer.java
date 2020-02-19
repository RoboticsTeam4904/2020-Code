package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;

public class OpenIndexer extends SolenoidExtend {

  /**
   * Extend the indexer solenoid to open the indexer flippers.
   */
  public OpenIndexer() {
    super("OpenIndexer", RobotMap.Component.indexer.flippers);
  }
}
