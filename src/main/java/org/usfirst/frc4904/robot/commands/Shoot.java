package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Shooter;
import org.usfirst.frc4904.robot.subsystems.Flywheel.FlywheelStatus;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class Shoot extends CommandBase {
    protected final Shooter shooter;

    public Shoot(Shooter shooter) {
        setName("Shoot");
        this.shooter = shooter;
    }

    public void onInitialize() {
        if (shooter.getFlywheelStatus() == FlywheelStatus.IDLE) {
            // shooter.flywheel.FlywheelSpinUp()
        }
        else if (shooter.getFlywheelStatus().toString() == "SPINNING_UP") {
        }

        else if (shooter.getFlywheelStatus().toString() == "AT_SPEED") {
        }
        
    }
}