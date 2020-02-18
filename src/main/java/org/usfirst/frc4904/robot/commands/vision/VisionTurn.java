package org.usfirst.frc4904.robot.commands.vision;

import org.usfirst.frc4904.robot.VisionTargetHub;
import org.usfirst.frc4904.robot.VisionTargetHub.VisionTargetType;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.IMU;
import org.usfirst.frc4904.standard.subsystems.chassis.Chassis;

/**
 * Rotate the robot in the direction of the closest vision target of a certain
 * type
 */
public class VisionTurn extends ChassisTurn {

    public VisionTurn(String name, Chassis chassis, VisionTargetHub hub, VisionTargetType intendedTargetType, IMU imu,
            MotionController motionController) {
        super(name, chassis, hub.findIdealTarget(intendedTargetType).theta, imu, motionController);
    }
}