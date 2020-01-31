package org.usfirst.frc4904.auton;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.Shoot;
import org.usfirst.frc4904.robot.subsystems.Indexer;
import org.usfirst.frc4904.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

class JustShoot extends SequentialCommandGroup {

    public JustShoot() {
        andThen(new Shoot(RobotMap.Component.indexer, RobotMap.Component.shooter, 0));
    }

}