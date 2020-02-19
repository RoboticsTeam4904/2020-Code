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

    public static enum LimitType {
        UPPER, LOWER, NONE
    }

    protected Motor servo;
    protected CANEncoder hoodEncoder;
    protected CustomDigitalLimitSwitch limitSwitch;
    protected HoodStatus currentStatus = HoodStatus.IDLE;
    private final double lowerServoPosition = 0.0; //TODO: Refine this value.
    private final double upperServoPosition = lowerServoPosition + RobotMap.Metrics.Hood.SERVO_ROTATION_PER_HOOD;
    private Util.Range servoRange = new Util.Range(lowerServoPosition, upperServoPosition);

    /**
     * We are currently making some pretty big assumptions. Those are:
     * + servo speed moves it towards the upper limit, - servo speed moves it towards the lower limit
     * "true" for limitType is upper, "false" is lower.
     */
    public Hood(Motor servo, CANEncoder hoodEncoder, CustomDigitalLimitSwitch limitSwitch) {
        super(new CustomPIDController(RobotMap.PID.Hood.P, RobotMap.PID.Hood.I, RobotMap.PID.Hood.D, hoodEncoder), servo);
        this.servo = servo;
        this.hoodEncoder = hoodEncoder;
        this.limitSwitch = limitSwitch;
    }

    @Override
    public void periodic() {
        super.periodic();
        syncStatus();
    }

    public void syncStatus(){
        if(isLowerLimitDown()){
            setLimit(LimitType.LOWER);
        }
        if(isUpperLimitDown()){
            setLimit(LimitType.UPPER);
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
        if(speed > 0 && (isLimitDown() || getHoodAngle() >= RobotMap.Metrics.Hood.UPPER_HOOD_ANGLE)){
            speed = 0.0;
        }
        if(speed < 0 && (isLimitDown() || getHoodAngle() <= RobotMap.Metrics.Hood.LOWER_HOOD_ANGLE)){
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

    public boolean isLimitDown() {
        return limitSwitch.get();
    }

    public LimitType getPredictedLimitPress(){
        if(isLimitDown()){
            if(getHoodAngle() > RobotMap.Metrics.Hood.RANGE_HOOD_ANGLES/2){
                return LimitType.UPPER;
            } else {
                return LimitType.LOWER;
            }
        }else{
            return LimitType.NONE;
        }
    }

    public boolean isLowerLimitDown(){
        return getPredictedLimitPress() == LimitType.LOWER;
    }

    public boolean isUpperLimitDown(){
        return getPredictedLimitPress() == LimitType.UPPER;
    }

    public Motor getServo() {
        return this.servo;
    }

    public void setLimit(LimitType type) {
        if (type == LimitType.UPPER) {
            hoodEncoder.resetViaOffset(upperServoPosition);
        } else {
            hoodEncoder.resetViaOffset(lowerServoPosition);
        }
    }
}