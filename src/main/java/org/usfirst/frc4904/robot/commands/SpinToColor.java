package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

import java.util.function.Supplier;

import org.usfirst.frc4904.robot.commands.StartPanelMotor;
import org.usfirst.frc4904.robot.commands.StopPanelMotor;

public class SpinToColor extends SequentialCommandGroup {
    private final Motor motor;
    private final ColorSensor.Color color;
    private ColorSensor colorSensor;

    /**
     * @param motor The motor to spin the control panel.
     * @param color A string representation of the color that needs to be spinned to
     */
    public SpinToColor(Motor motor, ColorSensor.Color color) {
        super();
        this.motor = motor;
        this.color = color;

        addRequirements(this.motor);

        Supplier<Boolean> isDone = () -> {
            ColorSensor.Color colorResult = colorSensor.colorClassifier(colorSensor.detectColor());
            if (colorResult == null) {
                return false;
            }
            return colorResult == this.color;
        };

        addCommands(new RunUntil(new StartPanelMotor(this.motor), isDone), new StopPanelMotor(this.motor));
    }
}
