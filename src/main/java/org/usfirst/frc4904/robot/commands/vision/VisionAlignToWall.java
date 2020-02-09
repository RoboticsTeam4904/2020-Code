package org.usfirst.frc4904.robot.commands.vision;

import java.util.List;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

/**
 * Given distance, beta, theta from target, drive right to the target
 */
public class VisionAlignToWall extends SequentialCommandGroup {
    protected static final double DEFAULT_ANGLE = 0.0;
    protected static final double DEFAULT_DISTANCE = 0.0;

    public VisionAlignToWall() {
        double beta = RobotMap.NetworkTables.Vision.beta.getDouble(DEFAULT_ANGLE);
        double deltaAngle = beta - 90;
        double xPose = RobotMap.NetworkTables.Vision.xDistanceToTarget.getDouble(DEFAULT_DISTANCE);
        double yPose = RobotMap.NetworkTables.Vision.yDistanceToTarget.getDouble(DEFAULT_DISTANCE);

        Trajectory traj = RobotMap.Component.splinesChassis
                .generateQuinticTrajectory(List.of(new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
                        new Pose2d(xPose, yPose, Rotation2d.fromDegrees(deltaAngle))));

        addCommands(new SimpleSplines(RobotMap.Component.splinesChassis, traj));
    }
}