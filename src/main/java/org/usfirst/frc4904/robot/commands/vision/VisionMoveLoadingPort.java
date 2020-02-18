package org.usfirst.frc4904.robot.commands.vision;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.VisionTargetHub.VisionTargetType;

/**
 * Move towards the closest loading port (human player station)
 */
public class VisionMoveLoadingPort extends VisionMove {
    public VisionMoveLoadingPort() {
        super(RobotMap.Component.hub, VisionTargetType.LOADING_PORT, RobotMap.Component.splinesChassis,
                RobotMap.Metrics.Chassis.DISTANCE_FRONT_BACK);
    }
}