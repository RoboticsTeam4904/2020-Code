package org.usfirst.frc4904.robot.commands;

import java.util.List;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class VisionDistanceAlign extends SequentialCommandGroup {
    protected static final double DEFAULT_ANGLE = 0.0;
    protected static final double DEFAULT_DISTANCE = 0.0;

    public VisionDistanceAlign() {
        double currentAngle = RobotMap.Component.navx.getYaw();
        double beta = RobotMap.NetworkTables.Vision.beta.getDouble(DEFAULT_ANGLE);
        double distance = RobotMap.NetworkTables.Vision.distanceToTarget.getDouble(DEFAULT_DISTANCE);
        double xPose = Math.cos(beta) * distance;
        double yPose = Math.sin(beta) * distance;

        Trajectory traj = RobotMap.Component.splinesChassis
                .generateQuinticTrajectory(List.of(new Pose2d(0, 0, Rotation2d.fromDegrees(currentAngle)),
                        new Pose2d(xPose, yPose, Rotation2d.fromDegrees(currentAngle - beta))));

        addCommands(new SimpleSplines(RobotMap.Component.splinesChassis, traj));
    }
}