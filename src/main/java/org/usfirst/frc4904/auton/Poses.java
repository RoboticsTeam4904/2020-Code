package org.usfirst.frc4904.auton;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.util.Units;

class Poses {

        // All measurements are taken in inches and converted into meters, starting at
        // the bottom left corner of the field (I hope)

        // Useful constants
        static final double TOP_OF_FIELD = Units.inchesToMeters(319);
        static final double START_OF_FIELD = Units.inchesToMeters(28);
        static final double WIDTH_OF_FIELD = Units.inchesToMeters(649);
        static final double FIRST_CENTER_BALL = Units.inchesToMeters(122.63);

        // y position of center ball is 94.66 + 43.65 inches
        // see layout and marking diagram pages 4 and 5

        static final double CENTER_BALL_POS_Y = Units.inchesToMeters(138.41);

        static final double OFFSET = Units.inchesToMeters(5);
        static final double STARTING_LINE = Units.inchesToMeters(120);

        // x position of center ball
        // from right side of field:
        // 374.59+130.36 - 122.63
        static final double centerBallposX = -1;

        static final Pose2d centerCollectStart = new Pose2d(Units.inchesToMeters(227),
                        Units.inchesToMeters((TOP_OF_FIELD - 94.66) - 50), new Rotation2d(0));
        static final Pose2d centerCollectEnd = new Pose2d(Units.inchesToMeters(240),
                        Units.inchesToMeters((TOP_OF_FIELD - 94.66) - 81), new Rotation2d(0));

        static final Pose2d sideCollectStart = new Pose2d(Units.inchesToMeters(STARTING_LINE + 122.63 - OFFSET),
                        Units.inchesToMeters(TOP_OF_FIELD - 94.66 + 66.91), new Rotation2d(0));
        static final Pose2d sideCollectEnd = new Pose2d(Units.inchesToMeters(STARTING_LINE + 194.63 + OFFSET),
                        Units.inchesToMeters(TOP_OF_FIELD - 94.66 + 66.91), new Rotation2d(0));
        static Pose2d shootingPose = new Pose2d(Units.inchesToMeters(START_OF_FIELD),
                        Units.inchesToMeters(TOP_OF_FIELD - 94.66), new Rotation2d(0));

        static Pose2d currentPos = new Pose2d(Units.inchesToMeters(120 + START_OF_FIELD),
                        Units.inchesToMeters(TOP_OF_FIELD / 2), new Rotation2d(0)); // TODO: Get from localization
}