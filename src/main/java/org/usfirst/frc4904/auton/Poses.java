package org.usfirst.frc4904.auton;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;

class Poses {

        //
        // All measurements are in inches, starting at the bottom left corner of the
        // field (I hope)
        //

        // Useful constants
        static final int topOfField = 319;
        static final int startOfField = 28;
        static final int widthofField = 649;
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

        static final Pose2d centerCollectStart = new Pose2d(0.0254 * 227, 0.0254 * ((topOfField - 94.66) - 50),
                        new Rotation2d(0));
        static final Pose2d centerCollectEnd = new Pose2d(0.0254 * 240, 0.0254 * ((topOfField - 94.66) - 81),
                        new Rotation2d(0));

        static final Pose2d sideCollectStart = new Pose2d(0.0254 * (startingLine + 122.63 - offset),
                        0.0254 * (topOfField - 94.66 + 66.91), new Rotation2d(0));
        static final Pose2d sideCollectEnd = new Pose2d(0.0254 * (startingLine + 194.63 + offset),
                        0.0254 * (topOfField - 94.66 + 66.91), new Rotation2d(0));
        static Pose2d shootingPose = new Pose2d(0.0254 * startOfField, 0.0254 * (topOfField - 94.66),
                        new Rotation2d(0));

        static Pose2d currentPos = new Pose2d(0.0254 * (120 + startOfField), 0.0254 * topOfField / 2,
                        new Rotation2d(0));// TODO:
                                           // Get
        // from
        // localization
}