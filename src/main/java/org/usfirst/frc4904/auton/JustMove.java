package org.usfirst.frc4904.auton;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMoveDistance;

class JustMove extends AutonRoutine {

    public JustMove() {
        this.andThen(new ChassisMoveDistance(RobotMap.Component.chassis, 10, null)); // TODO: what motioncontroller?
    }
}