package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import org.usfirst.frc4904.standard.subsystems.chassis.SensorDrive;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.custom.sensors.EncoderPair;
import org.usfirst.frc4904.standard.custom.sensors.NavX;
import org.usfirst.frc4904.standard.custom.sensors.PDP;
import org.usfirst.frc4904.standard.custom.sensors.PIDSensor;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.util.Units;

import com.ctre.phoenix.sensors.CANCoder;
import com.ctre.phoenix.sensors.CANCoderConfiguration;
import com.ctre.phoenix.sensors.SensorTimeBase;

import org.usfirst.frc4904.robot.VisionTargetHub;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines.SplineAutoConstants;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines.SplineDriveConstants;

public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int joystick = 0;
            public static final int xboxController = 1;
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
            public static final double TICKS_PER_REVOLUTION = 4096.0;
            public static final double DIAMETER_METERS = Units.inchesToMeters(5);
            public static final double CIRCUMFERENCE_METERS = Metrics.Chassis.DIAMETER_METERS * Math.PI;
            public static final double TICKS_PER_METER = Metrics.Chassis.TICKS_PER_REVOLUTION
                    / Metrics.Chassis.CIRCUMFERENCE_METERS;
            public static final double DISTANCE_FRONT_BACK = -1;// TODO: CHANGE CONSTS
            public static final double TRACK_WIDTH = -1;
            public static final double METERS_PER_TICK = 1 / TICKS_PER_METER;
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

    public static class DriveConstants {// TODO: Change Constants
        // School Carpet
        public static final double VOLTS = -1;
        public static final double VOLT_SECONDS_PER_METER = -1;
        public static final double VOLT_SECONDS_SQUARED_PER_METER = -1;
        public static final double TRACK_WIDTH_METERS = -1; // 0.5842 // 0.6063751884752512
        public static final double DRIVE_VEL = -1;
        public static final SplineDriveConstants DRIVE_CONSTANTS = new SplineDriveConstants(VOLTS,
                VOLT_SECONDS_PER_METER, VOLT_SECONDS_SQUARED_PER_METER, TRACK_WIDTH_METERS, DRIVE_VEL);
    }

    public static class AutoConstants {// TODO: Change Constants
        public static final double MAX_SPEED_METERS_PER_SECOND = -1;
        public static final double MAX_ACCELERATION_METERS_PER_SECOND_SQUARED = -1;
        public static final double RAMSETE_B = 2;
        public static final double RAMSETE_ZETA = 0.7;
        public static final SplineAutoConstants AUTO_CONSTANTS = new SplineAutoConstants(MAX_SPEED_METERS_PER_SECOND,
                MAX_ACCELERATION_METERS_PER_SECOND_SQUARED, RAMSETE_B, RAMSETE_ZETA);
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
        public static CustomPIDController turnPID;
        public static SensorDrive splinesChassis;
        public static VisionTargetHub hub;
    }

    public static class Input {
    }

    public static class NetworkTables {
        public static NetworkTableInstance inst;
        public static NetworkTable table;

        public static class Vision {
            public static NetworkTable table;

            public static class VisionTargets {
                public static NetworkTable table;
                public static NetworkTableEntry targetTypes;
                public static NetworkTableEntry distances;
                public static NetworkTableEntry betas;
                public static NetworkTableEntry thetas;

            }
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

        Component.leftDriveA = new Motor("leftDriveA", false, new CANTalonFX(Port.CANMotor.LEFT_DRIVE_A));
        Component.leftDriveB = new Motor("leftDriveB", false, new CANTalonFX(Port.CANMotor.LEFT_DRIVE_B));
        Component.rightDriveA = new Motor("rightDriveA", false, new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_A));
        Component.rightDriveB = new Motor("rightDriveB", false, new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_B));

        Component.turnPID = new CustomPIDController(PID.Turn.P, PID.Turn.I, PID.Turn.D, PID.Turn.F,
                (PIDSensor) Component.navx);
        Component.shifter = new SolenoidShifters(Port.Pneumatics.SHIFTER.buildDoubleSolenoid());

        Component.chassis = new TankDriveShifting(0.0, RobotMap.Component.leftDriveA, RobotMap.Component.leftDriveB,
                RobotMap.Component.rightDriveA, RobotMap.Component.rightDriveB, Component.shifter);

        Component.splinesChassis = new SensorDrive(Component.chassis, AutoConstants.AUTO_CONSTANTS,
                DriveConstants.DRIVE_CONSTANTS, Component.leftWheelEncoder, Component.rightWheelEncoder,
                Component.navx);

        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);

        /** Vision */
        // Network Tables
        NetworkTables.inst = NetworkTableInstance.getDefault();
        NetworkTables.table = NetworkTables.inst.getTable("team4904");
        NetworkTables.Vision.table = NetworkTables.table.getSubTable("vision");
        NetworkTables.Vision.VisionTargets.table = NetworkTables.Vision.table.getSubTable("visionTargets");
        NetworkTables.Vision.VisionTargets.targetTypes = NetworkTables.Vision.VisionTargets.table
                .getEntry("targetTypes");
        NetworkTables.Vision.VisionTargets.distances = NetworkTables.Vision.VisionTargets.table.getEntry("distances");
        NetworkTables.Vision.VisionTargets.betas = NetworkTables.Vision.VisionTargets.table.getEntry("betas");
        NetworkTables.Vision.VisionTargets.thetas = NetworkTables.Vision.VisionTargets.table.getEntry("thetas");

        Component.hub = new VisionTargetHub(NetworkTables.Vision.VisionTargets.targetTypes,
                NetworkTables.Vision.VisionTargets.distances, NetworkTables.Vision.VisionTargets.betas,
                NetworkTables.Vision.VisionTargets.thetas);

    }
}
