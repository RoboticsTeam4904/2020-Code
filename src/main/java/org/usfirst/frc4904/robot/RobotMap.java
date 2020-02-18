package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonFX;
import org.usfirst.frc4904.standard.custom.sensors.CustomCANCoder;
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
            public static final int CONTROL_PANEL = -1; // TODO: determine
        }

        public static class PWM {
        }

        public static class CAN {
            public static final int CONTROL_PANEL_ENCODER = -1;
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

        public static class ControlPanel {
            public static final double TICKS_PER_REVOLUTION = -1; // TODO: Depending on encoder, change this constant
            public static final double DEGREES_PER_TICK = 360.0 / TICKS_PER_REVOLUTION;
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
        public static CustomCANCoder controlPanelEncoder;
    }

    public static class Input {
    }

    public static class NetworkTables {
        public static NetworkTableInstance inst;
        public static NetworkTable table;

        public static class Vision {
            public static NetworkTable table;

            public static class ControlPanel {
                public static NetworkTable table;
                public static NetworkTableEntry color;
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
        HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
        HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);

        // TODO: add a speed modifier?
        Component.controlPanel = new Motor("controlPanel", false, new CANTalonFX(Port.CANMotor.CONTROL_PANEL));
        Component.controlPanelEncoder = new CustomCANCoder(Port.CAN.CONTROL_PANEL_ENCODER,
                Metrics.ControlPanel.DEGREES_PER_TICK);

        /* NetworkTables */
        NetworkTables.inst = NetworkTableInstance.getDefault();
        NetworkTables.table = NetworkTables.inst.getTable("Team4904");
        NetworkTables.Vision.table = NetworkTables.table.getSubTable("vision");
        NetworkTables.Vision.ControlPanel.table = NetworkTables.Vision.table.getSubTable("controlPanel");
        NetworkTables.Vision.ControlPanel.color = NetworkTables.Vision.ControlPanel.table.getEntry("controlPanelColor");
    }
}