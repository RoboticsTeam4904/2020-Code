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
    public final double DEFAULT_SPEED = 0;
    private final double LOWER_HOOD_ANGLE = 0; //TODO: Add this value
    private final double RANGE_HOOD_ANGLES = 35.0;
    private final double UPPER_HOOD_ANGLE = LOWER_HOOD_ANGLE + RANGE_HOOD_ANGLES; //TODO: Does having all of these theoretical constants negate the zeroing we're doing?
    private final double TEETH_PER_SERVO_ROTATION = 20.0;
    private final double TEETH_PER_HOOD = 364.0;
    private final double SERVO_ROTATION_PER_HOOD = TEETH_PER_SERVO_ROTATION / TEETH_PER_HOOD;
    private final double HOOD_ANGLE_PER_SERVO_POSITION = RANGE_HOOD_ANGLES / SERVO_ROTATION_PER_HOOD; //TODO: Nomenclature can get confusing.
    protected Motor servo;
    protected CANEncoder hoodEncoder;
    protected CustomDigitalLimitSwitch lowLimit;
    protected CustomDigitalLimitSwitch highLimit;
    private final double lowerServoPosition = 0.0; //TODO: Refine this value.
    private final double upperServoPosition = lowerServoPosition + SERVO_ROTATION_PER_HOOD;
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
            setLimit(false);
        }
        if(isUpperLimitDown()){
            setLimit(true);
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
        if(speed > 0 && (isUpperLimitDown() || getHoodAngle() >= UPPER_HOOD_ANGLE)){
            speed = 0.0;
        }
        if(speed < 0 && (isLowerLimitDown() || getHoodAngle() <= LOWER_HOOD_ANGLE)){
            speed = 0.0;
        }
        super.set(speed);
    }

    public double hoodAngleToServoPosition(double hoodAngle){
        return hoodAngle / HOOD_ANGLE_PER_SERVO_POSITION;
    }

    public double servoPositionToHoodAngle(double servoPosition){
        return servoPosition * HOOD_ANGLE_PER_SERVO_POSITION;
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

    public void setLimit(boolean limitType) {
        if (limitType) {
            hoodEncoder.resetViaOffset(upperServoPosition);
        } else {
            hoodEncoder.resetViaOffset(lowerServoPosition);
        }
    }
}