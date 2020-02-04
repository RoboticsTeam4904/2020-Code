package org.usfirst.frc4904.robot.commands.controlpanel;

import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.commands.controlpanel.StartPanelMotor;
import org.usfirst.frc4904.robot.commands.controlpanel.StopPanelMotor;
import java.util.function.Supplier;
import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.robot.RobotMap;

public class SpinPanelThreeTimesColor extends ColorSensor {

    private final Motor motor;

    /**
     * This command will spin the control panel three times based off the camera
     * feed.
     * 
     * @param motor The motor to spin the control panel.
     */

    public SpinPanelThreeTimesColor(String name) {
        super();
        this.motor = RobotMap.Component.controlPanel;
        addRequirements(this.motor);
        setName(name);

        Supplier<Boolean> isDone = () -> {
            trackColorChange();
            return doneSpinning;
        };

        addCommands(new RunUntil(new StartPanelMotor(this.motor), isDone), new StopPanelMotor(this.motor));

    }

    public SpinPanelThreeTimesColor() {
        this("SpinPanelThreeTimesColor");
    }
}
