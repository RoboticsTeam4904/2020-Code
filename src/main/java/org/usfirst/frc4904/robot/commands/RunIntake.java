package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Intake;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class RunIntake extends CommandBase {
    protected final Intake intake;

    /**
     * Start the intake
     * 
     * @param intake The intake to manipulate
     */
    RunIntake(Intake intake) {
        super();
        setName("RunIntake");
        addRequirements(intake.intake);
        this.intake = intake;
    }

    public void initialize() {
        this.intake.start();
    }
}