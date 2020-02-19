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
    protected static final double NUM_COLORS = 2 * colorOrder.length; // there are two wedges of every color on the
                                                                      // control panel
    protected static final double DEGREES_IN_A_CIRCLE = 360.0;
    protected static final double DEGREES_PER_WEDGE = DEGREES_IN_A_CIRCLE / NUM_COLORS;
    protected static final double CONTROL_PANEL_DIAMETER = -1.0; // TODO: update these constants
    protected static final double PANEL_SPINNER_DIAMETER = -1.0;
    protected static final double PANEL_SPINNER_RATIO = CONTROL_PANEL_DIAMETER / PANEL_SPINNER_DIAMETER;

    protected int currentColor;
    protected double currentPosition;
    protected int colorsPassed;
    protected CustomCANCoder encoder;
    protected boolean motorDirection; // if the motor is spinning to the right, set to true, else false

    public ColorTracker(CustomCANCoder encoder, boolean motorDirection) {
        currentColor = Color.ERROR.id;
        this.encoder = encoder;
        setMotorDirection(motorDirection);
        reset();
        currentPosition = encoder.pidGet();
    }

    public ColorTracker() {
        this(RobotMap.Component.controlPanelEncoder, true);
    }

    /**
     * An enum of the different colors on the control panel. The ids correspond to
     * color order
     */
    enum Color {
        RED(0), YELLOW(1), BLUE(2), GREEN(3), ERROR(-1);

        public int id;

        private Color(int id) {
            this.id = id;
        }
    }

    /**
     * Reset Colors passed count to 0
     */
    public void reset() {
        colorsPassed = 0;
    }

    public void setMotorDirection(boolean motorDirection) {
        this.motorDirection = motorDirection;
    }

    /**
     * getter for number of color wedges passed
     * 
     * @return colorsPassed: number of color wedges passed
     */
    public int getColorsPassed() {
        return colorsPassed;
    }

    /**
     * @return String color
     */
    public int getColor() {
        return NetworkTables.Vision.ControlPanel.color.getNumber(Color.ERROR.id).intValue();
    }

    public void update() {
        double nextPosition = encoder.pidGet();
        double changeInPosition = nextPosition - currentPosition;
        while (currentColor == Color.ERROR.id) {
            currentColor = getColor();
        }
        int nextColor = getColor();
        if (nextColor == Color.ERROR.id) {
            LogKitten.e("Could not find a color");
            return;
        }
        if (currentColor != nextColor) {
            // if we've gone more than a half circle, we've passed a color twice
            int colorChange = nextColor - currentColor
                    + ((int) NUM_COLORS) / 2 * ((int) changeInPosition) / (int) (DEGREES_IN_A_CIRCLE / 2);
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
