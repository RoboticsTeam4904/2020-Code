package org.usfirst.frc4904.robot;

public class setLeds {
    //Setting bits in Java for the leds on the robot
    //The first bit should be an array of IF there is a custom color, they are ready to shoot, in shooting zone, and the alliance color
    static int[] arr1, arr2, arr3, arr4, arr5, arr6, arr7, arr8;
    // int byteArr[][] = [arr1[], arr2[], arr3[], arr4[], arr5[], arr6[], arr7[], arr8[]];

    public static void setLeds(){
        //arr1 needs to tell us if there is a custom color, they are ready to shoot, in shooting zone, and the alliance color
        arr1 = new int[]{0,0,0,0};
        //arr2 needs to be red color, I set it to 255
        arr2 = new int[]{1,1,1,1,1,1,1,1}
        //arr3 needs to be blue color, I set it to 255
        arr2 = new int[]{1,1,1,1,1,1,1,1}}
        //arr4 needs to be green color, I set it to 255
        arr2 = new int[]{1,1,1,1,1,1,1,1}}
        //arr5 through arr8 need to be all 0
        arr5 = new int[]{0,0,0,0,0,0,0,0};
        arr6 = new int[]{0,0,0,0,0,0,0,0};
        arr7 = new int[]{0,0,0,0,0,0,0,0};
        arr8 = new int[]{0,0,0,0,0,0,0,0};

    }
} 