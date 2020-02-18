package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.robot.VisionTargetHub.VisionTargetType;

public class VisionTarget {
    public final double targetType;
    public final double distance;
    public final double beta;
    public final double theta;
    public final double poseX;
    public final double poseY;
    public final double deltaAngle;

    public VisionTarget(double targetType, double distance, double beta, double theta) {
        this.targetType = targetType;
        this.distance = distance;
        this.beta = beta;
        this.theta = theta;
        this.deltaAngle = beta - Math.PI / 2;

        this.poseX = calculateXPose();
        this.poseY = calculateYPose();
    }

    public double calculateXPose() {
        return distance * Math.sin(theta + deltaAngle);
    }

    public double calculateYPose() {
        return distance * Math.cos(theta + deltaAngle);
    }

    public boolean checkTargetType(VisionTargetType type) {
        return targetType == type.targetType;
    }
}
