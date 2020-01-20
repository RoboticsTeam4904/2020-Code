package org.usfirst.frc4904.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

/**
 * TODO Summary
 * 
 * This branch is supposed to be put together once we have both the flywheel and
 * indexer subsystems in place. It will contain commands to:
 * - [ ] Spin up the flywheel to a speed
 * - [ ] Spin up the flywheel for a distance
 * - [ ] Spin up the flywheel for a generic box shot (while touching the base of the box)
 * - [ ] Index and shoot one ball (this file) (checking that the flywheel is at speed before shooting)
 * 
 * Other TODOs: 
 * - add everything for the indexer, index solenoid, and flywheel to robotmap
 * - bind the commands for the shooting routines in humaninterface
 * - have a button for spinning up the flywheel and a button for shooting once (aka calling this command)
 * package org.usfirst.frc4904.robot.commands;

/**
 * previous TODO Summary - may be outdated
 * [x] `getStaus()`: check if rpm is below target (public) used by indexer 
 * [ ] controlled by operator joystick
 * [ ] commands: 
 *    [ ] setSpeedForDistance - activated when joystick hits a button, 
 *    [ ] shooterBoxShot
 *    [ ] shooterSetSpeed
 * [ ] humaninterface/operator binds commands to right joystick
 * [ ] robotmap needs ports for solenoid and motor
 * [ ] robotmap should run constructor for flywheel
 * [ ] might need a perodic method or something
 */

public class Shoot extends CommandBase {
  Shoot(String name, )
}