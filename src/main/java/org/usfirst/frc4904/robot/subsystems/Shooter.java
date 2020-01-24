package org.usfirst.frc4904.robot.subsystems;	

import edu.wpi.first.wpilibj2.command.SubsystemBase;	
import org.usfirst.frc4904.robot.subsystems.Flywheel;	
import org.usfirst.frc4904.robot.subsystems.Flywheel.FlywheelStatus;	
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem;	
import org.usfirst.frc4904.standard.subsystems.SolenoidSubsystem.SolenoidState;	

/**	
 * TODO Summary	
 * [x] `getStaus()`: check if rpm is below target (public) used by indexer 	
 * [ ] controlled by operator joystick	
 * [ ] commands: 	
 *    [ ] setspeedBasedOnDistance - activated when joystick hits a button, 	
 *    [ ] setRpmBoxShot	
 *    [ ] setPistonHigh	
 *    [ ] setPistonLow	
 *    [ ] humaninterface/operator binds commands to right joystick	
 * [ ] robotmap needs ports for solenoid and motor	
 * [ ] robotmap should run constructor for flywheel	
 * [ ] might need a perodic method or something	
 */	

public class Shooter extends SubsystemBase {	
  protected final Flywheel flywheel;	
  protected final SolenoidSubsystem solenoidSubsystem;	

  /**	
   * Shooter	
   * 	
   * Wraps a Flywheel and a SolenoidSubsystem together for the shooter on 4904's	
   * 2020 robot	
   * 	
   * @param name              The FlywheelSubsystem name	
   * @param flywheel          The actual flywheel for this subsystem	
   * @param solenoidSubsystem The SolenoidSubsystem for aiming the shooter	
   */	
  Shooter(String name, Flywheel flywheel, SolenoidSubsystem solenoidSubsystem) {	
    super();	
    setName(name);	
    this.flywheel = flywheel;	
    this.solenoidSubsystem = solenoidSubsystem;	
  }	

  /**	
   * Shooter	
   * 	
   * Wraps a Flywheel and a SolenoidSubsystem together for the shooter on 4904's	
   * 2020 robot	
   * 	
   * @param flywheel          The actual flywheel for this subsystem	
   * @param solenoidSubsystem The SolenoidSubsystem for aiming the shooter	
   */	
  Shooter(Flywheel flywheel, SolenoidSubsystem solenoidSubsystem) {	
    this("Shooter", flywheel, solenoidSubsystem);	
  }	

  public SolenoidState getSolenoidState() {	
    return solenoidSubsystem.getState();	
  }	

  public void setSolenoidHigh() {	
    solenoidSubsystem.set(SolenoidState.EXTEND);	
  }	

  public void setSolenoidLow() {	
    solenoidSubsystem.set(SolenoidState.RETRACT);	
  }	

  public FlywheelStatus getFlywheelStatus() {	
    return flywheel.getStatus();	
  }	

  public double getFlywheelSpeed() {	
    return flywheel.getSpeed();	
  }	

  public double getFlywheelTargetSpeed() {	
    return flywheel.getTargetSpeed();	
  }	

  public void setFlywheelSpeed(double speed) {	
    flywheel.setSpeed(speed);	
  }	

  public void setFlywheelSpeedForDistance(double distance) {	
    flywheel.setSpeedForDistance(distance);	
  }	
}