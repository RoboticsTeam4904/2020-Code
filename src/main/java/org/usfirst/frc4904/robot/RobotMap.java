package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.robot.subsystems.Indexer;
import org.usfirst.frc4904.robot.subsystems.Intake;
import org.usfirst.frc4904.robot.subsystems.Shooter;
import org.usfirst.frc4904.standard.Util;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines.AutoConstants;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines.DriveConstants;
import org.usfirst.frc4904.standard.custom.CustomPIDSourceType;
import org.usfirst.frc4904.standard.custom.PCMPort;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.custom.sensors.CANTalonEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CustomCANCoder;
import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.custom.sensors.NavX;
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.subsystems.chassis.SplinesDrive;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDrive;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.VelocitySensorMotor;
import org.usfirst.frc4904.robot.subsystems.Hood;

import edu.wpi.first.wpilibj.SerialPort;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import edu.wpi.first.wpilibj.util.Units;

public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int joystick = 0;
            public static final int xboxController = 1;
        }

        public static class CANMotor {
            // Intake
            public static final int INTAKE_ROLLER_MOTOR = 10;
            public static final int INTAKE_FUNNEL_MOTOR = 5;
            // Indexer
            public static final int LIFT_BELT_MOTOR = 6;
            // Flywheel
            public static final int FLYWHEEL_MOTOR_A = 4;
            public static final int FLYWHEEL_MOTOR_B = 1;
            // Shooter
            public static final int RUN_UP_BELT_MOTOR = 8;
            public static final int HOOD_MOTOR = 3;


            public static final int RIGHT_DRIVE_A = 7;
            public static final int RIGHT_DRIVE_B = 11;
            public static final int LEFT_DRIVE_A = 0; //15
            public static final int LEFT_DRIVE_B = 15;

            // Climber
            public static final int WINCH_MOTOR = 13;
            public static final int HOOK_MOTOR = 9;
            public static final int CONTROL_PANEL_MOTOR = 12;
        }

        public static class PWM { // TODO: CHANGE CONSTS
        }

        public static class CAN { // TODO: CHANGE CONSTS
            public static final int LEFT_WHEEL_ENCODER = 2;
            public static final int RIGHT_WHEEL_ENCODER = 0;
        }

        public static class Pneumatics { // TODO: CHANGE CONSTS
            public static final PCMPort INTAKE_SOLENOID = new PCMPort(0, 0, 1); // correct
            // public static final PCMPort SHOOTER_AIM_SOLENOID = new PCMPort(0, -1, -1);
            public static final PCMPort SHIFTER = new PCMPort(0, 2, 3);
        }

        public static class Digital { // TODO: CHANGE CONSTS
            public static final int INDEXER_LIMIT_SWITCH = -1;
            public static final int HOOD_LIMIT_SWITCH = 9;
        }
    }

    public static class Metrics {
        public static class Chassis {
            public static final double TICKS_PER_REVOLUTION = 4096.0; // TODO: CHANGE CONSTS
            public static final double DIAMETER_METERS = Units.inchesToMeters(5);
            public static final double CIRCUMFERENCE_METERS = Metrics.Chassis.DIAMETER_METERS * Math.PI;
            public static final double TICKS_PER_INCH = Metrics.Chassis.TICKS_PER_REVOLUTION
                    / Metrics.Chassis.CIRCUMFERENCE_METERS;
            public static final double DISTANCE_FRONT_BACK = -1;
            public static final double DISTANCE_SIDE_SIDE = -1;
            public static final double METERS_PER_TICK = Metrics.Chassis.CIRCUMFERENCE_METERS
                    / Metrics.Chassis.TICKS_PER_REVOLUTION;
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

        public static class Hood {
            public static final double DEFAULT_RANGE_HOOD_ANGLES = 35.0;
            public static final double ENCODER_TICKS = 2048.0;
            public static final double FALCON_TO_SHAFT = 25.0;
            public static final double TEETH_PER_SHAFT_ROTATION = 20.0;
            public static final double TEETH_IF_FULL_CIRCLE = 364.0;
            public static final double TICKS_PER_SHAFT_ROTATION = ENCODER_TICKS * FALCON_TO_SHAFT;
            public static final double HOOD_ANGLE_PER_HOOD_TOOTH = 360.0 / TEETH_IF_FULL_CIRCLE;
            public static final double HOOD_ANGLE_PER_SHAFT = HOOD_ANGLE_PER_HOOD_TOOTH * TEETH_PER_SHAFT_ROTATION;
            public static final double HOOD_ANGLE_PER_TICK =  HOOD_ANGLE_PER_SHAFT / TICKS_PER_SHAFT_ROTATION;
        }
    }

    public static class DriveConstants {
        public static final boolean kGyroReversed = false;
        public static final double ksVolts = 0.318;
        public static final double kvVoltSecondsPerMeter = 2.16;
        public static final double kaVoltSecondsSquaredPerMeter = 0.415;
        public static final double kTrackwidthMeters = 0.5609370624495477;
        public static final double kPDriveVel = 15.0;
        // public static final SplineDriveConstants driveConstants = new SimpleSplines.SplineDriveConstants(ksVolts, kvVoltSecondsPerMeter, kaVoltSecondsSquaredPerMeter, kTrackwidthMeters, kPDriveVel);
    }

    public static class AutoConstants {
        public static final double kMaxSpeedMetersPerSecond = 2.3;
        public static final double kMaxAccelerationMetersPerSecondSquared = 2;
        public static final double kRamseteB = 2;
        public static final double kRamseteZeta = 0.7;
        // public static final SimpleSplines.SplineAutoConstants autoConstants = new SimpleSplines.SplineAutoConstants(kMaxSpeedMetersPerSecond, kMaxAccelerationMetersPerSecondSquared, kRamseteB, kRamseteZeta);
    }

    public static class PID {
        public static class Flywheel {
            public static final double P = 0.0084;
            public static final double I = 0;//0.000017;
            public static final double D = 0.085;
            public static final double F = 0.01;
        }

        public static class Hood {
            public static final double P = 0.0;
            public static final double I = 0.0;
            public static final double D = 0.0;
            public static final double F = 0.21;
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
        public static SolenoidSubsystem shooterAimSolenoid;
        public static SolenoidShifters shifter;

        public static Motor intakeRollerMotor;
        public static Motor funnelMotor;
        public static Motor liftBeltMotor;
        public static Motor runUpBeltMotor;
        public static VelocitySensorMotor flywheelMotorA;
        public static VelocitySensorMotor flywheelMotorB;
        public static Motor hoodMotor;

        public static CustomPIDController flywheelPID;

        public static CANTalonEncoder flywheelEncoder;
        public static CANTalonEncoder flywheelEncoderA;
        public static CANTalonEncoder flywheelEncoderB;

        public static CANTalonEncoder hoodEncoder;
        public static Motor leftDriveA;
        public static Motor leftDriveB;
        public static Motor rightDriveA;
        public static Motor rightDriveB;
        
        public static TankDriveShifting chassis;

        public static CustomCANCoder leftWheelEncoder;
        public static CustomCANCoder rightWheelEncoder;

        public static Motor testMotor;

        public static NavX navx;

        public static SplinesDrive nikhilChassis;
        public static CustomPIDController hoodPID;

    }

    public static class Input {
        public static CustomDigitalLimitSwitch indexerLimitSwitch;
        public static CustomDigitalLimitSwitch hoodLimitSwitch;
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
        Component.navx = new NavX(SerialPort.Port.kMXP);

        /** Human Input */
        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);

        /** Pneumatics */
        Component.intakeSolenoid = new
        SolenoidSubsystem(Port.Pneumatics.INTAKE_SOLENOID.buildDoubleSolenoid());
        // Component.shooterAimSolenoid = new SolenoidSubsystem(
        // Port.Pneumatics.SHOOTER_AIM_SOLENOID.buildDoubleSolenoid());

        /** Motors */
        Component.intakeRollerMotor = new Motor("intakeRollerMotor", true,
                new CANTalonSRX(Port.CANMotor.INTAKE_ROLLER_MOTOR));
        Component.funnelMotor = new Motor("funnelMotor", true, new CANTalonSRX(Port.CANMotor.INTAKE_FUNNEL_MOTOR));
        Component.liftBeltMotor = new Motor("liftBeltMotor", new CANTalonSRX(Port.CANMotor.LIFT_BELT_MOTOR));
        Component.runUpBeltMotor = new Motor("runUpBeltMotor", new CANTalonSRX(Port.CANMotor.RUN_UP_BELT_MOTOR));
        CANTalonFX flywheelATalon = new CANTalonFX(Port.CANMotor.FLYWHEEL_MOTOR_A);
        flywheelATalon.setInverted(true);
        CANTalonFX flywheelBTalon = new CANTalonFX(Port.CANMotor.FLYWHEEL_MOTOR_B);

        Component.leftDriveA = new Motor("leftDriveA", true, new CANTalonFX(Port.CANMotor.LEFT_DRIVE_A));
        Component.leftDriveB = new Motor("leftDriveB", true, new CANTalonFX(Port.CANMotor.LEFT_DRIVE_B));
        Component.rightDriveA = new Motor("rightDriveA", false, new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_A));
        Component.rightDriveB = new Motor("rightDriveB", false, new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_B));

        // Component.shifter = new
        // SolenoidShifters(Port.Pneumatics.SHIFTER.buildDoubleSolenoid());

        Component.shifter = new SolenoidShifters(Port.Pneumatics.SHIFTER.buildDoubleSolenoid());

        Component.chassis = new TankDriveShifting(Component.leftDriveA, Component.leftDriveB,
                Component.rightDriveA, Component.rightDriveB, Component.shifter);
        CANTalonFX hoodTalon = new CANTalonFX(Port.CANMotor.HOOD_MOTOR);
        Component.hoodMotor = new Motor("hoodMotor", hoodTalon);

        /** Digital */
        // Input.indexerLimitSwitch = new
        // CustomDigitalLimitSwitch(Port.Digital.INDEXER_LIMIT_SWITCH);
        Input.hoodLimitSwitch = new CustomDigitalLimitSwitch(Port.Digital.HOOD_LIMIT_SWITCH);

        /** Encoders */
        Component.flywheelEncoderB = new CANTalonEncoder(flywheelBTalon, false,
                Metrics.Encoders.TalonEncoders.REVOLUTIONS_PER_TICK);
        Component.flywheelEncoderB.setCustomPIDSourceType(CustomPIDSourceType.kRate);
        Component.leftWheelEncoder = new CustomCANCoder(Port.CAN.LEFT_WHEEL_ENCODER,
                RobotMap.Metrics.Chassis.METERS_PER_TICK);
        Component.leftWheelEncoder.configSensorDirection(false);
        Component.rightWheelEncoder = new CustomCANCoder(Port.CAN.RIGHT_WHEEL_ENCODER,
                RobotMap.Metrics.Chassis.METERS_PER_TICK);
        Component.hoodEncoder = new CANTalonEncoder(hoodTalon, Metrics.Hood.HOOD_ANGLE_PER_TICK);

        /** Motion Controllers */
        Component.flywheelPID = new CustomPIDController(PID.Flywheel.P, PID.Flywheel.I, PID.Flywheel.D, PID.Flywheel.F,
                Component.flywheelEncoderB);
        Component.hoodPID = new CustomPIDController(RobotMap.PID.Hood.P, RobotMap.PID.Hood.I, RobotMap.PID.Hood.D, RobotMap.PID.Hood.F, Component.hoodEncoder);
        /** Classes */
        // Component.intake = new Intake(Component.intakeRollerMotor,
        // Component.liftBeltMotor, Component.funnelMotor,
        // Component.intakeSolenoid);

        Component.flywheel = new Flywheel(Component.flywheelPID, flywheelATalon, flywheelBTalon);

        Component.hood = new Hood(Component.hoodMotor, Component.hoodEncoder, Component.hoodPID, Input.hoodLimitSwitch);
        // Component.shooter = new Shooter(Component.flywheel, Component.runUpBeltMotor,
        // Component.hood);

        // Component.nikhilChassis = new SplinesDrive(Component.chassis, AutoConstants.autoConstants, DriveConstants.driveConstants, Component.leftWheelEncoder, Component.rightWheelEncoder, Component.navx);
    }
}
