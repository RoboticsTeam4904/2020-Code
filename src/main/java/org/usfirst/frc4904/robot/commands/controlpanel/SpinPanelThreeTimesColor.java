package org.usfirst.frc4904.robot.commands.controlpanel;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import java.util.function.Supplier;
import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.robot.RobotMap;

public class SpinPanelThreeTimesColor extends SequentialCommandGroup {
    protected static final int TOTAL_COLORS_PASSED = (int) (ColorTracker.NUM_COLORS
            * SpinPanelThreeTimes.TOTAL_REVOLUTIONS); // 24 color wedges need to be passed to spin three revolutions
    protected final ColorTracker tracker;

    /**
     * This command will spin the control panel three times based off the camera
     * feed.
     * 
     * @param name
     * @param colorChecker A class that handles everything pertaining to the color
     *                     sensor
     * @param motor        The motor to spin the control panel.
     */

    public SpinPanelThreeTimesColor() {
        super();
        setName("SpinPanelThreeTimesColor");
        addRequirements(RobotMap.Component.controlPanel);
        tracker = new ColorTracker();

        Supplier<Boolean> isDone = () -> {
            tracker.update();
            return tracker.getColorsPassed() >= TOTAL_COLORS_PASSED;
        };

        addCommands(new RunUntil(new SpinPanelMotorForward(), isDone), new StopPanelMotor());

    }
}
