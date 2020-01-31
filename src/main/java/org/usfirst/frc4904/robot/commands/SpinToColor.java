package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.standard.LogKitten;

import java.util.function.Supplier;

import org.usfirst.frc4904.robot.commands.StartPanelMotor;
import org.usfirst.frc4904.robot.commands.StopPanelMotor;
import org.usfirst.frc4904.robot.RobotMap.NetworkTables;;

public class SpinToColor extends SequentialCommandGroup {
    private final Motor motor;
    private final String color;

    /**
     * @param motor The motor to spin the control panel.
     */
    public SpinToColor(Motor motor, String color) {
        super();
        this.motor = motor;
        this.color = color;

        addRequirements(this.motor);

        Supplier<Boolean> isDone = () -> {
            String colorResult = NetworkTables.Sensors.controlPanelColor.getString(null);
            if (colorResult == null) {
                LogKitten.wtf("Cannot read control panel color");
                return true;
            } 
            return NetworkTables.Sensors.controlPanelColor.getString(null) == this.color;  
        };

        addCommands(new RunUntil(new StartPanelMotor(this.motor), isDone), new StopPanelMotor(this.motor));
    }
}
