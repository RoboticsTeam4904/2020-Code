package org.usfirst.frc4904.auton;

import java.util.Arrays;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.FlywheelSpinDown;
import org.usfirst.frc4904.robot.commands.RunIntake;
import org.usfirst.frc4904.robot.commands.Shoot;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;

import edu.wpi.first.wpilibj.trajectory.Trajectory;

class PickupAndShootCenter extends AutonRoutine {

        public PickupAndShootCenter() {
                Trajectory goingToPowerCells = RobotMap.Component.sensorChassis
                                .generateQuinticTrajectory(Arrays.asList(Poses.currentPos, Poses.centerCollectStart));
                SimpleSplines approachSpline = new SimpleSplines(RobotMap.Component.sensorChassis, goingToPowerCells);
                this.andThen(approachSpline);
                this.andThen(new RunIntake(RobotMap.Component.intake));
                Trajectory collect = RobotMap.Component.sensorChassis.generateQuinticTrajectory(
                                Arrays.asList(Poses.centerCollectStart, Poses.centerCollectEnd));
                goingToPowerCells.relativeTo(Poses.currentPos);
                SimpleSplines collectSpline = new SimpleSplines(RobotMap.Component.sensorChassis, collect);
                this.andThen(collectSpline);
                Trajectory moveToShoot = RobotMap.Component.sensorChassis
                                .generateQuinticTrajectory(Arrays.asList(Poses.centerCollectEnd, Poses.shootingPose));
                SimpleSplines moveToShootSpline = new SimpleSplines(RobotMap.Component.sensorChassis, moveToShoot);
                this.andThen(moveToShootSpline);
                double FlywheelSpeed = 0.0;
                andThen(new Shoot(RobotMap.Component.indexer, RobotMap.Component.shooter, FlywheelSpeed));
                andThen(new FlywheelSpinDown(RobotMap.Component.flywheel));
        }
}