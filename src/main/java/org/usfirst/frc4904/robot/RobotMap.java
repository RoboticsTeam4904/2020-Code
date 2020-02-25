package org.usfirst.frc4904.robot;

import com.ctre.phoenix.sensors.CANCoderConfiguration;

import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.robot.subsystems.Indexer;
import org.usfirst.frc4904.robot.subsystems.Intake;
import org.usfirst.frc4904.robot.subsystems.Shooter;
import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.ContinuousServoController;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CANTalonEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CustomCANCoder;
import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.custom.sensors.EncoderPair;
import org.usfirst.frc4904.standard.custom.sensors.NavX;
import org.usfirst.frc4904.standard.custom.sensors.PDP;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.chassis.SensorDrive;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;
import org.usfirst.frc4904.robot.subsystems.Hood;

import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;;

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

            // Intake
            public static final int INTAKE_ROLLER_MOTOR = -1;
            public static final int INTAKE_FUNNEL_MOTOR = -1;
            // Indexer
            public static final int LIFT_BELT_MOTOR = -1;
            // Flywheel
            public static final int FLYWHEEL_MOTOR_A = -1;
            public static final int FLYWHEEL_MOTOR_B = -1;
            // Shooter
            public static final int RUN_UP_BELT_MOTOR = -1;
        }

        public static class PWM {
            public static final int HOOD_MOTOR = -1;
        }

        public static class CAN {
            public static final int LEFT_WHEEL_ENCODER = -1;
            public static final int RIGHT_WHEEL_ENCODER = -1;
            public static final int HOOD_ENCODER = -1;
        }

        public static class Pneumatics {
            public static final PCMPort INTAKE_SOLENOID = new PCMPort(0, -1, -1);
            public static final PCMPort FLIPPER_SOLENOID = new PCMPort(0, -1, -1);
            public static final PCMPort SHOOTER_AIM_SOLENOID = new PCMPort(0, -1, -1);

            public static final PCMPort SHIFTER = new PCMPort(-1, -1, -1);
        }

        public static class Digital {
            public static final int INDEXER_LIMIT_SWITCH = -1;
            public static final int HOOD_LOWER_LIMIT_SWITCH = -1;
            public static final int HOOD_UPPER_LIMIT_SWITCH = -1;
        }
    }

    public static class Metrics {
        public static class Chassis {
            public static final double TICKS_PER_REVOLUTION = -1; // TODO: CHANGE CONSTS
            public static final double DIAMETER_METERS = -1;
            public static final double CIRCUMFERENCE_METERS = Metrics.Chassis.DIAMETER_METERS * Math.PI;
            public static final double TICKS_PER_INCH = Metrics.Chassis.TICKS_PER_REVOLUTION
                    / Metrics.Chassis.CIRCUMFERENCE_METERS;
            public static final double DISTANCE_FRONT_BACK = -1;
            public static final double DISTANCE_SIDE_SIDE = -1;
            public static final double METERS_PER_TICK = Metrics.Chassis.CIRCUMFERENCE_METERS
                    / Metrics.Chassis.TICKS_PER_REVOLUTION;
            public static final double TURN_CORRECTION = 0.0;
        }

        public static class Flywheel {
            public static final double ROTATIONS_PER_TICK = 1.0 / 2048.0;
        }
    }

    public static class DriveConstants {
        public static final boolean kGyroReversed = false;
        public static final double ksVolts = -1;
        public static final double kvVoltSecondsPerMeter = -1;
        public static final double kaVoltSecondsSquaredPerMeter = -1;
        public static final double kTrackwidthMeters = -1;
        public static final DifferentialDriveKinematics kDriveKinematics = new DifferentialDriveKinematics(
                kTrackwidthMeters);
        public static final double kPDriveVel = -1;
    }

    public static class AutoConstants {
        public static final double kMaxSpeedMetersPerSecond = -1;
        public static final double kMaxAccelerationMetersPerSecondSquared = -1;
        public static final double kRamseteB = -1;
        public static final double kRamseteZeta = -1;
    }

    public static class PID {
        public static class Flywheel {
            public static final double P = 0;
            public static final double I = 0;
            public static final double D = 0;
            public static final double F = 0;
        }

        public static class Hood {
            public static final double P = 0;
            public static final double I = 0;
            public static final double D = 0;
            public static final double F = 0;
        }

        public static class Drive {
        }

        public static class Turn {
        }

    }

    public static class Component {
        public static Intake intake;
        public static Indexer indexer;
        public static Flywheel flywheel;
        public static Shooter shooter;
        public static Hood hood;

        public static SolenoidSubsystem intakeSolenoid;
        public static SolenoidSubsystem flipperSolenoid;
        public static SolenoidSubsystem shooterAimSolenoid;

        public static Motor intakeRollerMotor;
        public static Motor funnelMotor;
        public static Motor liftBeltMotor;
        public static Motor runUpBeltMotor;
        public static Motor flywheelMotorA;
        public static Motor flywheelMotorB;
        public static Motor hoodMotor;

        public static PDP pdp;
        public static Motor leftDriveA;
        public static Motor leftDriveB;
        public static Motor rightDriveA;
        public static Motor rightDriveB;

        public static TankDriveShifting chassis;
        public static SensorDrive sensorChassis;
        public static SolenoidShifters shifter;
        public static EnableableModifier leftWheelAccelerationCap;
        public static EnableableModifier rightWheelAccelerationCap;
        public static CustomCANCoder leftWheelEncoder;
        public static CustomCANCoder rightWheelEncoder;
        public static EncoderPair chassisEncoders;
        public static CANCoderConfiguration canCoderConfiguration;
        public static NavX navx;

        public static CANTalonEncoder flywheelEncoder;
        public static CANEncoder hoodEncoder;
    }

    public static class Input {
        public static CustomDigitalLimitSwitch indexerLimitSwitch;
        public static CustomDigitalLimitSwitch hoodLowerLimitSwitch;
        public static CustomDigitalLimitSwitch hoodUpperLimitSwitch;
    }

    public static class HumanInput {
        public static class Driver {
            public static CustomXbox xbox;
        }

        public static class Operator {
            public static CustomJoystick joystick;
        }
    }
    
    public static class NetworkTables {
        public static NetworkTableInstance inst;
        public static NetworkTable table;

        public static class Localization {
            public static NetworkTable locData;
            public static NetworkTableEntry x;
            public static NetworkTableEntry y;
            public static NetworkTableEntry theta;
        }
    }

    public RobotMap() {
        Component.intakeSolenoid = new SolenoidSubsystem(Port.Pneumatics.INTAKE_SOLENOID.buildDoubleSolenoid());
        Component.flipperSolenoid = new SolenoidSubsystem(Port.Pneumatics.FLIPPER_SOLENOID.buildDoubleSolenoid());
        Component.shooterAimSolenoid = new SolenoidSubsystem(
                Port.Pneumatics.SHOOTER_AIM_SOLENOID.buildDoubleSolenoid());

        Component.intakeRollerMotor = new Motor("intakeRollerMotor",
                new CANTalonSRX(Port.CANMotor.INTAKE_ROLLER_MOTOR));
        Component.funnelMotor = new Motor("funnelMotor", new CANTalonSRX(Port.CANMotor.INTAKE_FUNNEL_MOTOR));
        Component.liftBeltMotor = new Motor("liftBeltMotor", new CANTalonSRX(Port.CANMotor.LIFT_BELT_MOTOR));
        Component.runUpBeltMotor = new Motor("runUpBeltMotor", new CANTalonSRX(Port.CANMotor.RUN_UP_BELT_MOTOR));
        CANTalonFX flywheelATalon = new CANTalonFX(Port.CANMotor.FLYWHEEL_MOTOR_A);
        Component.flywheelMotorA = new Motor("flywheelMotorA", flywheelATalon);
        Component.flywheelMotorB = new Motor("flywheelMotorB", new CANTalonFX(Port.CANMotor.FLYWHEEL_MOTOR_B));
        Component.hoodMotor = new Motor("hoodMotor", new ContinuousServoController(Port.PWM.HOOD_MOTOR));

        Input.indexerLimitSwitch = new CustomDigitalLimitSwitch(Port.Digital.INDEXER_LIMIT_SWITCH);
        Input.hoodLowerLimitSwitch = new CustomDigitalLimitSwitch(Port.Digital.HOOD_LOWER_LIMIT_SWITCH);
        Input.hoodUpperLimitSwitch = new CustomDigitalLimitSwitch(Port.Digital.HOOD_UPPER_LIMIT_SWITCH);

        Component.intake = new Intake(Component.intakeRollerMotor, Component.funnelMotor, Component.intakeSolenoid);
        Component.indexer = new Indexer(Component.liftBeltMotor, Component.flipperSolenoid, Input.indexerLimitSwitch);

        Component.flywheelEncoder = new CANTalonEncoder(flywheelATalon, Metrics.Flywheel.ROTATIONS_PER_TICK);
        Component.flywheel = new Flywheel(
                new CustomPIDController(PID.Flywheel.P, PID.Flywheel.I, PID.Flywheel.D, Component.flywheelEncoder));

        Component.hoodEncoder = new CANEncoder(Port.CAN.HOOD_ENCODER);
        Component.hood = new Hood(Component.hoodMotor, Component.hoodEncoder, Input.hoodLowerLimitSwitch,
                Input.hoodUpperLimitSwitch);
        Component.shooter = new Shooter(Component.flywheel, Component.runUpBeltMotor, Component.hood);

        Component.pdp = new PDP();

        Component.leftWheelEncoder = new CustomCANCoder(Port.CAN.LEFT_WHEEL_ENCODER,
                RobotMap.Metrics.Chassis.METERS_PER_TICK);
        Component.rightWheelEncoder = new CustomCANCoder(Port.CAN.RIGHT_WHEEL_ENCODER,
                RobotMap.Metrics.Chassis.METERS_PER_TICK);

        Component.leftWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
        Component.leftWheelAccelerationCap.enable();
        Component.rightWheelAccelerationCap = new EnableableModifier(new AccelerationCap(Component.pdp));
        Component.rightWheelAccelerationCap.enable();

        Component.leftDriveA = new Motor("leftDriveA", true, new CANTalonFX(Port.CANMotor.LEFT_DRIVE_A));
        Component.leftDriveB = new Motor("leftDriveB", true, new CANTalonFX(Port.CANMotor.LEFT_DRIVE_B));
        Component.rightDriveA = new Motor("rightDriveA", false, new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_A));
        Component.rightDriveB = new Motor("rightDriveB", false, new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_B));

        Component.shifter = new SolenoidShifters(Port.Pneumatics.SHIFTER.buildDoubleSolenoid());

        Component.chassis = new TankDriveShifting(Metrics.Chassis.TURN_CORRECTION, Component.leftDriveA,
                Component.leftDriveB, Component.rightDriveA, Component.rightDriveB, Component.shifter);

        Component.sensorChassis = new SensorDrive(Component.chassis, null, null, Component.leftWheelEncoder,
                Component.rightWheelEncoder, null);

        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.XBOX_CONTROLLER);
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.JOYSTICK);

        // Network Tables
        NetworkTables.inst = NetworkTableInstance.getDefault();
        NetworkTables.table = NetworkTables.inst.getTable("team4904");
        // NetworkTables.Localization.locData = NetworkTables.inst.getSubTable("vision");
    }
}