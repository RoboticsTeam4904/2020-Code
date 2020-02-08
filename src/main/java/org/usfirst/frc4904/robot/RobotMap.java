package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import org.usfirst.frc4904.standard.subsystems.chassis.SensorDrive;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDrive;
import org.usfirst.frc4904.standard.custom.sensors.EncoderPair;
import org.usfirst.frc4904.standard.custom.sensors.NavX;
import org.usfirst.frc4904.standard.custom.sensors.PDP;
import org.usfirst.frc4904.standard.custom.sensors.PIDSensor;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.SensorTimeBase;

import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines.SplineAutoConstants;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines.SplineDriveConstants;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int JOYSTICK = 0;
            public static final int XBOX_CONTROLLER = 1;
        }

        public static class CANMotor {
            public static final int LEFT_DRIVE_A = 0;
            public static final int LEFT_DRIVE_B = 3;
            public static final int RIGHT_DRIVE_A = 1;
            public static final int RIGHT_DRIVE_B = 2;
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
            public static final double TICKS_PER_REVOLUTION = -1; // TODO: CHANGE CONSTS
            public static final double DIAMETER_METERS = -1;
            public static final double CIRCUMFERENCE_METERS = Metrics.Chassis.DIAMETER_METERS * Math.PI;
            public static final double METERS = Metrics.Chassis.TICKS_PER_REVOLUTION
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

    public static class DriveConstants {
        // Field Carpet
        // public static final double ksVolts = 0.0018;
        // public static final double kvVoltSecondsPerMeter = 4.9;
        // public static final double kaVoltSecondsSquaredPerMeter = 0.184;
        // public static final double kTrackwidthMeters = .61; //0.5842
        // public static final double kPDriveVel = 6.27;
        // School Carpet
        public static final double ksVolts = 0.000665;
        public static final double kvVoltSecondsPerMeter = 4.9;
        public static final double kaVoltSecondsSquaredPerMeter = 0.0718;
        public static final double kTrackwidthMeters = 0.60; // 0.5842 // 0.6063751884752512
        public static final double kPDriveVel = 1.62;
        public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(kTrackwidthMeters);
        public static final SplineDriveConstants driveConstants = new SplineDriveConstants(ksVolts, kvVoltSecondsPerMeter, kaVoltSecondsSquaredPerMeter, kTrackwidthMeters, kPDriveVel);
    }

    public static class AutoConstants {
        public static final double kMaxSpeedMetersPerSecond = 2.3;
        public static final double kMaxAccelerationMetersPerSecondSquared = 2;
        public static final double kRamseteB = 2;
        public static final double kRamseteZeta = 0.7;
        public static final SplineAutoConstants autoConstants = new SplineAutoConstants(kMaxSpeedMetersPerSecond, kMaxAccelerationMetersPerSecondSquared, kRamseteB, kRamseteZeta);
    }

    public static class Component {
        public static PDP pdp;
        public static Motor leftDriveA;
        public static Motor leftDriveB;
        public static Motor rightDriveA;
        public static Motor rightDriveB;
        // public static TankDriveShifting chassis;
        public static TankDrive chassis;
        public static SolenoidShifters shifter;
        public static EnableableModifier leftWheelAccelerationCap;
        public static EnableableModifier rightWheelAccelerationCap;
        public static CANCoder leftWheelEncoder;
        public static CANCoder rightWheelEncoder;
        public static EncoderPair chassisEncoders;
        public static CANCoderConfiguration canCoderConfiguration;
        public static NavX navx;
        public static CustomPIDController turnPID;
        public static SensorDrive splinesChassis;
    }

    public static class Input {
    }

    public static class NetworkTables {
        public static NetworkTableInstance inst;
        public static NetworkTable table;

        public static class Vision {
            public static NetworkTable table;
            public static NetworkTableEntry distanceToTarget;
            public static NetworkTableEntry beta;
            public static NetworkTableEntry theta;

        }
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
        Component.navx = new NavX(SerialPort.Port.kMXP);
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

        Component.turnPID = new CustomPIDController(PID.Turn.P, PID.Turn.I, PID.Turn.D, PID.Turn.F, (PIDSensor) Component.navx);
        Component.shifter = new SolenoidShifters(Port.Pneumatics.SHIFTER.buildDoubleSolenoid());

        Component.chassis = new TankDriveShifting(0.0, RobotMap.Component.leftDriveA, RobotMap.Component.leftDriveB,
                RobotMap.Component.rightDriveA, RobotMap.Component.rightDriveB, Component.shifter);

        Component.splinesChassis = new SensorDrive(Component.chassis, AutoConstants.autoConstants, DriveConstants.driveConstants, Component.leftWheelEncoder, Component.rightWheelEncoder, Component.navx);

        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.XBOX_CONTROLLER);
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.JOYSTICK);
        NetworkTables.inst = NetworkTableInstance.getDefault();
        NetworkTables.table = NetworkTables.inst.getTable("vision");
        NetworkTables.Vision.distanceToTarget = NetworkTables.Vision.table.getEntry("distanceToTarget");
        NetworkTables.Vision.beta = NetworkTables.Vision.table.getEntry("beta");
        NetworkTables.Vision.theta = NetworkTables.Vision.table.getEntry("theta");


    }
}
