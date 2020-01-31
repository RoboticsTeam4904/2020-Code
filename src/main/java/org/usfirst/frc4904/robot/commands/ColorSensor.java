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
public class ColorSensor {
    private final Color[] colorOrder = new Color[] { Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN };

    private final int[] RED = new int[] { 255, 0, 0 };
    private final int[] YELLOW = new int[] { 255, 255, 0 };
    private final int[] BLUE = new int[] { 0, 0, 255 };
    private final int[] GREEN = new int[] { 0, 255, 0 };

    private final int[][] ColorValuesArray = new int[][] { RED, YELLOW, BLUE, GREEN };

    private Color currentColor;
    private Color initialColor;

    private NetworkTableInstance inst = NetworkTableInstance.getDefault();
    private NetworkTable table = inst.getTable("controlPanelColor"); // TODO: get the actual name of the data table

    public ColorSensor() {
    }

    // TODO: compare the current color to the color detected and add to the
    public void checkColorOrder() {
        if (currentColor != colorClassifier())
        {
            // different color!
            currentColor = colorClassifier();
            if (currentColor == colorOrder[(orderWeAreOn + 1) % 3]) {
                // On correct trajectory!   
                if (orderWeAreOn == 23) {
                    // it has traveled 3 times around
                    StopPanelMotor stopPanelMotor = new StopPanelMotor();
                    // do we need to manually initialize the stopPanelMotorCommand? 
                }
            } else {
                // We skipped one!
                for (int i = 0; i < 4; i++) {

                }
            }
        }
    }

    /**
     * 
     * Classifies the rgb color value from the camera to red, yellow, blue, or green
     * 
     * @param colorString
     * @return
     */
    public Color colorClassifier(String colorString) {
        if (colorString == null)
        {
            return null;
        }
        int closestColorIndex = -1;
        int smallestDistance = 765;
        // TODO: determine how the colorString is value so that we can get the three
        // values below from it
        int red;
        int green;
        int blue;
        for (int index = 0; index < ColorValuesArray.length; index++) {
            int distance = Math.abs(red - ColorValuesArray[index][0]) + Math.abs(green - ColorValuesArray[index][1])
                    + Math.abs(blue - ColorValuesArray[index][2]);
            if (distance < smallestDistance) {
                smallestDistance = distance;
                closestColorIndex = index;
            }
        }
        switch (closestColorIndex) {
        case 0:
            return Color.RED;
        case 1:
            return Color.YELLOW;
        case 2:
            return Color.BLUE;
        case 3:
            return Color.GREEN;
        default:
            return null;
        }
    }

    /**
     * 
     * Classifies the rgb color value from the camera to red, yellow, blue, or green
     * 
     * @return
     */
    public Color colorClassifier() {
        String colorString = detectColor();
        if (colorString == null)
        {
            return null;
        }
        int closestColorIndex = -1;
        int smallestDistance = 765;
        // TODO: determine how the colorString is value so that we can get the three
        // values below from it
        int red;
        int green;
        int blue;
        for (int index = 0; index < ColorValuesArray.length; index++) {
            int distance = Math.abs(red - ColorValuesArray[index][0]) + Math.abs(green - ColorValuesArray[index][1])
                    + Math.abs(blue - ColorValuesArray[index][2]);
            if (distance < smallestDistance) {
                smallestDistance = distance;
                closestColorIndex = index;
            }
        }
        switch (closestColorIndex) {
        case 0:
            return Color.RED;
        case 1:
            return Color.YELLOW;
        case 2:
            return Color.BLUE;
        case 3:
            return Color.GREEN;
        default:
            return null;
        }
    }

    public String detectColor() {
        String colorResult = NetworkTables.Sensors.controlPanelColor.getString(null);
        if (colorResult == null) {
            LogKitten.wtf("Cannot read control panel color");
        }
        return colorResult;
    }

    enum Color {
        RED, YELLOW, BLUE, GREEN;
    }
}
