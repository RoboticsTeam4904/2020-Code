package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Flywheel;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class FlywheelSpinUp extends CommandBase {
  public static final double DEFAULT_FLYWHEEL_SPEED = 0.9; // TODO: This is an untested value
  protected final Flywheel flywheel;
  protected final double speed;

  /**
   * Spin up the flywheel to a speed
   * 
   * @param flywheel The flywheel to manipulate
   * @param speed    The speed to spin the flywheel up to
   */
  FlywheelSpinUp(Flywheel flywheel, double speed) {
    super();
    setName("FlywheelSpinUp");
    addRequirements(flywheel);
    this.flywheel = flywheel;
    this.speed = speed;
  }

  /**
   * Spin up the flywheel to the default speed
   * 
   * @param flywheel The flywheel to manipulate
   */
  FlywheelSpinUp(Flywheel flywheel) {
    this(flywheel, DEFAULT_FLYWHEEL_SPEED);
  }

  @Override
  public void execute() {
    flywheel.setSpeed(speed);
  }
}