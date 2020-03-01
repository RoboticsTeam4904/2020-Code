package org.usfirst.frc4904.robot;

public enum VisionTargetType {
    HIGH_PORT(0), LOADING_PORT(1);

    public int targetType;

    private VisionTargetType(int targetType) {
        this.targetType = targetType;
    }
}