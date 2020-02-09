package org.usfirst.frc4904.robot.commands.controlpanel;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import org.usfirst.frc4904.robot.commands.controlpanel.StartPanelMotor;
import org.usfirst.frc4904.robot.commands.controlpanel.StopPanelMotor;
import java.util.function.Supplier;
import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.robot.RobotMap;

public class SpinPanelThreeTimesColor extends SequentialCommandGroup {

    private final Motor motor;
    private ColorChecker colorChecker;

    /**
     * This command will spin the control panel three times based off the camera
     * feed.
     * 
     * @param name
     * @param colorChecker A class that handles everything pertaining to the color
     *                     sensor
     * @param motor        The motor to spin the control panel.
     */

    public SpinPanelThreeTimesColor(String name, ColorChecker colorChecker, Motor motor) {
        super();
        this.motor = motor;
        this.colorChecker = colorChecker;
        addRequirements(this.motor);
        setName(name);

        Supplier<Boolean> isDone = () -> {
            return this.colorChecker.trackColorChange();
        };

        addCommands(new RunUntil(new StartPanelMotor(this.motor), isDone), new StopPanelMotor(this.motor));

    }

    /**
     * 
     * @param name
     */
    public SpinPanelThreeTimesColor(String name) {
        this(name, new ColorChecker(), RobotMap.Component.controlPanel);
    }

    /**
     * This command will spin the control panel three times based off the camera
     * feed.
     */
    public SpinPanelThreeTimesColor() {
        this("SpinPanelThreeTimesColor");
    }
}
