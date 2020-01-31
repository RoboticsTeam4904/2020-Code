package org.usfirst.frc4904.auton;

import java.util.Arrays;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.RunIntake;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;

import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;

class PickupAndShootCenter extends CommandGroupBase {

    @Override
    public void addCommands(Command... commands) {
        Trajectory goingToPowerCells = RobotMap.Component.sensorDrive
                .generateQuinticTrajectory(Arrays.asList(Poses.currentPos, Poses.centerCollectStart));
        goingToPowerCells.relativeTo(Poses.currentPos);
        SimpleSplines approachSpline = new SimpleSplines(RobotMap.Component.sensorDrive, goingToPowerCells);
        this.andThen(approachSpline);
        this.andThen(new RunIntake(RobotMap.Component.intake));
        Trajectory collect = RobotMap.Component.sensorDrive
                .generateQuinticTrajectory(Arrays.asList(Poses.currentPos, Poses.centerCollectEnd));
        goingToPowerCells.relativeTo(Poses.currentPos);
        SimpleSplines collectSpline = new SimpleSplines(RobotMap.Component.sensorDrive, collect);
        this.andThen(collectSpline);

    }
}