package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Intake;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

public class RunIntake extends MotorConstant {
  /**
   * Run the intake
   * 
   * @param intake The intake to manipulate
   * @param speed  The speed to intake at
   */
<<<<<<< HEAD
  public RunIntake(Intake intake) {
    super();
    setName("RunIntake");
    addRequirements(intake.intake);
    this.intake = intake;
=======
  RunIntake(Intake intake, double speed) {
    super("RunIntake", intake.intake, speed);
>>>>>>> origin/shooter-commands
  }

  /**
   * Run the intake
   * 
   * @param intake The intake to manipulate
   */
  RunIntake(Intake intake) {
    super("RunIntake", intake.intake, Intake.DEFAULT_INTAKE_SPEED);
  }
}