package org.usfirst.frc4904.robot.commands.vision;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.VisionTargetType;

/**
 * Turn the robot in the direction of the nearest high port (where we shoot)
 */
public class VisionTurnHighPort extends VisionTurn {
    public VisionTurnHighPort() {
        super("VisionTurnHighPort", RobotMap.Component.chassis, RobotMap.Component.hub, VisionTargetType.HIGH_PORT.targetType,
                RobotMap.Component.navx, RobotMap.Component.turnPID);
    }
}