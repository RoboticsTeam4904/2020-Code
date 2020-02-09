package org.usfirst.frc4904.robot.commands.vision;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisIdle;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

/**
 * Rotate the robot in the direction of the vision target
 */
public class VisionAlignChassisTurn extends ChassisTurn {
    protected static final double DEFAULT_ANGLE = 0.0;
    public VisionAlignChassisTurn() {
        super("VisionAngleAlign", RobotMap.Component.chassis, RobotMap.NetworkTables.Vision.beta.getDouble(DEFAULT_ANGLE), RobotMap.Component.navx, new ChassisIdle("FailedVisionAngleAlign", RobotMap.Component.chassis), RobotMap.Component.turnPID);
    }
}