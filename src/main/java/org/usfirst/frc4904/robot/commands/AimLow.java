package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AimLow extends CommandBase{
    protected final Shooter aimer;

    /**extending the aiming soleniod to shoot high
     * 
     * @param aimer 
     */
    public AimLow(Shooter aimer){
        super();
        setName("AimLow");
        addRequirements(aimer.aimSolenoid);
        this.aimer = aimer;
    }


public void onInitialize(){
    aimer.setSolenoidLow();
}
}