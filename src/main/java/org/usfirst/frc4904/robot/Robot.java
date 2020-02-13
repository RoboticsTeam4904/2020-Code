/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc4904.robot;

import java.io.FileWriter;
import java.io.IOException; // Import the IOException class to handle errors

import org.usfirst.frc4904.robot.commands.FlywheelSpinUp;
import org.usfirst.frc4904.robot.subsystems.Flywheel;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.LogKitten;

public class Robot extends CommandRobotBase {
    private RobotMap map = new RobotMap();

    @Override
    public void initialize() {
    }

    @Override
    public void teleopInitialize() {
    }

    @Override
    public void teleopExecute() {
    }

    @Override
    public void autonomousInitialize() {
        Flywheel flywheel = RobotMap.Component.flywheel;
        FlywheelSpinUp spinUp = new FlywheelSpinUp(flywheel, 0.8);
        spinUp.schedule();
    }

    @Override
    public void autonomousExecute() {
        double speed = RobotMap.Component.flywheel.getSpeed();
        try {
            FileWriter myWriter = new FileWriter("filename.txt");
            myWriter.write(Double.toString(speed));
            myWriter.close();
        } catch (IOException e) {
            LogKitten.wtf("file err");
        }

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
