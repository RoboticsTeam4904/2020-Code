/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved. */
/* Open Source Software - may be modified and shared by FRC teams. The code */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project. */
/*----------------------------------------------------------------------------*/
package org.usfirst.frc4904.robot;

// import org.usfirst.frc4904.robot.commands.setLeds;
import org.usfirst.frc4904.standard.CommandRobotBase;
import org.usfirst.frc4904.standard.LogKitten;
import org.usfirst.frc4904.standard.custom.CustomCAN;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class Robot extends CommandRobotBase {
    private RobotMap map = new RobotMap();
    CustomCAN can = new CustomCAN("ree", 0x612);

    byte[] arr1 = new byte[] { 1, 0, 0, 0, 0, 0, 0, 0 };
    // arr2 needs to be red color, I set it to 255
    byte[] arr2 = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 };
    // arr3 needs to be blue color, I set it to 255
    byte[] arr3 = new byte[] { 1, 1, 1, 1, 1, 1, 1, 1 };
    // arr4 needs to be green color, I set it to 255
    byte[] arr4 = new byte[] { 1, 1, 1, 1, 1, 1, 1, 1 };
    // arr5 through arr8 need to be all 0
    byte[] arr5 = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 };
    byte[] arr6 = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 };
    byte[] arr7 = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 };
    byte[] arr8 = new byte[] { 0, 0, 0, 0, 0, 0, 0, 0 };
    byte[][] fullBytes = new byte[][] { arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8 };

    @Override
    public void initialize() {
        // setLeds l = new setLeds("leo is gamer", RobotMap.Port.CAN.LED);
    }

    @Override
    public void teleopInitialize() {
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
        for (int i = 0; i < fullBytes.length; i++) {
            can.write(fullBytes[i]);
            LogKitten.wtf(fullBytes[i]);
        }
    }

}
