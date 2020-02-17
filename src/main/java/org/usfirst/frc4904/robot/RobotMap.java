package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.custom.controllers.CustomJoystick;
import org.usfirst.frc4904.standard.custom.controllers.CustomXbox;
import org.usfirst.frc4904.standard.custom.motioncontrollers.CANTalonSRX;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

public class RobotMap {
  public static class Port {
    public static class HumanInput {
      public static final int joystick = 0;
      public static final int xboxController = 1;
    }

    public static class CANMotor {
      // Climb
      public static final int HOOK_MOTOR = -1;
      public static final int WINCH_MOTOR = -1;
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
    }
  }

  public static class DriveConstants {
  }

  public static class AutoConstants {
  }

  public static class PID {
    public static class Drive {
    }

    public static class Turn {
    }

  }

  public static class Component {
    public static Motor hookMotor;
    public static Motor winchMotor;
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
    HumanInput.Driver.xbox = new CustomXbox(Port.HumanInput.xboxController);
    HumanInput.Operator.joystick = new CustomJoystick(Port.HumanInput.joystick);

    Component.hookMotor = new Motor("HookMotor", new CANTalonSRX(Port.CANMotor.HOOK_MOTOR));
    Component.winchMotor = new Motor("WinchMotor", new CANTalonSRX(Port.CANMotor.WINCH_MOTOR));
  }
}
