package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.Util;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;

public class Hood extends PositionSensorMotor {
    public static enum HoodStatus {
        IDLE, MOVING, IN_POSITION
    }

    public static enum limitType {
        UPPER, LOWER
    }

    protected Motor servo;
    protected CANEncoder hoodEncoder;
    protected CustomDigitalLimitSwitch lowLimit;
    protected CustomDigitalLimitSwitch highLimit;
    protected HoodStatus currentStatus = HoodStatus.IDLE;
    private final double lowerServoPosition = 0.0; //TODO: Refine this value.
    private final double upperServoPosition = lowerServoPosition + RobotMap.Metrics.Hood.SERVO_ROTATION_PER_HOOD;
    private Util.Range servoRange = new Util.Range(lowerServoPosition, upperServoPosition);

    /**
     * We are currently making some pretty big assumptions. Those are:
     * + servo speed moves it towards the upper limit, - servo speed moves it towards the lower limit
     * "true" for limitType is upper, "false" is lower.
     */
    public Hood(Motor servo, CANEncoder hoodEncoder, CustomDigitalLimitSwitch lowLimit,
            CustomDigitalLimitSwitch highLimit) {
        super(new CustomPIDController(RobotMap.PID.Hood.P, RobotMap.PID.Hood.I, RobotMap.PID.Hood.D, hoodEncoder), servo);
        this.servo = servo;
        this.hoodEncoder = hoodEncoder;
        this.lowLimit = lowLimit;
        this.highLimit = highLimit;
    }

    @Override
    public void periodic() {
        super.periodic();
        syncStatus();
    }

    public void syncStatus(){
        if(isLowerLimitDown()){
            setLimit(limitType.LOWER);
        }
        if(isUpperLimitDown()){
            setLimit(limitType.UPPER);
        }
    }

    /**
     * Sets the hood angle, not the servo position.
     */
    @Override
    public void setPosition(double angle) {
        double safePosition = servoRange.limitValue(hoodAngleToServoPosition(angle)); //TODO: Should we error if we are outside of this value?
        super.setPosition(safePosition);
    }

    @Override
    public void set(double speed) {
        if(speed > 0 && (isUpperLimitDown() || getHoodAngle() >= RobotMap.Metrics.Hood.UPPER_HOOD_ANGLE)){
            speed = 0.0;
        }
        if(speed < 0 && (isLowerLimitDown() || getHoodAngle() <= RobotMap.Metrics.Hood.LOWER_HOOD_ANGLE)){
            speed = 0.0;
        }
        super.set(speed);
    }

    public double hoodAngleToServoPosition(double hoodAngle){
        return hoodAngle / RobotMap.Metrics.Hood.HOOD_ANGLE_PER_SERVO_POSITION;
    }

    public double servoPositionToHoodAngle(double servoPosition){
        return servoPosition * RobotMap.Metrics.Hood.HOOD_ANGLE_PER_SERVO_POSITION;
    }

    public double getServoPosition(){
        return hoodEncoder.getDistance();
    }

    public double getHoodAngle(){
        return servoPositionToHoodAngle(getServoPosition());
    }

    public boolean isLowerLimitDown() {
        return lowLimit.get();
    }

    public boolean isUpperLimitDown() {
        return highLimit.get();
    }

    public Motor getServo() {
        return this.servo;
    }

    public void setLimit(limitType type) {
        if (type == limitType.UPPER) {
            hoodEncoder.resetViaOffset(upperServoPosition);
        } else {
            hoodEncoder.resetViaOffset(lowerServoPosition);
        }
    }
}