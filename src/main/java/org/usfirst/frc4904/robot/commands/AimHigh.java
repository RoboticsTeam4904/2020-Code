package org.usfirst.frc4904.robot.commands;


import org.usfirst.frc4904.robot.subsystems.Shooter;
import edu.wpi.first.wpilibj2.command.CommandBase;

public class AimHigh extends CommandBase{
    protected final Shooter aimer;

    /**extending the aiming soleniod to shoot high
     * 
     * @param aimer 
     */
    public AimHigh(Shooter aimer){
        super();
        setName("AimHigh");
        addRequirements(aimer.solenoidSubsystem);
        this.aimer = aimer;
    }


public void onInitialize(){
    aimer.setSolenoidHigh();
}
}