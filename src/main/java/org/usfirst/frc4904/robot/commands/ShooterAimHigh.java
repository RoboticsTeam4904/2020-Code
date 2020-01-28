package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class ShooterAimHigh extends CommandBase{
    protected final Shooter shooter;

    /**extending the aiming soleniod to shoot high
     * 
     * @param shooter 
     */
    public ShooterAimHigh(Shooter shooter){
        super();
        setName("ShooterAimHigh");
        addRequirements(shooter.aimSolenoid);
        this.shooter = shooter;
    }


public void onInitialize(){
    shooter.setSolenoidHigh();
}
}