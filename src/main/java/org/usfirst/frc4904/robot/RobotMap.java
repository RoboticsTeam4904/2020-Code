package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class RobotMap {
    public static class Port {
        public static class HumanInput {
            public static final int joystick = 0;
            public static final int xboxController = 1;
        }

        public static class CANMotor {
            public static final int controlPanel = -1;
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
        }

        public static class Turn {
        }
    }

    public static class Component {
        public static Motor controlPanel;
    }

    public static class Input {
    }

    public static class NetworkTables {
        public static NetworkTableInstance inst;
        public static NetworkTable table;

        public static class Sensors {
            public static NetworkTable table;
            public static NetworkTableEntry controlPanelColor;
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
        // TODO: add a speed modifier?
        Component.controlPanel = new Motor("controlPanel", false, new CANTalonFX(Port.CANMotor.controlPanel));

        /* NetworkTables */
        NetworkTables.inst = NetworkTableInstance.getDefault();
        NetworkTables.table = NetworkTables.inst.getTable("vision");
        NetworkTables.Sensors.table = NetworkTables.inst.getTable("sensorData");
        NetworkTables.Sensors.controlPanelColor = NetworkTables.Sensors.table.getEntry("controlPanelColor");
    }
}