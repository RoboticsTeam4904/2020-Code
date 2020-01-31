package org.usfirst.frc4904.auton;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

class JustMove extends SequentialCommandGroup {

    public JustMove() {
        this.andThen(new ChassisMoveDistance(RobotMap.Component.chassis, 10, null));
    }
}