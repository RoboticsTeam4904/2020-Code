package org.usfirst.frc4904.robot.commands.controlpanel;

import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import java.util.function.Supplier;

import org.usfirst.frc4904.robot.commands.controlpanel.StartPanelMotor;
import org.usfirst.frc4904.robot.commands.controlpanel.StopPanelMotor;
import org.usfirst.frc4904.robot.commands.controlpanel.ColorChecker;
import org.usfirst.frc4904.robot.commands.controlpanel.ColorChecker.Color;
import org.usfirst.frc4904.robot.RobotMap;

public class SpinToColor extends SequentialCommandGroup {
    private final Motor motor;
    private final Color color;
    private ColorChecker colorChecker;

    /**
     * @param motor        The motor to spin the control panel.
     * @param color        A string representation of the color that needs to be
     *                     spinned to
     * @param colorChecker A class that handles everything pertaining to the color
     *                     sensor
     */
    public SpinToColor(Motor motor, Color color, ColorChecker colorChecker) {
        super();
        this.motor = motor;
        this.color = color;
        this.colorChecker = colorChecker;

        addRequirements(this.motor);

        Supplier<Boolean> isDone = () -> {
            Color colorResult = this.colorChecker.getColor();
            if (colorResult == null) {
                return false;
            }
            return colorResult == this.color;
        };

        addCommands(new RunUntil(new StartPanelMotor(this.motor), isDone), new StopPanelMotor(this.motor));
    }

    /**
     * @param motor The motor to spin the control panel.
     * @param color A string representation of the color that needs to be spinned to
     */
    public SpinToColor(Motor motor, Color color) {
        super();
        this.motor = motor;
        this.color = color;

        addRequirements(this.motor);

        Supplier<Boolean> isDone = () -> {
            Color colorResult = this.colorChecker.getColor();
            if (colorResult == null) {
                return false;
            }
            return colorResult == this.color;
        };

        addCommands(new RunUntil(new StartPanelMotor(this.motor), isDone), new StopPanelMotor(this.motor));
    }

    /**
     * @param color A string representation of the color that needs to be spinned to
     */
    public SpinToColor(Color color) {
        super();
        this.motor = RobotMap.Component.controlPanel;
        this.color = color;

        addRequirements(this.motor);

        Supplier<Boolean> isDone = () -> {
            Color colorResult = this.colorChecker.getColor();
            if (colorResult == null) {
                return false;
            }
            return colorResult == this.color;
        };

        addCommands(new RunUntil(new StartPanelMotor(this.motor), isDone), new StopPanelMotor(this.motor));
    }
}
