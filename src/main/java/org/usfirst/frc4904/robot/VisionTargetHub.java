package org.usfirst.frc4904.robot;

import java.util.Arrays;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.VisionTarget;

import edu.wpi.first.wpilibj2.command.Subsystem;

public class VisionTargetHub implements Subsystem {
    protected static final double[] DEFAULT_INPUT_ARRAY = new double[0];
    protected static double[] targetTypes;
    protected static double[] distances;
    protected static double[] betas;
    protected static double[] thetas;
    public static VisionTarget[] targets;
    protected boolean isEnabled;

    public enum VisionTargetType {
        HIGH_PORT(0), LOADING_PORT(1);

        public int targetType;

        private VisionTargetType(int targetType) {
            this.targetType = targetType;
        }
    }

    public VisionTargetHub() {
        enableDataCollection();
        getTargetData();
        createTargets();
    }

    @Override
    public void periodic() {
        if (isEnabled) {
            getTargetData();
            createTargets();
        }
    }

    public void enableDataCollection() {
        isEnabled = true;
    }

    public void disableDataCollection() {
        isEnabled = false;
    }

    public void getTargetData() {
        VisionTargetHub.targetTypes = RobotMap.NetworkTables.Vision.VisionTargets.targetTypes
                .getDoubleArray(DEFAULT_INPUT_ARRAY);
        VisionTargetHub.distances = RobotMap.NetworkTables.Vision.VisionTargets.targetTypes
                .getDoubleArray(DEFAULT_INPUT_ARRAY);
        VisionTargetHub.betas = RobotMap.NetworkTables.Vision.VisionTargets.targetTypes
                .getDoubleArray(DEFAULT_INPUT_ARRAY);
        VisionTargetHub.thetas = RobotMap.NetworkTables.Vision.VisionTargets.targetTypes
                .getDoubleArray(DEFAULT_INPUT_ARRAY);
    }

    public VisionTarget[] createTargets() {
        VisionTargetHub.targets = new VisionTarget[targetTypes.length];
        for (int i = 0; i < VisionTargetHub.targets.length; i++) {
            VisionTargetHub.targets[i] = new VisionTarget(targetTypes[i], distances[i], betas[i], thetas[i]);
        }
        return VisionTargetHub.targets;
    }

    public VisionTarget[] filterTargetsByTargetType(VisionTarget[] targets, VisionTargetType intendedTargetType) {
        return (VisionTarget[]) Arrays.stream(targets).filter(target -> target.checkTargetType(intendedTargetType))
                .toArray();
    }

    public VisionTarget[] filterTargetsByTargetType(VisionTargetType intendedTargetType) {
        return filterTargetsByTargetType(VisionTargetHub.targets, intendedTargetType);
    }

    public VisionTarget findClosestTarget(VisionTarget[] targets) {
        return Arrays.stream(targets).min((target1, target2) -> Double.compare(target1.distance, target2.distance))
                .get();
    }

    public VisionTarget findClosestTarget() {
        return findClosestTarget(VisionTargetHub.targets);
    }

    public VisionTarget findIdealTarget(VisionTarget[] targets, VisionTargetType intendedTargetType) {
        VisionTarget[] usableTargets = filterTargetsByTargetType(intendedTargetType);
        return findClosestTarget(usableTargets);
    }

    public VisionTarget findIdealTarget(VisionTargetType intendedTargetType) {
        return findIdealTarget(VisionTargetHub.targets, intendedTargetType);
    }

}
