package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class FlywheelSpinUp extends SequentialCommandGroup {

    public static final double DEFAULT_FLYWHEEL_SPEED = 0.0; // TODO: This is an untested value
    public static final double THRESHOLD = 0.0;

    /**
     * Spin up the flywheel to a speed
     * 
     * @param flywheel The flywheel to manipulate
     * @param speed    The speed to spin the flywheel up to
     */
    public FlywheelSpinUp(double speed) {
        // smartdashboard.getNumber(“setpoint”, 0)
        super(new RunUntil("FlywheelSpinUp", new MotorConstant(RobotMap.Component.flywheel, speed), () -> {
            return Math.abs(RobotMap.Component.shooter.flywheel.getTargetSpeed() - speed) < THRESHOLD
                    || RobotMap.Component.shooter.flywheel.getTargetSpeed() > speed;
        }), new FlywheelMaintainSpeed(speed));
        addRequirements(RobotMap.Component.flywheelMotorA, RobotMap.Component.flywheelMotorB);
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