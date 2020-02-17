package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Flywheel;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class FlywheelSpinDown extends CommandBase {
  public static final double DEFAULT_IDLE_SPEED = 0.0;
  protected final Flywheel flywheel;

  /**
   * Spin down the flywheel
   * 
   * @param flywheel The flywheel to manipulate
   */
  public FlywheelSpinDown(Flywheel flywheel) {
    super();
    setName("FlywheelSpinDown");
    addRequirements(flywheel);
    this.flywheel = flywheel;
  }

  @Override
  public void initialize() {
    super.initialize();
    flywheel.disableMotionController();
  }

  @Override
  public void execute() {
    flywheel.set(DEFAULT_IDLE_SPEED);
  }
}
