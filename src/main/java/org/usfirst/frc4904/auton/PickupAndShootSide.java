package org.usfirst.frc4904.auton;

import java.util.Arrays;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;

import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;

class PickupAndShootSide extends CommandGroupBase {
    
    @Override
    public void addCommands(Command... commands) {
        Trajectory goingToPowerCells = RobotMap.Component.sensorDrive
                .generateQuinticTrajectory(Arrays.asList(Poses.shootingPose, Poses.sideCollection));
        SimpleSplines splines = new SimpleSplines(RobotMap.Component.sensorDrive, goingToPowerCells);
        this.andThen(splines);
    }

}