package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.subsystems.Intake;
import org.usfirst.frc4904.standard.commands.motor.MotorConstant;

import edu.wpi.first.wpilibj2.command.ParallelCommandGroup;

public class RunIntake extends ParallelCommandGroup {
  /**
   * Run the intake
   */
  public RunIntake() {
    super(new MotorConstant(RobotMap.Component.intake.intake, Intake.DEFAULT_INTAKE_SPEED),
        new MotorConstant(RobotMap.Component.intake.funnel, Intake.DEFAULT_FUNNEL_SPEED),
        new MotorConstant(RobotMap.Component.intake.lift, Intake.DEFAULT_LIFT_SPEED));

  }
}
