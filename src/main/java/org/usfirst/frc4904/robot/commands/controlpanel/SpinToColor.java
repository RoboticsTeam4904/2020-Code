package org.usfirst.frc4904.robot.commands.controlpanel;

import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.RunIfElse;
import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import java.util.function.Supplier;

import org.usfirst.frc4904.robot.commands.controlpanel.ColorTracker.Color;
import org.usfirst.frc4904.robot.RobotMap;

public class SpinToColor extends SequentialCommandGroup {
    protected final ColorTracker tracker;
    protected final Color targetColor;
    protected Color currentColor = null;
    protected boolean motorDirection = true;
    protected static final int MEDIAN_DISTANCE = 2; // it's equally as fast to go left or right if we're two away from
                                                    // the targetColor

    /**
     * @param motor        The motor to spin the control panel.
     * @param targetColor  A string representation of the color that needs to be
     *                     spinned to
     * @param colorChecker A class that handles everything pertaining to the color
     *                     sensor
     */
    public SpinToColor(Color targetColor) {
        super();
        setName("SpinToColor");
        addRequirements(RobotMap.Component.controlPanel);
        this.targetColor = targetColor;
        this.tracker = new ColorTracker();
        this.currentColor = tracker.getColor();
        this.motorDirection = determineOptimalDirection();
        tracker.setMotorDirection(motorDirection);

        Supplier<Boolean> isDone = () -> {
            tracker.update();
            Color currentColor = tracker.getColor();

            if (currentColor == null) { // if we can't determine the color, just give up
                LogKitten.wtf("Can't determine current color.");
                return true;
            }
            return currentColor == targetColor;
        };

        addCommands(new RunUntil(new RunIfElse(new SpinPanelMotorForward(), new SpinPanelMotorReverse(), this::getMotorDirection
        ), isDone), new StopPanelMotor());
    }

    public boolean getMotorDirection () {
        return motorDirection;
    }

    /**
     * Determines the optimal direction to turn in
     * 
     * @return true if we should turn to the right, false if turn to the left
     */
    public boolean determineOptimalDirection() {
        if (currentColor == null || targetColor == null) {
            return true;
        }
        int distance = tracker.getIndex(currentColor) - tracker.getIndex(targetColor);
        if (distance == 0) {
            return true;
        } else if (Math.abs(distance) == MEDIAN_DISTANCE) {
            return true;
        } else if (Math.abs(distance) < MEDIAN_DISTANCE) {
            if (distance < 0) {
                return false;
            } else {
                return true;
            }

        } else {
            if (distance < 0) {
                return true;
            } else {
                return false;
            }
        }

    }
}
