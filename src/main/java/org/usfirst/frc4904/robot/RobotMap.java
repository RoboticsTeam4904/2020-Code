package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.util.Units;

import org.usfirst.frc4904.standard.subsystems.chassis.SensorDrive;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.custom.sensors.CustomCANCoder;
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
            public static final int LEFT_DRIVE_A = 7;
            public static final int LEFT_DRIVE_B = 3;
            public static final int RIGHT_DRIVE_A = 15;
            public static final int RIGHT_DRIVE_B = 11;
        }

        public static class PWM {
        }

        public static class CAN {
            public static final int LEFT_WHEEL_ENCODER = -1;
            public static final int RIGHT_WHEEL_ENCODER = -1;
        }

        public static class Pneumatics {
            public static final PCMPort SHIFTER = new PCMPort(0, 1, 3);
        }

        public static class Digital {
        }
    }

    public static class Metrics {
        public static class Chassis {
            public static final double DIAMETER_METERS = Units.inchesToMeters(5.0);
            public static final double CIRCUMFERENCE_METERS = Metrics.Chassis.DIAMETER_METERS * Math.PI;
            public static final double TICKS_PER_METER = Metrics.Encoders.CANCoders.TICKS_PER_REVOLUTION
                    / Metrics.Chassis.CIRCUMFERENCE_METERS;
            public static final double DISTANCE_FRONT_BACK = Units.inchesToMeters(29.5); // TODO: DOUBLE CHECK DISTANCES
            public static final double DISTANCE_SIDE_SIDE = Units.inchesToMeters(29.5); // The robot's a square
            public static final double METERS_PER_TICK = Metrics.Chassis.CIRCUMFERENCE_METERS
                    / Metrics.Encoders.CANCoders.TICKS_PER_REVOLUTION;
            public static final double TURN_CORRECTION = 0.0;
        }

        public static class Encoders {
            public static class TalonEncoders {
                public static final double TICKS_PER_REVOLUTION = 2048.0;
                public static final double REVOLUTIONS_PER_TICK = 1 / TICKS_PER_REVOLUTION;
            }

            public static class CANCoders {
                public static final double TICKS_PER_REVOLUTION = 4096.0;
                public static final double REVOLUTIONS_PER_TICK = 1 / TICKS_PER_REVOLUTION;
            }
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
            public static final double P = 0;
            public static final double I = 0;
            public static final double D = 0;
            public static final double F = 0.01;
            public static final double TOLERANCE = -1;
            public static final double D_TOLERANCE = -1;
        }
    }

    public static class NetworkTables {
        public static NetworkTableInstance inst;

        // These should be in units of meters and radians
        public static class Odometry {
            public static NetworkTable odometry;
            public static NetworkTableEntry odometryXEntry;
            public static NetworkTableEntry odometryYEntry;
            public static NetworkTableEntry odometryAngleEntry;
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
        public static CustomPIDController chassisTurnPID;
        public static SensorDrive sensorDrive;

        public static CustomCANCoder leftWheelEncoder;
        public static CustomCANCoder rightWheelEncoder;
        public static EncoderPair chassisEncoders;
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
        /** Chassis */
        Component.pdp = new PDP();
        Component.navx = new NavX(SerialPort.Port.kMXP);

        // Chassis Encoders
        Component.leftWheelEncoder = new CustomCANCoder(Port.CAN.LEFT_WHEEL_ENCODER,
                RobotMap.Metrics.Chassis.METERS_PER_TICK);
        Component.rightWheelEncoder = new CustomCANCoder(Port.CAN.RIGHT_WHEEL_ENCODER,
                RobotMap.Metrics.Chassis.METERS_PER_TICK);

        // Chassis Motors
        Component.leftDriveA = new Motor("leftDriveA", true, new CANTalonFX(Port.CANMotor.LEFT_DRIVE_A));
        Component.leftDriveB = new Motor("leftDriveB", true, new CANTalonFX(Port.CANMotor.LEFT_DRIVE_B));
        Component.rightDriveA = new Motor("rightDriveA", false, new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_A));
        Component.rightDriveB = new Motor("rightDriveB", false, new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_B));

        Component.shifter = new SolenoidShifters(Port.Pneumatics.SHIFTER.buildDoubleSolenoid());

        // Classes
        Component.chassis = new TankDriveShifting(Metrics.Chassis.TURN_CORRECTION, Component.leftDriveA,
                Component.leftDriveB, Component.rightDriveA, Component.rightDriveB, Component.shifter);

        Component.sensorDrive = new SensorDrive(Component.chassis, Component.leftWheelEncoder,
                Component.rightWheelEncoder, Component.navx);

        Component.chassisTurnPID = new CustomPIDController(PID.Turn.P, PID.Turn.I, PID.Turn.D, PID.Turn.F,
                Component.sensorDrive);

        /** HumanInput */
        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.XBOX_CONTROLLER);
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.JOYSTICK);

        /** NetworkTables */
        NetworkTables.inst = NetworkTableInstance.getDefault();
        NetworkTables.Odometry.odometry = NetworkTables.inst.getTable("odometry");
        NetworkTables.Odometry.odometryXEntry = NetworkTables.Odometry.odometry.getEntry("x");
        NetworkTables.Odometry.odometryYEntry = NetworkTables.Odometry.odometry.getEntry("y");
        NetworkTables.Odometry.odometryAngleEntry = NetworkTables.Odometry.odometry.getEntry("angle");
    }

}
