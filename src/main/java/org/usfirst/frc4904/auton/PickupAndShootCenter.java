package org.usfirst.frc4904.auton;

import java.util.Arrays;

import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;
import org.usfirst.frc4904.standard.subsystems.chassis.SensorDrive;

import edu.wpi.first.wpilibj.trajectory.Trajectory;
import edu.wpi.first.wpilibj.trajectory.Trajectory.State;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandGroupBase;

class PickupAndShootCenter extends CommandGroupBase {

    @Override
    public void addCommands(Command... commands) {
        State s = new State(0, 0, 0, Poses.shootingPose, 0);
        Trajectory goingToPowerCells = new Trajectory(Arrays.asList(s));
        // TODO: we dont have a sensordrive in robotmap yet
        SimpleSplines splines = new SimpleSplines(null, goingToPowerCells);
        this.andThen(splines);
    }

}