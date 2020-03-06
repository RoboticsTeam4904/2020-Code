/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.robot.humaninterface.operators.DefaultOperator;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;
import org.usfirst.frc4904.standard.commands.chassis.ChassisTurn;

import edu.wpi.first.wpilibj.geometry.Pose2d;

public class Robot extends CommandRobotBase {
    private RobotMap map = new RobotMap();

    @Override
    public void initialize() {
        driverChooser.setDefaultOption(new NathanGain());
        operatorChooser.setDefaultOption(new DefaultOperator());
        RobotMap.Component.sensorDrive.resetOdometry(new Pose2d());
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
        RobotMap.Component.sensorDrive.resetOdometry(new Pose2d());
        ChassisTurn turn = new ChassisTurn(RobotMap.Component.chassis, 90, RobotMap.Component.navx, RobotMap.Component.chassisTurnPID);
        turn.schedule();
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
        Pose2d deadReckoningPose = RobotMap.Component.sensorDrive.getPose();
        RobotMap.NetworkTables.Odometry.odometryXEntry.setDouble(deadReckoningPose.getTranslation().getX());
        RobotMap.NetworkTables.Odometry.odometryYEntry.setDouble(deadReckoningPose.getTranslation().getY());
        RobotMap.NetworkTables.Odometry.odometryAngleEntry.setDouble(RobotMap.Component.sensorDrive.pidGet() * (Math.PI / 180.0));
    }

}
