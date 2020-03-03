package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class FlywheelSpinUp extends SequentialCommandGroup {

    public static final double DEFAULT_FLYWHEEL_SPEED = 50.0; // TODO: This is an untested value
    public static final double THRESHOLD = 1.0;

    /**
     * Spin up the flywheel to a speed
     * 
     * @param flywheel    The flywheel to manipulate
     * @param targetSpeed The speed to spin the flywheel up to
     */
    public FlywheelSpinUp(Flywheel flywheel, double targetSpeed) {
        super(new RunUntil("FlywheelSpinUp", new MotorConstant(flywheel, ((CustomPIDController) flywheel.getMC()).getF() * targetSpeed), () -> {
            return Math.abs(flywheel.getVelocity() - targetSpeed) < THRESHOLD || flywheel.getVelocity() > targetSpeed;
        }, false), new FlywheelMaintainSpeed(flywheel, targetSpeed));
        // addRequirements(flywheel);
    }

    public FlywheelSpinUp(double speed) {
        this(RobotMap.Component.flywheel, speed);
    }

    /**
     * Spin up the flywheel to the default speed
     * 
     * @param flywheel The flywheel to manipulate
     */
    public FlywheelSpinUp() {
        this(DEFAULT_FLYWHEEL_SPEED);
    }
}