package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.ChassisIdle;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

public class VisionAngleAlign extends ChassisTurn {
    protected static final double DEFAULT_ANGLE = 0.0;
    public VisionAngleAlign() {
        super("VisionAngleAlign", RobotMap.Component.chassis, RobotMap.NetworkTables.Vision.beta.getDouble(DEFAULT_ANGLE), RobotMap.Component.navx, new ChassisIdle("FailedVisionAngleAlign", RobotMap.Component.chassis), RobotMap.Component.turnPID);
    }
}