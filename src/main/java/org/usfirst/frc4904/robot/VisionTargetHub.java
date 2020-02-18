package org.usfirst.frc4904.robot;

import java.util.Arrays;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.Subsystem;

/**
 * Class for vision data collection and corresponding helper methods
 */
public class VisionTargetHub implements Subsystem {
    protected static final double[] DEFAULT_INPUT_ARRAY = new double[0];
    protected static NetworkTableEntry targetTypesEntry;
    protected static NetworkTableEntry distancesEntry;
    protected static NetworkTableEntry betasEntry;
    protected static NetworkTableEntry thetasEntry;
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

    public VisionTargetHub(NetworkTableEntry targetTypesEntry, NetworkTableEntry distancesEntry,
            NetworkTableEntry betasEntry, NetworkTableEntry thetasEntry) {
        VisionTargetHub.targetTypesEntry = targetTypesEntry;
        VisionTargetHub.distancesEntry = targetTypesEntry;
        VisionTargetHub.betasEntry = targetTypesEntry;
        VisionTargetHub.thetasEntry = targetTypesEntry;

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
        VisionTargetHub.targetTypes = targetTypesEntry.getDoubleArray(DEFAULT_INPUT_ARRAY);
        VisionTargetHub.distances = distancesEntry.getDoubleArray(DEFAULT_INPUT_ARRAY);
        VisionTargetHub.betas = betasEntry.getDoubleArray(DEFAULT_INPUT_ARRAY);
        VisionTargetHub.thetas = thetasEntry.getDoubleArray(DEFAULT_INPUT_ARRAY);
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
