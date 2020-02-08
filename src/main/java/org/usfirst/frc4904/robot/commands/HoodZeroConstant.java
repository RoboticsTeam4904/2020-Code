package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Hood;

import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class HoodZeroConstant extends CommandBase {
    protected final PWMSpeedController speedController;
    protected final double PWMspeed;
    protected final boolean limitType;
    protected final Hood hood;

    public HoodZeroConstant(String name, Hood hood, double PWMspeed, boolean limitType) {
        super();
        setName(name);
        this.hood = hood;
        this.speedController = hood.getServo();
        this.PWMspeed = PWMspeed;
        this.limitType = limitType;
        addRequirements(hood);
    }

    public HoodZeroConstant(Hood hood, double PWMspeed, boolean limitType) {
        this("HoodZeroConstant", hood, PWMspeed, limitType);
    }

    @Override
    public void initialize() {
        speedController.set(PWMspeed);
    }

    @Override
    public void execute() {
        speedController.set(PWMspeed);
    }

    @Override
    public void end(boolean interrupted) {
        if (!interrupted) {
            speedController.set(0.0);
            hood.setLimit(limitType);
        }
    }

}