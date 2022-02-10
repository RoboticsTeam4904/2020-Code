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

class ShootandPickupCenter extends AutonRoutine {

        public ShootandPickupCenter() { // TODO: Splining from the shooting pose to the balls will probably just make it
                                        // ram into the wall
                Trajectory goingToPowerCells = RobotMap.Component.sensorChassis
                                .generateQuinticTrajectory(Arrays.asList(Poses.shootingPose, Poses.centerCollectStart));
                SimpleSplines approachSpline = new SimpleSplines(RobotMap.Component.sensorChassis, goingToPowerCells);
                Trajectory collect = RobotMap.Component.sensorChassis.generateQuinticTrajectory(
                                Arrays.asList(Poses.centerCollectStart, Poses.centerCollectEnd));
                SimpleSplines collectSpline = new SimpleSplines(RobotMap.Component.sensorChassis, collect);

                addCommands(new VisionMoveHighPort(),
                                new ParallelCommandGroup(
                                                new BoxShot(RobotMap.Component.indexer, RobotMap.Component.shooter),
                                                new FlywheelSpinDown(RobotMap.Component.flywheel)),
                                approachSpline,
                                new ParallelCommandGroup(new RunIntake(RobotMap.Component.intake), collectSpline));
        }
}