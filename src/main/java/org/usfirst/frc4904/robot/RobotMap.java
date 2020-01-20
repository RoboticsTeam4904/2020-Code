package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import edu.wpi.first.wpilibj.kinematics.DifferentialDriveKinematics;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.subsystems.chassis.SolenoidShifters;
import org.usfirst.frc4904.standard.custom.sensors.PDP;
import org.usfirst.frc4904.standard.subsystems.chassis.TankDriveShifting;


public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int joystick = 0;
            public static final int xboxController = 1;
        }

        public static class CANMotor {
            public static final int driveFLeft = 1; // TODO: possible config required 
			public static final int driveBLeft = 2; // TODO: possible config required 
			public static final int driveFRight = 3; // TODO: possible config required 
			public static final int driveBRight = 4; // TODO: possible config required 
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
        public static class Drive {
            public static final double P = -1; // TODO: maybe TUNE
			public static final double I = -1;
			public static final double D = -1;
			public static final double F = -1;
			public static final double tolerance = -1;
			public static final double dTolerance = -1;
        }

        public static class Turn {
            public static final double P = -1; // TODO: TUNE
			public static final double I = -1;
			public static final double D = -1;
			public static final double F = -1;
			public static final double tolerance = -1;
			public static final double dTolerance = -1;
        }
    }

    public static class Component {
        public static PDP pdp;
		public static Motor Motor_FL;
		public static Motor Motor_FR;
		public static Motor Motor_BL;
		public static Motor Motor_BR;
		public static TankDriveShifting chassis;
		public static SolenoidShifters shifter;
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
		Component.Motor_FL  = new Motor("Motor_FL", false, new CANTalonSRX(Port.CANMotor.driveFLeft));
		Component.Motor_FR = new Motor("Motor_FR", false, new CANTalonSRX(Port.CANMotor.driveFRight));
		Component.Motor_BL = new Motor("Motor_BL", false, new CANTalonSRX(Port.CANMotor.driveBLeft));
		Component.Motor_BR = new Motor("Motor_BR", false, new CANTalonSRX(Port.CANMotor.driveBRight));
		Component.Motor_BL.setInverted(true); // TODO: possible config required 
        Component.Motor_FL.setInverted(true); // TODO: possible cnfig required 
        Component.chassis = new TankDriveShifting(0d, RobotMap.Component.Motor_FL, RobotMap.Component.Motor_BL, RobotMap.Component.Motor_FR, RobotMap.Component.Motor_BR, Component.shifter);
        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);
    }
}
