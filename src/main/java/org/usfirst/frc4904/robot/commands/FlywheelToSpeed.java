package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.InvalidSensorException;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class FlywheelToSpeed extends CommandBase {
  protected final Flywheel flywheel;
  protected double targetSpeed;
  protected double rawTargetOutput;
  public static final double THRESHOLD = 10.0;
  protected boolean lastTickWithin = false;

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
    this.targetSpeed = targetSpeed;
    this.rawTargetOutput = ((CustomPIDController) flywheel.getMC()).getF() * targetSpeed;
  }

  @Override
  public void initialize() {
    super.initialize();
    flywheel.disableMotionController();
    flywheel.set(rawTargetOutput);
  }

  @Override
  public void execute() {
    boolean tickWithin = Math.abs(flywheel.getVelocity() - targetSpeed) < THRESHOLD || flywheel.getVelocity() > targetSpeed;
    if (tickWithin) {
      if(lastTickWithin){
        LogKitten.wtf("continue PID");
        flywheel.set(targetSpeed);
        Exception potentialSensorException = flywheel.checkSensorException();
        if (potentialSensorException != null) {
          cancel();
        }
      }else{
        LogKitten.wtf("start PID");
        try {
          flywheel.reset();
          flywheel.enableMotionController();
          flywheel.set(targetSpeed);
        } catch (InvalidSensorException e) {
          cancel();
        }
      }
    }else{
      if(!lastTickWithin){
        LogKitten.wtf("continue raw");
        flywheel.set(rawTargetOutput);
      }else{
        LogKitten.wtf("start raw");
        flywheel.disableMotionController();
        flywheel.set(rawTargetOutput);
      }
    }
    lastTickWithin = tickWithin;
    LogKitten.wtf(tickWithin);
  }

  @Override
	public void end(boolean interrupted) {
		flywheel.disableMotionController();
		if (!interrupted) {
			flywheel.set(0.0);
		}
	}
}
