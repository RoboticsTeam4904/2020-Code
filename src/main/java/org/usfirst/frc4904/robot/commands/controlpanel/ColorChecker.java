
package org.usfirst.frc4904.robot.commands.controlpanel;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import org.usfirst.frc4904.robot.RobotMap.NetworkTables;
import org.usfirst.frc4904.standard.LogKitten;

/**
 * This class contains everything pertaining to using the camera for the control
 * panel.
 */
public abstract class ColorChecker extends SequentialCommandGroup {
    public final Color[] colorOrder = new Color[] { Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN };

    public Color currentColor = null;
    private int colorsPassed = 0;
    private final int TOTAL_COLORS = 23; // the number of colors passed to reach 3 full revolutions
    public boolean doneSpinning = false;

    /**
     * An enum of the different colors on the control panel.
     */
    enum Color {
        RED, YELLOW, BLUE, GREEN;
    }

    public void trackColorChange() {
        if (currentColor == null) {
            currentColor = getColor();
            return;
        }
        Color tempColor = getColor();
        if (currentColor != tempColor) {
            Color oldColor = currentColor;
            currentColor = tempColor;
            colorsPassed++;
            if (getIndex(currentColor) == colorOrder.length + 1) {
                if (currentColor == colorOrder[0]) {
                    if (colorsPassed == TOTAL_COLORS) {
                        doneSpinning = true;
                    }
                } else { // TODO: handle this differently
                    LogKitten.wtf("A color somehow was skipped and we have no code to handle it! :)");
                    // it is very unlikely for a color to be skipped because the control panel will
                    // not be rotating that quickly
                }
            } else {
                if (currentColor == colorOrder[getIndex(oldColor) + 1]) {
                    if (colorsPassed == TOTAL_COLORS) {
                        doneSpinning = true;
                    }
                } else {
                    LogKitten.wtf(
                            "A color somehow was skipped and we have no code to handle it! :) please consider not dying");
                    // it is very unlikely for a color to be skipped because the control panel will
                    // not be rotating that quickly
                }
            }
        }
    }

    /**
     * 
     * @return String color
     */
    public Color getColor() {
        String colorResult = NetworkTables.Sensors.controlPanelColor.getString("ERROR");
        if (colorResult == "ERROR") {
            LogKitten.wtf("Control panel color not in network table. ERROR was returned instead.");
            return null;
        } else if (colorResult == null) {
            LogKitten.wtf("Control panel color not in network table. Null was returned instead.");
            return null;
        }
        switch (colorResult) { // TODO: get correct format for strings based off networktables
        case "RED":
            return Color.RED;
        case "GREEN":
            return Color.GREEN;
        case "YELLOW":
            return Color.YELLOW;
        case "BLUE":
            return Color.BLUE;
        default:
            return null;
        }
    }

    public int getIndex(Color color) {
        for (int index = 0; index < colorOrder.length; index++) {
            if (colorOrder[index] == color) {
                return index;
            }
        }
        return -1;
    }
}
