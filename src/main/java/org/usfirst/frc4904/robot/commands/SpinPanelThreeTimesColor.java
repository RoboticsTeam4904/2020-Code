// package org.usfirst.frc4904.robot.commands;

// import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;

// import org.usfirst.frc4904.standard.commands.WaitUntil;
// import org.usfirst.frc4904.standard.subsystems.motor.Motor;
// import org.usfirst.frc4904.robot.RobotMap;
// import org.usfirst.frc4904.robot.RobotMap.NetworkTables;

// import java.util.function.Supplier;

// import com.ctre.phoenix.sensors.CANCoder;

// import org.usfirst.frc4904.robot.commands.StartPanelMotor;
// import org.usfirst.frc4904.robot.commands.StopPanelMotor;

// import edu.wpi.first.networktables.NetworkTable;
// import edu.wpi.first.networktables.NetworkTableEntry;
// import edu.wpi.first.networktables.NetworkTableInstance;

// public class SpinPanelThreeTimesColor extends SequentialCommandGroup {

//     private final Motor motor;
//     private final Color[] colorOrder = new Color[]{Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN};

//     private final int[] RED = new int[]{255, 0, 0};
//     private final int[] YELLOW = new int[]{255, 255, 0};
//     private final int[] BLUE = new int[]{0, 0, 255};
//     private final int[] GREEN = new int[]{0, 255, 0};
    

//     private Color currentColor;
//     private Color initialColor;
//     private int orderWeAreOn = 0; //this is the order of the array that we are currently on
//     private NetworkTableInstance inst = NetworkTableInstance.getDefault();
//     private NetworkTable table = inst.getTable("controlPanelColor"); // TODO: get the actual name of the data table 

//     /**
//      * This command should detect the color using NetworkTables when being spun to
//      * determine the degrees spun by the robot. -- How can we use colors to detect
//      * the position of the control panel??? Well, we know that the control panel
//      * follows this set of colors: red, yellow, blue, green, red, yellow, blue,
//      * green (red, yellow, blue, green twice). Since there are 8 "slices," each
//      * slice makes up 45 degrees of the control panel wheel Since the pattern has
//      * two of each color, with the colors being 180 degrees apart, we know once we
//      * have seen our initial color again, we have circulated the control panel once.
//      * If we see the initial color twice, we have gone 360 degrees. --
//      * 
//      * @param motor The motor to spin the control panel.
//      */

//     public SpinPanelThreeTimesColor(Motor motor, NetworkTables networkTable) {
//         super();
//         this.motor = motor;
//         addRequirements(this.motor);
//         setName("SpinPanelThreeTimesColor");

//     }
//     // TODO: compare the current color to the color detected and add to the 
//     public void checkColorOrder(){
//         if(currentColor == relativeColorDetection(detectColor())){
//             //still on the same color
            
//         }else{
//             //different color!
//             currentColor = relativeColorDetection(detectColor());
//             if(currentColor == colorOrder[(orderWeAreOn + 1)%3]){
//                 //On correct trajectory!
//                 if(orderWeAreOn == 23){
//                     //it has traveled 3 times around
//                     //TODO: call stop method
//                 }
//             }else{
//                 //We skipped one!
//                 for(int i = 0; i < 4; i++){


//                 }
//             }
//         }
//     }
//     //TODO: taking the color we get from the camera and converting to what it probably is
//     public Color relativeColorDetection(Color color){
//         return color;
//     }
//     // TODO: Use the NetworkTables to determine color switches
//     public Color detectColor() {
        
//         return color;
//     }
    

//     @Override
//     public void initialize() {
//         super.initialize();
//     }

//     enum Color {
//         RED, YELLOW, BLUE, GREEN;
//     }

// }