package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.commands.Shoot;
import org.usfirst.frc4904.robot.subsystems.Indexer;
import org.usfirst.frc4904.robot.subsystems.Intake;
import org.usfirst.frc4904.robot.subsystems.Shooter;

public class BoxShot extends Shoot {
  protected static final double DEFAULT_BOXSHOT_SPEED = 0.0; // TODO: Untested variables

  /**
   * Run the Shoot command for a box shot.
   * 
   * 
   * @param indexer The indexer subsystem
   * @param shooter The shooter subsystem
   * @param speed   The target speed of the flywheel
   */
  public BoxShot(Indexer indexer, Intake intake, Shooter shooter) {
    super(indexer, intake, shooter, DEFAULT_BOXSHOT_SPEED);
    setName("BoxShot");
  }
}