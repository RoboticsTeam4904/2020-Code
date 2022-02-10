package org.usfirst.frc4904.auton;

import java.util.ArrayList;

import org.usfirst.frc4904.standard.commands.chassis.SimpleSplines;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

public class AutonRoutine extends SequentialCommandGroup {
    public ArrayList<Command> commandsList;

    @Override
    public SequentialCommandGroup andThen(Command... commands) {
        SequentialCommandGroup group = super.andThen(commands);
        for (Command command : commands) {
            commandsList.add(command);
        }
        return group;
    }

    public ArrayList<Command> getCommandsList() {
        return commandsList;
    }

    /**
     * Used for the spline visualizer.
     * 
     * @return List of all commands with trajectories
     */
    public ArrayList<Command> getSplinesList() {
        ArrayList<Command> splinesCommands = new ArrayList<Command>();
        for (Command command : commandsList) {
            if (command instanceof SimpleSplines) {
                splinesCommands.add(command);
            }
        }
        return splinesCommands;
    }
}