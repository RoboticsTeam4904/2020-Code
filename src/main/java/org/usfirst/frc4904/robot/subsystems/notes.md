# Requirements

This branch is in charge of implementing the intake class, which includes the three talon srx's: one for the intake, one for the funnel, and one for the belts. It also needs to control the intake solenoid.

The class should implement the `run(double speed)` and `setSolenoidState(ON/OFF)` methods.

The `run` method should run all motors at a constant voltage in the proper direction.

The `setSolenoidState` method should flip the intake rollers either in or out, depending on the arguments it recieves.

It should also include getters so commands can read the state of the intake subsystem.
