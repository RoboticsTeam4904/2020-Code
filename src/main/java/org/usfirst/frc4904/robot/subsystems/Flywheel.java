package org.usfirst.frc4904.robot.subsystems;

/**
 * pid 
 * calculate rpm based on distance method
 * pid loop that spins flywheel to that rpm
 * method check if rpm is below target (public) used by indexer
 * controlled by operator joystick
 * commands: 
 *    setspeedBasedOnDistance - activated when joystick hits a button, 
 *    setRpmBoxShot
 *    setPistonHigh
 *    setPistonLow
 *    humaninterface/operator binds commands to right joystick
 * robotmap needs ports for solenoid and motor
 * robotmap should run constructor for flywheel
 * might need a perodic method or something
 */
public class Flywheel extends 