/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.robot;

import org.usfirst.frc4904.robot.humaninterface.drivers.NathanGain;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.commands.chassis.ChassisMove;

public class Robot extends CommandRobotBase {
    private RobotMap map = new RobotMap();

    @Override
    public void initialize() {
        driverChooser.setDefaultOption(new NathanGain());
    }

    @Override
    public void teleopInitialize() {
        teleopCommand = new ChassisMove(RobotMap.Component.chassisShifters, driverChooser.getSelected());
        teleopCommand.schedule();
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
