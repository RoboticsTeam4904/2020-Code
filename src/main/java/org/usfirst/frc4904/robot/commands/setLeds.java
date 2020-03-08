// package org.usfirst.frc4904.robot;
// package org.usfirst.frc4904.standard.custom;
// import edu.wpi.first.hal.can.CANJNI
// import 
import org.usfirst.frc4904.standard.custom.CustomCAN;

import edu.wpi.first.wpilibj2.command.CommandBase;

public class SetLeds extends CommandBase {
    public SetLeds(String name, int id) {
        // Setting bits in Java for the leds on the robot
        byte[] arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8;
        byte[][] fullBytes;
        
        //first array tells us if there is a custom color, they are ready to shoot, in shooting zone, and the alliance color
        //second through fourth are the amounts of red, blue, and green respectively
        //the rest of the arrays need to be all 0
        fullBytes = new byte[][]{
            new byte[]{0,0,0,0,0,0,0,0}, 
            new byte[]{1,1,1,1,1,1,1,1},
            new byte[]{1,1,1,1,1,1,1,1},
            new byte[]{1,1,1,1,1,1,1,1},
            new byte[]{0,0,0,0,0,0,0,0},
            new byte[]{0,0,0,0,0,0,0,0},
            new byte[]{0,0,0,0,0,0,0,0},
            new byte[]{0,0,0,0,0,0,0,0},
        };
   }

   public void send(byte[][] fullBytes) {
        // byte[] arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8 = fullBytes;
        // First bit of arr1 determines if there is a custom color
        int customColor = fullBytes[0][0];
        if (customColor == 0) {
            fullBytes[1] = new byte[]{0,0,0,0,0,0,0,0};
            fullBytes[2] = new byte[]{0,0,0,0,0,0,0,0};
            fullBytes[3] = new byte[]{0,0,0,0,0,0,0,0};
        }
        
        //send data using FRCNetCommCANSessionMuxSendMessage​
        //use https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/hal/can/CANJNI.html#FRCNetCommCANSessionMuxSendMessage(int,byte%5B%5D,int) in the future
        CustomCAN can = new CustomCAN(name, id);
        for(int i = 0; i<fullBytes.length;i++){
            can.write(fullBytes[i]);
        }
   }
} 