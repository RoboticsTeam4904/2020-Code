package org.usfirst.frc4904.robot.commands.controlpanel;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;

import java.util.function.Supplier;

import com.ctre.phoenix.sensors.CANCoder;

import org.usfirst.frc4904.robot.commands.controlpanel.StartPanelMotor;
import org.usfirst.frc4904.robot.commands.controlpanel.StopPanelMotor;

public class SpinPanelThreeTimes extends SequentialCommandGroup {
    private final double SPEED = -1.0;
    private final double CONTROL_PANEL_DIAMETER = -1.0;
    private final double PANEL_SPINNER_DIAMETER = -1.0;
    private final double PANEL_SPINNER_RATIO = CONTROL_PANEL_DIAMETER / PANEL_SPINNER_DIAMETER;
    private final double DEGREES_IN_A_CIRCLE = 360.0;
    private final double TOTAL_REVOLUTIONS = 3.0;

    private final Motor motor;
    private final CANCoder encoder;

    private double distance = 0;
    private double initialRelativeDistance = 0;
    private double relativeDistance = 0;
    private int revolutions = 0;

    /**
     * @param motor The motor to spin the control panel.
     */
    public SpinPanelThreeTimes(CANCoder encoder, Motor motor) {
        super();
        this.motor = motor;
        this.encoder = encoder;

        addRequirements(this.motor);

        Supplier<Boolean> isDone = () -> {
            double tempRelativeDistance = encoder.getPosition();
            if (tempRelativeDistance < this.relativeDistance) {
                this.revolutions += 1;
            }
            this.relativeDistance = tempRelativeDistance;

            double totalDistance = (this.revolutions * 360) + this.relativeDistance - this.initialRelativeDistance;

            return totalDistance >= (TOTAL_REVOLUTIONS * DEGREES_IN_A_CIRCLE) / PANEL_SPINNER_RATIO;
        };

        addCommands(new RunUntil(new StartPanelMotor(this.motor), isDone), new StopPanelMotor(this.motor));

    }

    @Override
    public void initialize() {
        this.initialRelativeDistance = this.encoder.getPosition();

        super.initialize();
    }
}
