package org.usfirst.frc4904.robot.commands;

import java.util.ArrayList;
import java.util.List;
import org.usfirst.frc4904.auton.AutonRoutine;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;
import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.Trajectory.State;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class SendSplines extends CommandBase {
    Double[] xPos;
    Double[] yPos;

    Double[] startXs;
    Double[] startYs;

    public SendSplines(Trajectory spline) {
        List<State> states = spline.getStates();
        xPos = new Double[states.size()];
        yPos = new Double[states.size()];

        for (int i = 0; i < states.size(); i++) {
            xPos[i] = states.get(i).poseMeters.getTranslation().getX();
            yPos[i] = states.get(i).poseMeters.getTranslation().getY();
        }
    }

    public SendSplines(AutonRoutine autonRoutine) {

        startXs = new Double[autonRoutine.getSplinesList().size()];
        startYs = new Double[autonRoutine.getSplinesList().size()];

        List<State> states = new ArrayList<State>();
        for (int i = 0; i < autonRoutine.getSplinesList().size(); i++) {
            Command c = autonRoutine.getSplinesList().get(i);
            SimpleSplines s = (SimpleSplines) c;
            states.addAll(s.trajectory.getStates());
            startXs[i] = s.trajectory.getStates().get(0).poseMeters.getTranslation().getX();
            startYs[i] = s.trajectory.getStates().get(0).poseMeters.getTranslation().getY();
        }
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

        NetworkTableEntry startX = splineTable.getEntry("startX");
        NetworkTableEntry startY = splineTable.getEntry("startY");
        startX.forceSetNumberArray(startXs);
        startY.forceSetNumberArray(startYs);
    }
}
