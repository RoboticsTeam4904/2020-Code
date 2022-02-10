package org.usfirst.frc4904.robot.commands.vision;

import java.util.List;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.VisionTarget;
import org.usfirst.frc4904.robot.VisionTargetHub;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;
import org.usfirst.frc4904.standard.subsystems.chassis.SensorDrive;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * Drive to the closest target of a certain type
 */
public class VisionMove extends SequentialCommandGroup {

    public VisionMove(VisionTargetHub hub, double intendedTargetType, SensorDrive sensorChassis, double robotLength) {
        VisionTarget target = hub.findIdealTarget(intendedTargetType);
        Trajectory traj = sensorChassis.generateQuinticTrajectory(List.of(new Pose2d(0, 0, new Rotation2d(0)),
                new Pose2d(target.poseX, target.poseY - robotLength / 2, new Rotation2d(target.deltaAngle))));

        addCommands(new SimpleSplines(RobotMap.Component.splinesChassis, traj));
    }
}