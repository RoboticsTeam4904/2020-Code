package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class HoodMotorConstant extends CommandBase {
    private PWMSpeedController speedController;
    private final double speed = 0;

    public HoodMotorConstant(PWMSpeedController speedController){
        super();
        this.speedController = speedController;
    }

    @Override
	public void initialize() {
		speedController.set(speed);
	}

	@Override
	public void execute() {
		speedController.set(speed);
	}

	@Override
	public void end(boolean interrupted) {
		if (!interrupted) {
			speedController.set(0.0);
		}
	}

}