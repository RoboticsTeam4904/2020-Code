package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Intake;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

public class RunIntake extends ParallelCommandGroup {
  /**
   * Run the intake
   * 
   * @param intake The intake to manipulate
   * @param speed  The speed to intake at
   */
  public RunIntake(Intake intake, double speed) {
    super(new MotorConstant(intake.intake, speed), new MotorConstant(intake.funnel, speed),
        new MotorConstant(intake.lift, speed));

  }

  /**
   * Run the intake
   * 
   * @param intake The intake to manipulate
   */
  public RunIntake(Intake intake) {
    super(new MotorConstant(intake.intake, Intake.DEFAULT_INTAKE_SPEED),
        new MotorConstant(intake.funnel, Intake.DEFAULT_FUNNEL_SPEED),
        new MotorConstant(intake.lift, Intake.DEFAULT_LIFT_SPEED));
  }
}
