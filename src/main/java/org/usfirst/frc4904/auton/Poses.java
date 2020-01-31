package org.usfirst.frc4904.auton;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;

class Poses {
    static Pose2d shootingPose;
    static Pose2d sideCollection;
    static Pose2d centerCollection = new Pose2d(20.0, 20.0, new Rotation2d(4));
}