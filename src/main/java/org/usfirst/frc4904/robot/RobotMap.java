package org.usfirst.frc4904.robot;

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;

import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.robot.subsystems.Hood;
import org.usfirst.frc4904.robot.subsystems.Indexer;
import org.usfirst.frc4904.robot.subsystems.Intake;
import org.usfirst.frc4904.robot.subsystems.Shooter;
import org.usfirst.frc4904.standard.custom.CustomPIDSourceType;
import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CustomPIDController;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.AccelerationCap;
import org.usfirst.frc4904.standard.subsystems.motor.speedmodifiers.EnableableModifier;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import org.usfirst.frc4904.standard.subsystems.chassis.SensorDrive;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDrive;
import org.usfirst.frc4904.standard.custom.sensors.CANEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CANTalonEncoder;
import org.usfirst.frc4904.standard.custom.sensors.CustomCANCoder;
import org.usfirst.frc4904.standard.custom.sensors.CustomDigitalLimitSwitch;
import org.usfirst.frc4904.standard.custom.sensors.NavX;
import org.usfirst.frc4904.standard.custom.sensors.PDP;

public class RobotMap {
  public static class Port {
    public static class HumanInput {
      public static final int JOYSTICK = 0;
      public static final int XBOX_CONTROLLER = 1;
    }

    public static class CANMotor {
      // Drive
      public static final int LEFT_DRIVE_A = 7;
      public static final int LEFT_DRIVE_B = 3;
      public static final int RIGHT_DRIVE_A = 4;
      public static final int RIGHT_DRIVE_B = 11;
      // Intake
      public static final int INTAKE_ROLLER_MOTOR = 10;
      public static final int INTAKE_FUNNEL_MOTOR = 5;
      // Indexer
      public static final int LIFT_BELT_MOTOR = 6;
      // Flywheel
      public static final int FLYWHEEL_MOTOR_A = 2;
      public static final int FLYWHEEL_MOTOR_B = 1;
      // Shooter
      public static final int RUN_UP_BELT_MOTOR = 8;
      // Climber
      public static final int WINCH_MOTOR = 0;
      public static final int HOOK_MOTOR = 9;
    }

    public static class PWM {
    }

    public static class CAN {
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

    public static class Flywheel {
      public static final double ROTATIONS_PER_TICK = 1.0 / 2048.0;
    }

  }
  // public static class PWM {
  // public static final int HOOD_MOTOR = -1;
  // }

  // public static class CAN {
  // public static final int HOOD_ENCODER = -1;
  // }

  public static class PID {
    public static class Flywheel {
      public static final double P = SmartDashboard.getNumber("P", 0);// 0.001;
      public static final double I = SmartDashboard.getNumber("I", 0);// 0.000000001;
      public static final double D = SmartDashboard.getNumber("D", 0);// 0;
      public static final double F = SmartDashboard.getNumber("F", 0);// 0.01;
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

  public static class Input {
    public static CustomDigitalLimitSwitch indexerLimitSwitch;
    public static CustomDigitalLimitSwitch hoodLowerLimitSwitch;
    public static CustomDigitalLimitSwitch hoodUpperLimitSwitch;

  }

  public static class Network {
    // These should be in units of meters, meters, and radians, respectively
    public static NetworkTableEntry odometryXEntry;
    public static NetworkTableEntry odometryYEntry;
    public static NetworkTableEntry odometryAngleEntry;
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
    public static SensorDrive sensorDrive;

    public static Intake intake;
    public static Indexer indexer;
    public static Flywheel flywheel;
    public static Shooter shooter;
    // public static Hood hood;

    public static Motor intakeRollerMotor;
    public static Motor funnelMotor;
    public static Motor liftBeltMotor;
    public static Motor runUpBeltMotor;
    public static Motor flywheelMotorA;
    public static Motor flywheelMotorB;
    public static Motor hoodMotor;

    public static Motor hookMotor;
    public static Motor winchMotor;

    public static CANTalonEncoder flywheelEncoder;
    public static CANEncoder hoodEncoder;

    public static CustomPIDController flywheelPIDController;
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

    Component.leftDriveA = new Motor("leftDriveA", false,
        new CANTalonFX(Port.CANMotor.LEFT_DRIVE_A, NeutralMode.Coast));
    Component.leftDriveB = new Motor("leftDriveB", false,
        new CANTalonFX(Port.CANMotor.LEFT_DRIVE_B, NeutralMode.Coast));
    Component.rightDriveA = new Motor("rightDriveA", true,
        new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_A, NeutralMode.Coast));
    Component.rightDriveB = new Motor("rightDriveB", true,
        new CANTalonFX(Port.CANMotor.RIGHT_DRIVE_B, NeutralMode.Coast));

    // Make Chassises
    Component.chassis = new TankDrive(Metrics.Chassis.TURN_CORRECTION, Component.leftDriveA, Component.leftDriveB,
        Component.rightDriveA, Component.rightDriveB);
    Component.sensorDrive = new SensorDrive(Component.chassis, Component.leftWheelEncoder, Component.rightWheelEncoder, Component.navx);

    // IntializeNetworktables
    NetworkTableInstance inst = NetworkTableInstance.getDefault();
    Network.odometryXEntry = inst.getEntry("odometry/x");
    Network.odometryYEntry = inst.getEntry("odometry/y");
    Network.odometryAngleEntry = inst.getEntry("odometry/angle");

    HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.XBOX_CONTROLLER);
    HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.JOYSTICK);

    Component.intakeRollerMotor = new Motor("intakeRollerMotor", true,
        new CANTalonSRX(Port.CANMotor.INTAKE_ROLLER_MOTOR));
    Component.funnelMotor = new Motor("funnelMotor", true, new CANTalonSRX(Port.CANMotor.INTAKE_FUNNEL_MOTOR));
    Component.liftBeltMotor = new Motor("liftBeltMotor", new CANTalonSRX(Port.CANMotor.LIFT_BELT_MOTOR));
    Component.runUpBeltMotor = new Motor("runUpBeltMotor", new CANTalonSRX(Port.CANMotor.RUN_UP_BELT_MOTOR));
    CANTalonFX flywheelATalon = new CANTalonFX(Port.CANMotor.FLYWHEEL_MOTOR_A);
    Component.flywheelMotorA = new Motor("flywheelMotorA", true, flywheelATalon);
    Component.flywheelMotorB = new Motor("flywheelMotorB", new CANTalonFX(Port.CANMotor.FLYWHEEL_MOTOR_B));
    // Component.hoodMotor = new Motor("hoodMotor", new
    // ContinuousServoController(Port.PWM.HOOD_MOTOR));

    // Input.indexerLimitSwitch = new
    // CustomDigitalLimitSwitch(Port.Digital.INDEXER_LIMIT_SWITCH);
    // Input.hoodLowerLimitSwitch = new
    // CustomDigitalLimitSwitch(Port.Digital.HOOD_LOWER_LIMIT_SWITCH);
    // Input.hoodUpperLimitSwitch = new
    // CustomDigitalLimitSwitch(Port.Digital.HOOD_UPPER_LIMIT_SWITCH);

    // Component.intake = new Intake(Component.intakeRollerMotor,
    // Component.funnelMotor, Component.intakeSolenoid);
    // Component.indexer = new Indexer(Component.liftBeltMotor,
    // Component.flipperSolenoid, Input.indexerLimitSwitch);

    Component.flywheelEncoder = new CANTalonEncoder("flywheelEncoder", flywheelATalon, true,
        Metrics.Flywheel.ROTATIONS_PER_TICK, CustomPIDSourceType.kRate, FeedbackDevice.IntegratedSensor);
    Component.flywheelPIDController = new CustomPIDController(PID.Flywheel.P, PID.Flywheel.I, PID.Flywheel.D,
        PID.Flywheel.F, Component.flywheelEncoder);
    Component.flywheel = new Flywheel(Component.flywheelPIDController, Component.flywheelMotorA,
        Component.flywheelMotorB);

    // Component.hoodEncoder = new CANEncoder(Port.CAN.HOOD_ENCODER);
    // Component.hood = new Hood(Component.hoodMotor, Component.hoodEncoder,
    // Input.hoodLowerLimitSwitch, Input.hoodUpperLimitSwitch);
    // Component.shooter = new Shooter(Component.flywheel, Component.runUpBeltMotor,
    // Component.hood);

    Component.hookMotor = new Motor("HookMotor", new CANTalonSRX(Port.CANMotor.HOOK_MOTOR));
    Component.winchMotor = new Motor("WinchMotor", new CANTalonFX(Port.CANMotor.WINCH_MOTOR));
  }
}