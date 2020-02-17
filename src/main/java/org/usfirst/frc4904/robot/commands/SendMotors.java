package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;

import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SendMotors extends CommandBase {

    double[] speeds;

    public SendMotors(Motor... motors) {
        speeds = new double[motors.length];
        for (int i = 0; i < motors.length; i++) {
            speeds[i] = motors[i].get();
        }
    }

    @Override
    public void initialize() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable splineTable = inst.getTable("splines");
        NetworkTableEntry splineX = splineTable.getEntry("splineX");
        NetworkTableEntry splineY = splineTable.getEntry("splineY");

        // splineX.forceSetNumberArray(xPos);
    }

}