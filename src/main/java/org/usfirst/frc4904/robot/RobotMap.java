package org.usfirst.frc4904.robot;

import com.ctre.phoenix.motorcontrol.NeutralMode;

import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;

import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDrive;
import org.usfirst.frc4904.standard.custom.sensors.CustomCANCoder;
import org.usfirst.frc4904.standard.custom.sensors.NavX;
import org.usfirst.frc4904.standard.custom.sensors.PDP;

public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int JOYSTICK = 0;
            public static final int XBOX_CONTROLLER = 1;
        }

        public static class CANMotor {
            public static final int LEFT_DRIVE_A = 7;
            public static final int LEFT_DRIVE_B = 3;
            public static final int RIGHT_DRIVE_A = 4;
            public static final int RIGHT_DRIVE_B = 11;
        }

        public static class PWM {
        }

        public static class CAN {
        }

        public static class Pneumatics {
        }

        public static class Digital {
        }
    }

    public static class Metrics {
        public static class Chassis {
            public static final double TICKS_PER_REVOLUTION = -1; // TODO: CHANGE CONSTS
            public static final double DIAMETER_INCHES = -1;
            public static final double CIRCUMFERENCE_INCHES = Metrics.Chassis.DIAMETER_INCHES * Math.PI;
            public static final double TICKS_PER_INCH = Metrics.Chassis.TICKS_PER_REVOLUTION
                    / Metrics.Chassis.CIRCUMFERENCE_INCHES;
            public static final double DISTANCE_FRONT_BACK = -1;
            public static final double DISTANCE_SIDE_SIDE = -1;
            public static final double INCHES_PER_TICK = Metrics.Chassis.CIRCUMFERENCE_INCHES
                    / Metrics.Chassis.TICKS_PER_REVOLUTION;
            public static final double TURN_CORRECTION = 0.0;
        }
    }

    public static class PID {
        public static class Drive {
        }

        public static class Turn {
        }

    }

    public static class Component {
        public static PDP pdp;
        public static Motor leftDriveA;
        public static Motor leftDriveB;
        public static Motor rightDriveA;
        public static Motor rightDriveB;
        public static TankDrive chassis;
        public static SolenoidShifters shifter;
        public static EnableableModifier leftWheelAccelerationCap;
        public static EnableableModifier rightWheelAccelerationCap;
        public static CustomCANCoder leftWheelEncoder;
        public static CustomCANCoder rightWheelEncoder;
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

        Component.leftWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
        Component.leftWheelAccelerationCap.enable();
        Component.rightWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
        Component.rightWheelAccelerationCap.enable();

        Component.leftDriveA = new Motor("leftDriveA", false, new CANTalonFX(Port.CANMotor.LEFT_DRIVE_A, NeutralMode.Coast));
        Component.leftDriveB = new Motor("leftDriveB", false, new CANTalonFX(Port.CANMotor.LEFT_DRIVE_B, NeutralMode.Coast));
        Component.rightDriveA = new Motor("rightDriveA", true, new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_A, NeutralMode.Coast));
        Component.rightDriveB = new Motor("rightDriveB", true, new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_B, NeutralMode.Coast));

        Component.chassis = new TankDrive(Metrics.Chassis.TURN_CORRECTION, Component.leftDriveA, Component.leftDriveB,
                Component.rightDriveA, Component.rightDriveB);

        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.XBOX_CONTROLLER);
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.JOYSTICK);
    }
}
