package org.usfirst.frc4904.auton;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;

class JustMove extends CommandGroupBase {

    public JustMove() {
        this.andThen(new ChassisMoveDistance(null, 10, null));
    }

    @Override
    public void addCommands(Command... commands) {
    }

}