package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.standard.commands.solenoid.SolenoidExtend;
/**
* This command will retract the piston when we want to shoot a ball
* The inverse command (ExtendPiston) must be called before it can be called again
* (Because pistons go up and down, and they can't go up twice or down twice)
*
 */

public class RetractPiston extends SolenoidRetract {

    public RetractPiston(SolenoidSubsystem piston){
        

    }
}