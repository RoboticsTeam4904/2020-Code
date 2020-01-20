# Indexer Notes

flippers: one solenoid, extend = block

during intake: run intake roller, funnel motor, belt motor (constant voltage)
motors:  one solenoid intake, one for intake, one funnel motor, one belt motor (all talon srx w/o encoder)

on shoot: flip up flippers, run flywheel, runup belts (one motor, constant rpm)
motors: one solenoid for flippers, one motor for flywheel (falcon), one motor for runup belts (775 w/ can coder)

# Requirements

This branch is in charge of writing the indexer class, which includes the flipper solenoid and the run up belt (a 775 with a can coder).

The class should implement the `reset()` and `indexOne()` methods.

The `reset` method should flip down the flippers and stop the run up belt.

The `indexOne()` method should open the flippers (regardless of the flywheel speed as the encapsulating command should check that) and run the run up belt until a ball reaches the flywheel and is launched. Then close the flippers.
