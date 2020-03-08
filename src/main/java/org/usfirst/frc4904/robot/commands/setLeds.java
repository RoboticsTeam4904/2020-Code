// package org.usfirst.frc4904.robot;
// package org.usfirst.frc4904.standard.custom;
// import edu.wpi.first.hal.can.CANJNI
// import 
import org.usfirst.frc4904.standard.custom.CustomCAN;


public class setLeds{


    // Setting bits in Java for the leds on the robot
    static byte[] arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8;
    static byte[][] fullBytes = {arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8};

    public setLeds(String name, int id) {
        //arr1 needs to tell us if there is a custom color, they are ready to shoot, in shooting zone, and the alliance color
        arr1 = new byte[]{0,0,0,0,0,0,0,0};
        //arr2 needs to be red color, I set it to 255
        arr2 = new byte[]{1,1,1,1,1,1,1,1};
        //arr3 needs to be blue color, I set it to 255
        arr2 = new byte[]{1,1,1,1,1,1,1,1};
        //arr4 needs to be green color, I set it to 255
        arr2 = new byte[]{1,1,1,1,1,1,1,1};
        //arr5 through arr8 need to be all 0
        arr5 = new byte[]{0,0,0,0,0,0,0,0};
        arr6 = new byte[]{0,0,0,0,0,0,0,0};
        arr7 = new byte[]{0,0,0,0,0,0,0,0};
        arr8 = new byte[]{0,0,0,0,0,0,0,0};
        
        fullBytes = new byte[][]{arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8};

        //send data using FRCNetCommCANSessionMuxSendMessage​
        //use https://first.wpi.edu/FRC/roborio/release/docs/java/edu/wpi/first/hal/can/CANJNI.html#FRCNetCommCANSessionMuxSendMessage(int,byte%5B%5D,int) in the future
        CustomCAN can = new CustomCAN(name, id);
        for(int i = 0; i<fullBytes.length;i++){
            can.write(fullBytes[i]);
        }
   }


} 