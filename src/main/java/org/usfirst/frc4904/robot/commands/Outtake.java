package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.subsystems.Intake;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

public class Outtake extends ParallelCommandGroup {
  /**
   * Reverses the intake.
   * 
   * @param intake The intake to manipulate
   */
  Outtake(Intake intake) {
    super(new MotorConstant("Outtake: Rollers", intake.intake, Intake.DEFAULT_OUTTAKE_SPEED),
        new MotorConstant("Outtake: Funnel", intake.funnel, Intake.DEFAULT_FUNNEL_REVERSE_SPEED));
  }
}