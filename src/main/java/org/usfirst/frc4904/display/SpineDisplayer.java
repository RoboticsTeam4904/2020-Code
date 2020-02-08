package org.usfirst.frc4904.display;

import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import javax.swing.*;

import edu.wpi.first.networktables.NetworkTable;

class SplineDisplayer extends JPanel {

    double[] splineXs;
    double[] splineYs;

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 300);
        frame.add(new SplineDisplayer());
    }

    public SplineDisplayer() {
        NetworkTableInstance inst = NetworkTableInstance.getDefault();
        NetworkTable table = inst.getTable("datatable");
        NetworkTableEntry splineEntry = table.getEntry("spline");
        splineXs = splineEntry.getDoubleArray(new double[] {});
        splineYs = splineEntry.getDoubleArray(new double[] {});

    }

    @Override
    public void paint(java.awt.Graphics g) {
        for (int i = 0; i < splineXs.length - 1; i++) {
            g.drawLine((int) splineXs[i], (int) splineYs[i], (int) splineXs[i + 1], (int) splineYs[i + 1]);
        }
    }
}