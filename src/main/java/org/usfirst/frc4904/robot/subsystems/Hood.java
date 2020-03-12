package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.Util;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.CANTalonEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;

public class Hood extends PositionSensorMotor {
    public static enum HoodStatus {
        IDLE, MOVING, IN_POSITION
    }

    public static enum LimitType {
        UPPER, LOWER, NONE
    }

    protected Motor hoodMotor;
    protected CANTalonEncoder hoodEncoder;
    protected CustomDigitalLimitSwitch limitSwitch;
    protected HoodStatus currentStatus = HoodStatus.IDLE;
    private static double lowerHoodAngle = 0.0;
    private static double upperHoodAngle = 35.0;
    public static double tolerance = 0.5;
    private static Util.Range hoodRange = new Util.Range(lowerHoodAngle, upperHoodAngle);

    /**
     * We are currently making some pretty big assumptions. Those are: + speed is
     * towards the upper limit, - speed is towards the lower limit. The LimitType
     * "true" is upper limit, "false" is lower limit.
     */
    public Hood(Motor hoodMotor, CANTalonEncoder hoodEncoder, CustomPIDController pidController, CustomDigitalLimitSwitch limitSwitch) {
        super(pidController);
        this.hoodMotor = hoodMotor;
        this.hoodEncoder = hoodEncoder;
        this.limitSwitch = limitSwitch;
    }

    @Override
    public void periodic() {
        super.periodic();
        syncStatus();
    }

    public void syncStatus() {
        setLimit(getPredictedLimitPress()); // If the limitType is None, it should fail silently.
    }

    /**
     * Sets the hood angle, not the servo position.
     */
    @Override
    public void setPosition(double angle) {
        double safePosition = hoodRange.limitValue(angle);
        super.setPosition(safePosition); // TODO: Do we still want safe position conversion?
    }

    @Override
    public void set(double speed) {
        if (speed > 0 && getHoodAngle() >= upperHoodAngle) {
            speed = 0.0;
        }
        if (speed < 0 && (isLimitDown() || getHoodAngle() <= lowerHoodAngle)) {
            speed = 0.0;
        }
        getMotor().set(speed);
    }

    public double getHoodAngle() {
        return hoodEncoder.getDistance();
    }

    public boolean isLimitDown() {
        return limitSwitch.get();
    }

    public LimitType getPredictedLimitPress() {
        if (isLimitDown()) {
            if (getHoodAngle() > (hoodRange.getRange()) / 2) {
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

    public void 
    setLimit(LimitType limitType) {
        if (limitType == LimitType.LOWER) {
            hoodEncoder.reset();
        } else if (limitType == LimitType.UPPER) {
            // hoodEncoder.getTalon().setSelectedSensorPosition(upp)
            upperHoodAngle = getHoodAngle();
            hoodRange = new Util.Range(lowerHoodAngle, upperHoodAngle);
        }
    }

    public Motor getMotor() {
        return hoodMotor;
    }
}