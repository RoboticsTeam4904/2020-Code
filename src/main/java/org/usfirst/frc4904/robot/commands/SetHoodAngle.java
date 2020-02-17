package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Hood;

import edu.wpi.first.wpilibj2.command.CommandBase;
public class SetHoodAngle extends CommandBase {
  protected Hood hood;
  protected double angle;
  
  public SetHoodAngle(String name, Hood hood, double angle){
    super();
    setName(name);
    addRequirements(hood);
    this.hood = hood;
  }
  
  public SetHoodAngle(Hood hood, double angle){
    this("SetHoodAngle", hood, angle);
  }
  
  @Override
  public void initialize() {
    hood.enableMotionController();
    hood.setPosition(angle);
  }

  @Override
	public void execute() {
		Exception potentialSensorException = hood.checkSensorException();
		if (potentialSensorException != null) {
			cancel();
		}
	}

	@Override
	public boolean isFinished() {
		return hood.onTarget();
	}

}