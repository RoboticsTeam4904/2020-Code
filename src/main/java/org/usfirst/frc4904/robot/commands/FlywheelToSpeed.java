package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class FlywheelToSpeed extends CommandBase {
  protected final Flywheel flywheel;
//   protected MotorConstant spinUp;
  protected FlywheelMaintainSpeed maintainSpeed;
  protected double targetSpeed;
  public static final double THRESHOLD = 10.0;

  /**
   * Spin down the flywheel
   * 
   * @param flywheel The flywheel to manipulate
   */
  public FlywheelToSpeed(Flywheel flywheel, double targetSpeed) {
    super();
    setName("FlywheelToSpeed");
    addRequirements(flywheel);
    this.flywheel = flywheel;
    // this.spinUp = new MotorConstant("Flywheelspinup", flywheel, ((CustomPIDController) flywheel.getMC()).getF() * targetSpeed);
    this.maintainSpeed = new FlywheelMaintainSpeed(flywheel, 58.0);
  }

  @Override
  public void initialize() {
    super.initialize();
    maintainSpeed.schedule();
    flywheel.disableMotionController();
    flywheel.set(((CustomPIDController) flywheel.getMC()).getF() * targetSpeed);
  }

  @Override
  public void execute() {
    if(Math.abs(flywheel.getVelocity() - targetSpeed) < THRESHOLD || flywheel.getVelocity() > targetSpeed){
        flywh
    }
  }
}
