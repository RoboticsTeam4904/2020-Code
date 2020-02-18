package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Indexer;
import org.usfirst.frc4904.robot.subsystems.Shooter;
import org.usfirst.frc4904.robot.subsystems.Flywheel.FlywheelStatus;
import org.usfirst.frc4904.standard.commands.RunIf;
import org.usfirst.frc4904.standard.commands.WaitUntil;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import java.lang.Math;

public class Shoot extends SequentialCommandGroup {
  protected static final double SPEED_TOLERANCE = 0.0; // TODO: Untested value
  /**
   * Check that the flywheel is spun up, spin up if it isn't, then call IndexOne
   * 
   * Psudo code:  
   * is flywheel target speed correct?  
   * yes -> continue  
   * no  -> FlywheelSpinUp()  
   * WaitUntil the flywheel is AT_SPEED  
   * IndexOne()  
   * 
   * @param indexer The indexer subsystem
   * @param shooter The shooter subsystem
   * @param speed   The target speed of the flywheel
   */
  public Shoot(Indexer indexer, Shooter shooter, double speed) {
    super(new RunIf(new FlywheelSpinUp(speed), () -> {
      return Math.abs(shooter.flywheel.getTargetSpeed() - speed) > SPEED_TOLERANCE;
    }), new WaitUntil(() -> {
      return shooter.flywheel.getStatus() == FlywheelStatus.AT_SPEED;
    }), new IndexOne(indexer));
    setName("Shoot");
  }
}