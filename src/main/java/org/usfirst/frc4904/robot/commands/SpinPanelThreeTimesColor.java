package org.usfirst.frc4904.robot.commands;

import org.usfirst.frc4904.standard.commands.RunUntil;
import org.usfirst.frc4904.standard.subsystems.motor.Motor;
import org.usfirst.frc4904.robot.RobotMap;
import org.usfirst.frc4904.robot.RobotMap.NetworkTables;

import java.util.function.Supplier;

import com.ctre.phoenix.sensors.CANCoder;

import org.usfirst.frc4904.robot.commands.StartPanelMotor;
import org.usfirst.frc4904.robot.commands.StopPanelMotor;

import edu.wpi.first.networktables.NetworkTable;
import edu.wpi.first.networktables.NetworkTableEntry;
import edu.wpi.first.networktables.NetworkTableInstance;

public class SpinPanelThreeTimesColor extends ColorSensor {

    private final Motor motor;
    

    private ColorSensor.Color currentColor;
    private ColorSensor.Color initialColor;
    private int orderWeAreOn = 0; //this is the order of the array that we are currently on
    private NetworkTableInstance inst = NetworkTableInstance.getDefault();
    private NetworkTable table = NetworkTables.inst.getTable("sensorData");; // TODO: get the actual name of the data table 

    /**
     * This command should detect the color using NetworkTables when being spun to
     * determine the degrees spun by the robot. -- How can we use colors to detect
     * the position of the control panel??? Well, we know that the control panel
     * follows this set of colors: red, yellow, blue, green, red, yellow, blue,
     * green (red, yellow, blue, green twice). Since there are 8 "slices," each
     * slice makes up 45 degrees of the control panel wheel Since the pattern has
     * two of each color, with the colors being 180 degrees apart, we know once we
     * have seen our initial color again, we have circulated the control panel once.
     * If we see the initial color twice, we have gone 360 degrees. --
     * 
     * @param motor The motor to spin the control panel.
     */

    public SpinPanelThreeTimesColor(Motor motor, NetworkTables networkTable) {
        super();
        this.motor = motor;
        addRequirements(this.motor);
        setName("SpinPanelThreeTimesColor");
        Supplier<Boolean> isDone = () -> {return checkColorOrder();};
        addCommands(new RunUntil(new StartPanelMotor(this.motor), isDone), new StopPanelMotor());
    }
    @Override
    public void initialize() {
         super.initialize();
         StartPanelMotor startPanelMotor = new StartPanelMotor();
         startPanelMotor.schedule();
     }
 }
 