package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.Util;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.CANTalonEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;

public class Hood extends PositionSensorMotor {
    public static enum HoodStatus {
        IDLE, MOVING, IN_POSITION
    }

    public static enum LimitType {
        UPPER, LOWER, NONE
    }

    protected CANTalonEncoder hoodEncoder;
    protected CustomDigitalLimitSwitch limitSwitch;
    protected HoodStatus currentStatus = HoodStatus.IDLE;
    private final double ENCODER_TICKS = 2048.0;
    private final double TICK_MULTIPLIER = 360.0 / ENCODER_TICKS;
    private Util.Range motorAngleRange = new Util.Range(RobotMap.Metrics.Hood.LOWER_HOOD_ANGLE,
            RobotMap.Metrics.Hood.UPPER_HOOD_ANGLE);

    /**
     * We are currently making some pretty big assumptions. Those are: + speed is
     * towards the upper limit, - speed is towards the lower limit. The LimitType
     * "true" is upper limit, "false" is lower limit.
     */
    public Hood(CANTalonEncoder hoodEncoder, CustomDigitalLimitSwitch limitSwitch) {
        super(new CustomPIDController(RobotMap.PID.Hood.P, RobotMap.PID.Hood.I, RobotMap.PID.Hood.D, hoodEncoder));
        this.hoodEncoder = hoodEncoder;
        this.limitSwitch = limitSwitch;
        this.hoodEncoder.setDistancePerPulse(TICK_MULTIPLIER); // makes it so the getDistance() method for the encoder is in degrees
    }

    @Override
    public void periodic() {
        super.periodic();
        syncStatus();
    }

    public void syncStatus() {
        if (isLowerLimitDown()) {
            setLimit();
        }
    }

    /**
     * Sets the hood angle, not the servo position.
     */
    @Override
    public void setPosition(double angle) {
        double safePosition = motorAngleRange.limitValue(angle);
        super.setPosition(safePosition);
    }

    @Override
    public void set(double speed) {
        if (speed > 0 && (isLimitDown() || getHoodAngle() >= RobotMap.Metrics.Hood.UPPER_HOOD_ANGLE)) {
            speed = 0.0;
        }
        if (speed < 0 && (isLimitDown() || getHoodAngle() <= RobotMap.Metrics.Hood.LOWER_HOOD_ANGLE)) {
            speed = 0.0;
        }
        super.set(speed);
    }

    public double getHoodAngle() {
        return hoodEncoder.getDistance();
    }

    public boolean isLimitDown() {
        return limitSwitch.get();
    }

    public LimitType getPredictedLimitPress() {
        if (isLimitDown()) {
            if (getHoodAngle() > RobotMap.Metrics.Hood.RANGE_HOOD_ANGLES / 2) {
                return LimitType.UPPER;
            } else {
                return LimitType.LOWER;
            }
        } else {
            return LimitType.NONE;
        }
    }

    public boolean isLowerLimitDown() {
        return getPredictedLimitPress() == LimitType.LOWER;
    }

    public boolean isUpperLimitDown() {
        return getPredictedLimitPress() == LimitType.UPPER;
    }

    public void setLimit() {
        hoodEncoder.reset();
    }
}