package org.usfirst.frc4904.auton;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;

class Poses {

    //
    // All measurements are in inches, starting at the bottom left corner of the
    // field (I hope)
    //

    // Useful constants
    static final int topOfField = 500;
    static final int startOfField = 28;
    static final double firstCenterBall = 122.63;
    // y position of center ball is 94.66 +43.65
    // see layout and marking diagram pages 4 and 5
    static final double centerBallposY = 138.41;

    static final double offset = 5;
    static final double startingLine = 120;

    // x position of center ball
    // from right side of field:
    // 374.59+130.36 - 122.63
    static final double centerBallposX = -1;

    // TODO: calculate positions (any value with -1)
    static final Pose2d centerCollectStart = new Pose2d(120, -1, new Rotation2d(4));
    static final Pose2d centerCollectEnd = new Pose2d(392.49, 175.8, new Rotation2d(4));

    static final Pose2d sideCollectionStart = new Pose2d(startingLine + 122.63 - offset, topOfField - 94.66 + 66.91,
            new Rotation2d(0));
    static final Pose2d sideCollectionEnd = new Pose2d(startingLine + 194.63 + offset, topOfField - 94.66 + 66.91,
            new Rotation2d(0));
    static Pose2d shootingPose = new Pose2d(startOfField, topOfField - 94.66, new Rotation2d(90));

    static Pose2d currentPos = new Pose2d();// TODO: Get from localization
}