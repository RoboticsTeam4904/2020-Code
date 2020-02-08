package org.usfirst.frc4904.robot.commands;

import java.util.List;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.Trajectory.State;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SendSplines extends CommandBase {
    Double[] xPos;
    Double[] yPos;

    public SendSplines(Trajectory spline) {
        List<State> states = spline.getStates();
        xPos = new Double[states.size()];
        yPos = new Double[states.size()];
        for (int i = 0; i < states.size(); i++) {
            xPos[i] = states.get(i).poseMeters.getTranslation().getX();
            yPos[i] = states.get(i).poseMeters.getTranslation().getY();
        }
    }

    @Override
    public void initialize() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable splineTable = inst.getTable("splines");
        NetworkTableEntry splineX = splineTable.getEntry("splineX");
        NetworkTableEntry splineY = splineTable.getEntry("splineY");

        splineX.forceSetNumberArray(xPos);
        splineY.forceSetNumberArray(yPos);
    }
}