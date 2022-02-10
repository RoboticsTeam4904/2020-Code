package org.usfirst.frc4904.auton;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.Shoot;

class JustShoot extends AutonRoutine {

    public JustShoot() {
        andThen(new Shoot(RobotMap.Component.indexer, RobotMap.Component.shooter, 0.5));
    }

}