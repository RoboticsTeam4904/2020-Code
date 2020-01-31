/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.standard.CommandRobotBase;

public class Robot extends CommandRobotBase {
    private RobotMap map = new RobotMap();

    @Override
    public void initialize() {
    }

    @Override
    public void teleopInitialize() {
<<<<<<< HEAD
        teleopCommand = new ChassisMove(RobotMap.Component.chassis, driverChooser.getSelected());
=======
>>>>>>> a59165430113b61a0451c6f1052141f0ab7ff199
    }

    @Override
    public void teleopExecute() {
    }

    @Override
    public void autonomousInitialize() {
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

    }

}
