package org.usfirst.frc4904.auton;

import java.util.Arrays;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.BoxShot;
import org.usfirst.frc4904.robot.commands.FlywheelSpinDown;
import org.usfirst.frc4904.robot.commands.RunIntake;
import org.usfirst.frc4904.robot.commands.vision.VisionMoveHighPort;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;

import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

class PickupAndShootSide extends AutonRoutine {

        public PickupAndShootSide() {
                Trajectory goingToPowerCells = RobotMap.Component.sensorChassis
                                .generateQuinticTrajectory(Arrays.asList(Poses.currentPos, Poses.sideCollectStart));
                SimpleSplines approachSpline = new SimpleSplines(RobotMap.Component.sensorChassis, goingToPowerCells);
                Trajectory collect = RobotMap.Component.sensorChassis
                                .generateQuinticTrajectory(Arrays.asList(Poses.sideCollectStart, Poses.sideCollectEnd));
                SimpleSplines collectSpline = new SimpleSplines(RobotMap.Component.sensorChassis, collect);
                addCommands(approachSpline,
                                new ParallelCommandGroup(new RunIntake(RobotMap.Component.intake), collectSpline),
                                new VisionMoveHighPort(),
                                new ParallelCommandGroup(
                                                new BoxShot(RobotMap.Component.indexer, RobotMap.Component.shooter),
                                                new FlywheelSpinDown(RobotMap.Component.flywheel)));
        }
}