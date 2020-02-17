package org.usfirst.frc4904.auton;

import java.util.Arrays;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.FlywheelSpinDown;
import org.usfirst.frc4904.robot.commands.RunIntake;
import org.usfirst.frc4904.robot.commands.Shoot;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;

import edu.wpi.first.wpilibj.trajectory.Trajectory;

class ShootAndPickupSide extends AutonRoutine {

    public ShootAndPickupSide() {
        Trajectory moveToShoot = RobotMap.Component.sensorChassis
                .generateQuinticTrajectory(Arrays.asList(Poses.currentPos, Poses.shootingPose));
        SimpleSplines moveToShootSpline = new SimpleSplines(RobotMap.Component.sensorChassis, moveToShoot);
        this.andThen(moveToShootSpline);
        double FlywheelSpeed = 0.0;
        andThen(new Shoot(RobotMap.Component.indexer, RobotMap.Component.shooter, FlywheelSpeed));
        andThen(new FlywheelSpinDown(RobotMap.Component.flywheel));

        Trajectory goingToPowerCells = RobotMap.Component.sensorChassis
                .generateQuinticTrajectory(Arrays.asList(Poses.shootingPose, Poses.sideCollectStart));
        SimpleSplines approachSpline = new SimpleSplines(RobotMap.Component.sensorChassis, goingToPowerCells);
        this.andThen(approachSpline);
        this.andThen(new RunIntake(RobotMap.Component.intake));
        Trajectory collect = RobotMap.Component.sensorChassis
                .generateQuinticTrajectory(Arrays.asList(Poses.sideCollectStart, Poses.sideCollectEnd));
        goingToPowerCells.relativeTo(Poses.currentPos);
        SimpleSplines collectSpline = new SimpleSplines(RobotMap.Component.sensorChassis, collect);
        this.andThen(collectSpline);
    }

}