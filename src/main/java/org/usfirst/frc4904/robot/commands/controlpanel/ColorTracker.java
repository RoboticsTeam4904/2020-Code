package org.usfirst.frc4904.robot.commands.controlpanel;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.RobotMap.NetworkTables;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.custom.sensors.CustomCANCoder;

/**
 * Uses encoder and camera data to track Control Panel color
 */
public class ColorTracker {
    protected static final Color[] colorOrder = new Color[] { Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN };
    protected static final double NUM_COLORS = 2 * colorOrder.length; // there are two wedges of every color on the control panel
    protected static final double DEGREES_IN_A_CIRCLE = 360.0;
    protected static final double DEGREES_PER_WEDGE = DEGREES_IN_A_CIRCLE / NUM_COLORS;
        protected static final double CONTROL_PANEL_DIAMETER = -1.0; //TODO: update these constants
    protected static final double PANEL_SPINNER_DIAMETER = -1.0;
    protected static final double PANEL_SPINNER_RATIO = CONTROL_PANEL_DIAMETER / PANEL_SPINNER_DIAMETER;

    protected Color currentColor;
    protected double currentPosition;
    protected int colorsPassed;
    protected CustomCANCoder encoder;
    protected boolean motorDirection; // if the motor is spinning to the right, set to true, else false

    public ColorTracker(CustomCANCoder encoder, boolean motorDirection) {
        currentColor = null;
        this.encoder = encoder;
        setMotorDirection(motorDirection);
        reset();
        currentPosition = encoder.pidGet();
    }

    public ColorTracker() {
        this(RobotMap.Component.controlPanelEncoder, true);
    }

    /**
     * An enum of the different colors on the control panel.
     */
    enum Color {
        RED, YELLOW, BLUE, GREEN;
    }

    public void reset() {
        colorsPassed = 0;
    }

    public void setMotorDirection(boolean motorDirection) {
        this.motorDirection = motorDirection;
    }

    public int getColorsPassed() {
        return colorsPassed;
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

    public void update() {
        double nextPosition = encoder.pidGet();
        double changeInPosition = nextPosition - currentPosition;
        while (currentColor == null) {
            currentColor = getColor();
        }
        Color nextColor = getColor();
        if (nextColor == null) {
            return;
        }
        if (currentColor != nextColor) {
            int colorChange = getIndex(nextColor) - getIndex(currentColor) + ((int) NUM_COLORS )/ 2 * ((int) changeInPosition )/ 180; // if we've gone more than a half circle, we've passed a color twice
            if (!motorDirection) {
                colorChange *= -1;
            }
            if (colorChange < 0) {
                colorChange += colorOrder.length;
            }
            colorsPassed += colorChange;
            currentColor = nextColor;
            currentPosition = nextPosition;
        }
    }

}
