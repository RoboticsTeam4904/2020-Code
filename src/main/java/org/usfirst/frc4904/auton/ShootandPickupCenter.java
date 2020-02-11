package org.usfirst.frc4904.auton;

import java.util.Arrays;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.FlywheelSpinDown;
import org.usfirst.frc4904.robot.commands.RunIntake;
import org.usfirst.frc4904.robot.commands.Shoot;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;

import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

class ShootandPickupCenter extends AutonRoutine {

        public ShootandPickupCenter() {
                Trajectory moveToShoot = RobotMap.Component.sensorDrive
                                .generateQuinticTrajectory(Arrays.asList(Poses.currentPos, Poses.shootingPose));
                SimpleSplines moveToShootSpline = new SimpleSplines(RobotMap.Component.sensorDrive, moveToShoot);
                this.andThen(moveToShootSpline);
                double FlywheelSpeed = 0.0;
                andThen(new Shoot(RobotMap.Component.indexer, RobotMap.Component.shooter, FlywheelSpeed));
                andThen(new FlywheelSpinDown(RobotMap.Component.flywheel));

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