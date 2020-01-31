package org.usfirst.frc4904.auton;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.Shoot;
import org.usfirst.frc4904.robot.subsystems.Indexer;
import org.usfirst.frc4904.robot.subsystems.Shooter;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;

class JustShoot extends CommandGroupBase {

    @Override
    public void addCommands(Command... commands) {
        // TODO: Fill in once these subsystems get put into robotmap
        andThen(new Shoot(null, null, 0));

    }

}