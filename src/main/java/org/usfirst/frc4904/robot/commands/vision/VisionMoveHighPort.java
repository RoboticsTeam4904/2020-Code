package org.usfirst.frc4904.robot.commands.vision;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.VisionTargetHub.VisionTargetType;

/**
 * Move towards the closest high port (where you shoot)
 */
public class VisionMoveHighPort extends VisionMove {
    public VisionMoveHighPort() {
        super(RobotMap.Component.hub, VisionTargetType.HIGH_PORT, RobotMap.Component.splinesChassis,
                RobotMap.Metrics.Chassis.DISTANCE_FRONT_BACK);
    }
}