
package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import org.usfirst.frc4904.standard.commands.WaitUntil;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.RobotMap.NetworkTables;

import java.util.function.Supplier;

import com.ctre.phoenix.sensors.CANCoder;
import com.fasterxml.jackson.databind.ser.std.StdKeySerializers.Default;

import org.usfirst.frc4904.robot.commands.StartPanelMotor;
import org.usfirst.frc4904.robot.commands.StopPanelMotor;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

import org.usfirst.frc4904.standard.LogKitten;

/**
 * This class contains everything pertaining to using the camera for the control
 * panel.
 */
public class ColorSensor extends SequentialCommandGroup {
    public final Color[] colorOrder = new Color[] { Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN };

    public Color currentColor;
    private Color initialColor; // is this var necessary?
    private int colorsPassed = 0;

    public ColorSensor() {
    }

    public void checkColorOrder() {
        Color tempColor = getColor();
        if (currentColor != tempColor) {
            Color oldColor = currentColor;
            currentColor = tempColor;
            colorsPassed++;
            if (getIndex(currentColor) == 3) {
                if (currentColor == colorOrder[0]) {
                    if (colorsPassed == 23) {
                        StopPanelMotor stopPanelMotor = new StopPanelMotor();
                        stopPanelMotor.schedule();
                    }
                } else {
                    LogKitten.wtf("A color somehow was skipped.");
                    // calculate how many were skipped
                }
            } else {
                if (currentColor == colorOrder[getIndex(oldColor) + 1]) {
                    if (colorsPassed == 23) {
                        StopPanelMotor stopPanelMotor = new StopPanelMotor();
                        stopPanelMotor.schedule();
                    }
                } else {
                    LogKitten.wtf("A color somehow was skipped.");
                    // calculate how many were skipped
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
            LogKitten.wtf("Cannot read control panel color");
            return null;
        } else if (colorResult == null) {
            LogKitten.wtf("Cannot read control panel color");
            return null;
        }
        switch (colorResult) {
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

    /**
     * An enum of the different colors on the control panel.
     */
    enum Color {
        RED, YELLOW, BLUE, GREEN;
    }

    public int getIndex(Color color) {
        for (int index = 0; index < colorOrder.length; index++) {
            if (colorOrder[index] == color) {
                return index;
            }
        }
        return -1;
    }

    /**
     * 
     * Classifies the rgb color value from the camera to red, yellow, blue, or green
     * 
     * @param colorString
     * @return Color
     */
    /*
     * public Color colorClassifier(String colorString) { if (colorString == null) {
     * return null; } int closestColorIndex = -1; int smallestDistance = 765; //
     * TODO: determine how the colorString is formatted so that we can get the three
     * // values below from it int red; int green; int blue; for (int index = 0;
     * index < ColorValuesArray.length; index++) { int distance = Math.abs(red -
     * ColorValuesArray[index][0]) + Math.abs(green - ColorValuesArray[index][1]) +
     * Math.abs(blue - ColorValuesArray[index][2]); if (distance < smallestDistance)
     * { smallestDistance = distance; closestColorIndex = index; } } switch
     * (closestColorIndex) { case 0: return Color.RED; case 1: return Color.YELLOW;
     * case 2: return Color.BLUE; case 3: return Color.GREEN; default: return null;
     * } }
     */
}
