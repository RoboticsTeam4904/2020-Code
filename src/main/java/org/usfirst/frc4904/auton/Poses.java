package org.usfirst.frc4904.auton;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;

class Poses {

    static final int topOfField = 500;
    static final int startOfField = 28;

    // TODO: calculate positions
    static final Pose2d centerCollectStart = new Pose2d(20.0, 20.0, new Rotation2d(4));
    static final Pose2d centerCollectEnd = new Pose2d(20.0, 20.0, new Rotation2d(4));
    static Pose2d shootingPose = new Pose2d(topOfField - 94.66, 0, new Rotation2d(90));
    static Pose2d sideCollection = new Pose2d(49.04, 25.4, new Rotation2d(5));
    static Pose2d centerCollection = new Pose2d(20.0, 20.0, new Rotation2d(4));

    static Pose2d currentPos = new Pose2d();// TODO: Get from localization
}