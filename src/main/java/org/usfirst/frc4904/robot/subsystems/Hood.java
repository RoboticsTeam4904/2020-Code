package org.usfirst.frc4904.robot.subsystems;

import org.usfirst.frc4904.standard.Util;
import org.usfirst.frc4904.standard.custom.motioncontrollers.MotionController;
import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.subsystems.motor.PositionSensorMotor;

import edu.wpi.first.wpilibj.PWMSpeedController;
import edu.wpi.first.wpilibj.Servo;

public class Hood extends PositionSensorMotor {
    private final double UPPER_LIMIT = 0; // TODO: find proper values
    private final double LOWER_LIMIT = 0; // TODO: find proper values
    protected PWMSpeedController servo;
    protected MotionController motionController;
    protected CustomDigitalLimitSwitch lowLimit;
    protected CustomDigitalLimitSwitch highLimit;
    private final Util.Range servoRange = new Util.Range(LOWER_LIMIT, UPPER_LIMIT);

    public Hood(MotionController motionController, PWMSpeedController servo, CustomDigitalLimitSwitch lowLimit, CustomDigitalLimitSwitch highLimit) {
        super(motionController, servo);
    }

    @Override
    public void setPosition(double position) {
        if (lowLimit.get() || highLimit.get()){
            set(0);
        }
        double safePosition = servoRange.limitValue(position);
        super.setPosition(safePosition);
    }

    @Override
    public void set(double speed) {
        super.set(speed);
    }

    public void getLimit(){

    }
    
    public PWMSpeedController getServo(){
        return this.servo;
    }
    // public void accept(double speed) {

    // }

    // public void enable() {
    //     pidController.enable();
    // }

    // public void disable() {
    //     pidController.disable();
    // }

    // public boolean getEnable() {
    //     return pidController.isEnabled();
    // }

    // public boolean onTarget() {
    //     return pidController.onTarget();
    // }

    // public double getSetpoint() {
    //     return pidController.getSetpoint();
    // }

    // public void setSetpoint(double setpoint) {
    //     pidController.setSetpoint(setpoint);
    // }
}