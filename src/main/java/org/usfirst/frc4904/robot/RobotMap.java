package org.usfirst.frc4904.robot;

import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.SensorTimeBase;

import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.custom.sensors.EncoderPair;
import org.usfirst.frc4904.standard.custom.sensors.NavX;
import org.usfirst.frc4904.standard.custom.sensors.PDP;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;

public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int JOYSTICK = 0;
            public static final int XBOX_CONTROLLER = 1;
        }

        public static class CANMotor {
            public static final int LEFT_DRIVE_A = -1;
            public static final int LEFT_DRIVE_B = -1;
            public static final int RIGHT_DRIVE_A = -1;
            public static final int RIGHT_DRIVE_B = -1;
        }

        public static class PWM {
        }

        public static class CAN {
            public static final int LEFT_WHEEL_ENCODER = -1;
            public static final int RIGHT_WHEEL_ENCODER = -1;
        }

        public static class Pneumatics {
            public static final PCMPort SHIFTER = new PCMPort(-1, -1, -1);
        }

        public static class Digital {
        }
    }

    public static class Metrics {
        public static class Chassis {
            public static final double TICKS_PER_REVOLUTION = -1;
            public static final double DIAMETER_METERS = -1;
            public static final double CIRCUMFERENCE_METERS = Metrics.Chassis.DIAMETER_METERS * Math.PI;
            public static final double TICKS_PER_METER = Metrics.Chassis.TICKS_PER_REVOLUTION
                    / Metrics.Chassis.CIRCUMFERENCE_METERS;
            public static final double DISTANCE_FRONT_BACK = -1;
            public static final double DISTANCE_SIDE_SIDE = -1;
            public static final double METERS_PER_TICK = Metrics.Chassis.CIRCUMFERENCE_METERS
                    / Metrics.Chassis.TICKS_PER_REVOLUTION;
        }
    }

    public static class PID {
        public static class Drive {
            public static final double P = -1;
            public static final double I = -1;
            public static final double D = -1;
            public static final double F = -1;
            public static final double TOLERANCE = -1;
            public static final double D_TOLERANCE = -1;
        }

        public static class Turn {
            public static final double P = -1;
            public static final double I = -1;
            public static final double D = -1;
            public static final double F = -1;
            public static final double TOLERANCE = -1;
            public static final double D_TOLERANCE = -1;
        }
    }

    public static class Component {
        public static PDP pdp;
        public static Motor leftDriveA;
        public static Motor leftDriveB;
        public static Motor rightDriveA;
        public static Motor rightDriveB;
        public static TankDriveShifting chassis;
        public static SolenoidShifters shifter;
        public static EnableableModifier leftWheelAccelerationCap;
        public static EnableableModifier rightWheelAccelerationCap;
        public static CANCoder leftWheelEncoder;
        public static CANCoder rightWheelEncoder;
        public static EncoderPair chassisEncoders;
        public static CANCoderConfiguration canCoderConfiguration;
        public static NavX navx;
    }

    public static class Input {
    }

    public static class HumanInput {
        public static class Driver {
            public static CustomXbox xbox;
        }

        public static class Operator {
            public static CustomJoystick joystick;
        }
    }

    public RobotMap() {
        Component.pdp = new PDP();

        Component.leftWheelEncoder = new CANCoder(Port.CAN.LEFT_WHEEL_ENCODER);
        Component.rightWheelEncoder = new CANCoder(Port.CAN.RIGHT_WHEEL_ENCODER);
        Component.canCoderConfiguration = new CANCoderConfiguration();
        Component.leftWheelEncoder.configAllSettings(Component.canCoderConfiguration);
        Component.rightWheelEncoder.configAllSettings(Component.canCoderConfiguration);
        Component.leftWheelEncoder.configFeedbackCoefficient(RobotMap.Metrics.Chassis.METERS_PER_TICK, "meters",
                SensorTimeBase.PerSecond);
        Component.rightWheelEncoder.configFeedbackCoefficient(RobotMap.Metrics.Chassis.METERS_PER_TICK, "meters",
                SensorTimeBase.PerSecond);

        Component.leftWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
        Component.leftWheelAccelerationCap.enable();
        Component.rightWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
        Component.rightWheelAccelerationCap.enable();

        Component.leftDriveA = new Motor("leftDriveA", false, Component.leftWheelAccelerationCap,
                new CANTalonFX(Port.CANMotor.LEFT_DRIVE_A));
        Component.leftDriveB = new Motor("rightDriveA", false, Component.rightWheelAccelerationCap,
                new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_A));
        Component.rightDriveA = new Motor("leftDriveB", false, Component.leftWheelAccelerationCap,
                new CANTalonFX(Port.CANMotor.LEFT_DRIVE_B));
        Component.rightDriveB = new Motor("rightDriveB", false, Component.rightWheelAccelerationCap,
                new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_B));

        Component.shifter = new SolenoidShifters(Port.Pneumatics.SHIFTER.buildDoubleSolenoid());

        Component.chassis = new TankDriveShifting(0d, RobotMap.Component.leftDriveA, RobotMap.Component.leftDriveB,
                RobotMap.Component.rightDriveA, RobotMap.Component.rightDriveB, Component.shifter);

        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.XBOX_CONTROLLER);
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.JOYSTICK);
    }
}
