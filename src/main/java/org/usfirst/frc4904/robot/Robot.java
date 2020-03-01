/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.robot.commands.FlywheelSpinUp;
import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class Robot extends CommandRobotBase {
    private RobotMap map = new RobotMap();

    @Override
    public void initialize() {
        driverChooser.setDefaultOption(new NathanGain());
        operatorChooser.setDefaultOption(new DefaultOperator());
        SmartDashboard.putNumber("P", 0);
        SmartDashboard.putNumber("I", 0);
        SmartDashboard.putNumber("D", 0);
        SmartDashboard.putNumber("F", 0);
        SmartDashboard.putNumber("Setpoint", 0);
        // RobotMap.Component.sensorDrive.resetOdometry(new Pose2d());
        operatorChooser.setDefaultOption(new DefaultOperator());
    }

    @Override
    public void teleopInitialize() {
        teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
        // RobotMap.Component.flywheelPIDController.setPIDF(SmartDashboard.getNumber("P", 0),
        //         SmartDashboard.getNumber("I", 0), SmartDashboard.getNumber("D", 0), SmartDashboard.getNumber("F", 0));
        // FlywheelSpinUp f = new FlywheelSpinUp(SmartDashboard.getNumber("Setpoint", 0));
        // f.schedule();
    }

    @Override
    public void teleopExecute() {
    }

    @Override
    public void autonomousInitialize() {
        // RobotMap.Component.sensorDrive.resetOdometry(new Pose2d());
    }

    @Override
    public void autonomousExecute() {
    }

    @Override
    public void disabledInitialize() {
    }

    @Override
    public void disabledExecute() {
    }

    @Override
    public void testInitialize() {
    }

    @Override
    public void testExecute() {
    }

    @Override
    public void alwaysExecute() {
        // SmartDashboard.putNumber("Flywheel RPS", RobotMap.Component.flywheelEncoder.getRate());
        // Pose2d deadReckoningPose = RobotMap.Component.sensorDrive.getPose();
        // RobotMap.Network.odometryXEntry.setDouble(deadReckoningPose.getTranslation().getX());
        // RobotMap.Network.odometryYEntry.setDouble(deadReckoningPose.getTranslation().getY());
        // RobotMap.Network.odometryAngleEntry.setDouble(deadReckoningPose.getRotation().getRadians());
    }

}
