package org.usfirst.frc4904.auton;

import java.util.Arrays;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.commands.FlywheelSpinDown;
import org.usfirst.frc4904.robot.commands.RunIntake;
import org.usfirst.frc4904.robot.commands.Shoot;
import org.usfirst.frc4904.robot.commands.vision.VisionMoveHighPort;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;

import edu.wpi.first.wpilibj.trajectory.Trajectory;

class ShootandPickupCenter extends AutonRoutine {

        public ShootandPickupCenter() { // TODO: Splining from the shooting pose to the balls will probably just make it
                                        // ram into the wall
                andThen(new VisionMoveHighPort());
                double FlywheelSpeed = 0.0;
                andThen(new Shoot(RobotMap.Component.indexer, RobotMap.Component.shooter, FlywheelSpeed));
                andThen(new FlywheelSpinDown(RobotMap.Component.flywheel));

                Trajectory goingToPowerCells = RobotMap.Component.sensorChassis
                                .generateQuinticTrajectory(Arrays.asList(Poses.shootingPose, Poses.centerCollectStart));
                SimpleSplines approachSpline = new SimpleSplines(RobotMap.Component.sensorChassis, goingToPowerCells);
                this.andThen(approachSpline);
                this.andThen(new RunIntake(RobotMap.Component.intake));
                Trajectory collect = RobotMap.Component.sensorChassis.generateQuinticTrajectory(
                                Arrays.asList(Poses.centerCollectStart, Poses.centerCollectEnd));
                SimpleSplines collectSpline = new SimpleSplines(RobotMap.Component.sensorChassis, collect);
                this.andThen(collectSpline);
        }
}