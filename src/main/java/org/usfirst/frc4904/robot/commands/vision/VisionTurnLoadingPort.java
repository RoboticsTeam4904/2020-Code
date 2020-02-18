package org.usfirst.frc4904.robot.commands.vision;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.VisionTargetHub.VisionTargetType;

/**
 * Turn the robot in the direction of the nearest loading port (human player
 * station)
 */
public class VisionTurnLoadingPort extends VisionTurn {
    public VisionTurnLoadingPort() {
        super("VisionTurnLowPort", RobotMap.Component.chassis, RobotMap.Component.hub, VisionTargetType.LOADING_PORT,
                RobotMap.Component.navx, RobotMap.Component.turnPID);
    }
}