/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.robot;

import java.util.List;

import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;

import edu.wpi.first.wpilibj.geometry.Pose2d;
import edu.wpi.first.wpilibj.geometry.Rotation2d;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.util.Units;
import edu.wpi.first.wpilibj2.command.Command;

public class Robot extends CommandRobotBase {
    private RobotMap map = new RobotMap();

    @Override
    public void initialize() {
        driverChooser.setDefaultOption(new NathanGain());
        operatorChooser.setDefaultOption(new DefaultOperator());
    }

    @Override
    public void teleopInitialize() {
        teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
    }

    @Override
    public void teleopExecute() {
    }

    @Override
    public void autonomousInitialize() {
        // RobotMap.Component.navx.zeroYaw();
        // Trajectory traj = RobotMap.Component.nikhilChassis.generateSimpleTrajectory(
        //     new Pose2d(0, 0, Rotation2d.fromDegrees(0)),
        //     List.of(),
        //     // new Pose2d(1, 0, Rotation2d.fromDegrees(0)),
        //     new Pose2d(Units.feetToMeters(3), Units.feetToMeters(-3), Rotation2d.fromDegrees(0)));
        // // Command sendSplines = new SendSplines(traj);
        // // sendSplines.schedule();
        // Command autoCommand = new SimpleSplines(RobotMap.Component.nikhilChassis, traj);
        // if (autoCommand != null) {
        //     autoCommand.schedule();
        // }
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
        SmartDashboard.putNumber("Flywheel", RobotMap.Component.flywheelEncoderB.getRate());
        SmartDashboard.putBoolean("Within", Math.abs(RobotMap.Component.flywheel.getVelocity() - 58.0) < 10.0 || RobotMap.Component.flywheel.getVelocity() > 58.0);
        // LogKitten.wtf("Left Encoder Distance" + RobotMap.Component.rightWheelEncoder.pidGet());
        // SmartDashboard.putNumber("Right Encoder Distance", RobotMap.Component.rightWheelEncoder.pidGet());
        // LogKitten.wtf("Hood limit " + RobotMap.Input.hoodLimitSwitch.get());
        SmartDashboard.putBoolean("Hood Limit", RobotMap.Input.hoodLimitSwitch.get());
        SmartDashboard.putNumber("Hood Position", RobotMap.Component.hoodEncoder.getDistance());
        SmartDashboard.putNumber("Hood Conversion", RobotMap.Metrics.Hood.HOOD_ANGLE_PER_TICK);
        SmartDashboard.putNumber("Left Encoder", RobotMap.Component.leftWheelEncoder.getDistance());
        SmartDashboard.putNumber("Right Encoder", RobotMap.Component.rightWheelEncoder.getDistance());
        SmartDashboard.putNumber("Yaw", RobotMap.Component.navx.getYaw());
    }

}
