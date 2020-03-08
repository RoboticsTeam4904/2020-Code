package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.RobotMap;
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
    private static double lower_hood_angle = 0.0;
    private static double upper_hood_angle = 35.0;
    private static Util.Range hood_range = new Util.Range(lower_hood_angle, upper_hood_angle);

    /**
     * We are currently making some pretty big assumptions. Those are: + speed is
     * towards the upper limit, - speed is towards the lower limit. The LimitType
     * "true" is upper limit, "false" is lower limit.
     */
    public Hood(Motor hoodMotor, CANTalonEncoder hoodEncoder, CustomDigitalLimitSwitch limitSwitch) {
        super(new CustomPIDController(RobotMap.PID.Hood.P, RobotMap.PID.Hood.I, RobotMap.PID.Hood.D, hoodEncoder));
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
        double safePosition = Hood.hood_range.limitValue(angle);
        super.setPosition(safePosition); // TODO: Do we still want safe position conversion?
    }

    @Override
    public void set(double speed) {
        if (speed > 0 && (isLimitDown() || getHoodAngle() >= upper_hood_angle)) {
            speed = 0.0;
        }
        if (speed < 0 && (isLimitDown() || getHoodAngle() <= lower_hood_angle)) {
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
            if (getHoodAngle() > (hood_range.getRange()) / 2) {
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
            upper_hood_angle = getHoodAngle();
            hood_range = new Util.Range(lower_hood_angle, upper_hood_angle);
        }
    }

    public Motor getMotor() {
        return hoodMotor;
    }
}