package org.usfirst.frc4904.robot.commands.controlpanel;

import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

import java.util.function.Supplier;

import org.usfirst.frc4904.robot.commands.controlpanel.StartPanelMotor;
import org.usfirst.frc4904.robot.commands.controlpanel.StopPanelMotor;

public class SpinToColor extends ColorSensor {
    private final Motor motor;
    private final Color color;

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
            Color colorResult = super.getColor();
            if (colorResult == null) {
                return false;
            }
            return colorResult == this.color;
        };

        addCommands(new RunUntil(new StartPanelMotor(this.motor), isDone), new StopPanelMotor(this.motor));
    }
}
