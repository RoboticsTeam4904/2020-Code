package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.Util;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;

import edu.wpi.first.wpilibj.PWMSpeedController;

public class Hood extends PositionSensorMotor {
    public final double DEFAULT_SPEED = 0;
    private final double UPPER_LIMIT = 0;
    private final double LOWER_LIMIT = 0;
    private double upperLimit;
    private double lowerLimit;
    protected PWMSpeedController servo;
    protected MotionController motionController;
    protected CustomDigitalLimitSwitch lowLimit;
    protected CustomDigitalLimitSwitch highLimit;
    private Util.Range servoRange = new Util.Range(LOWER_LIMIT, UPPER_LIMIT);;

    public Hood(MotionController motionController, PWMSpeedController servo, CustomDigitalLimitSwitch lowLimit,
            CustomDigitalLimitSwitch highLimit) {
        super(motionController, servo);
    }

    @Override
    public void setPosition(double position) {
        if (isLimitButtonDown()) {
            set(0);
        }
        double safePosition = servoRange.limitValue(position);
        super.setPosition(safePosition);
    }

    @Override
    public void set(double speed) {
        super.set(speed);
    }

    public Util.Range getRange() {
        return this.servoRange;
    }

    public void setRange() {
        servoRange = new Util.Range(lowerLimit, upperLimit);
    }

    public boolean isLimitButtonDown() {
        return lowLimit.get() || highLimit.get();
    }

    public PWMSpeedController getServo() {
        return this.servo;
    }

    public void setLimit(boolean limitType) {
        if (limitType) {
            upperLimit = motionController.getSensorValue();
        } else {
            lowerLimit = motionController.getSensorValue();
        }
    }
}