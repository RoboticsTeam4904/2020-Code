package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Intake;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

public class Outtake extends ParallelCommandGroup {
  /**
   * Reverses the intake.
   */
  public Outtake() {
    super(new MotorConstant("Outtake: Rollers", RobotMap.Component.intake.intake, Intake.DEFAULT_OUTTAKE_SPEED),
        new MotorConstant("Outtake: Funnel", RobotMap.Component.intake.funnel, Intake.DEFAULT_FUNNEL_REVERSE_SPEED));
  }
}