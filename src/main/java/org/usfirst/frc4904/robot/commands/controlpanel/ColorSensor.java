
package org.usfirst.frc4904.robot.commands.controlpanel;

import edu.wpi.first.wpilibj2.command.SequentialCommandGroup;
import org.usfirst.frc4904.robot.RobotMap.NetworkTables;
import org.usfirst.frc4904.standard.LogKitten;

/**
 * This class contains everything pertaining to using the camera for the control
 * panel.
 * 
 * quu..__
 $$$b  `---.__
  "$$b        `--.                          ___.---uuudP
   `$$b           `.__.------.__     __.---'      $$$$"              .
     "$b          -'            `-.-'            $$$"              .'|
       ".                                       d$"             _.'  |
         `.   /                              ..."             .'     |
           `./                           ..::-'            _.'       |
            /                         .:::-'            .-'         .'
           :                          ::''\          _.'            |
          .' .-.             .-.           `.      .'               |
          : /'$$|           .@"$\           `.   .'              _.-'
         .'|$u$$|          |$$,$$|           |  <            _.-'
         | `:$$:'          :$$$$$:           `.  `.       .-'
         :                  `"--'             |    `-.     \
        :##.       ==             .###.       `.      `.    `\
        |##:                      :###:        |        >     >
        |#'     `..'`..'          `###'        x:      /     /
         \                                   xXX|     /    ./
          \                                xXXX'|    /   ./
          /`-.                                  `.  /   /
         :    `-  ...........,                   | /  .'
         |         ``:::::::'       .            |<    `.
         |             ```          |           x| \ `.:``.
         |                         .'    /'   xXX|  `:`M`M':.
         |    |                    ;    /:' xXXX'|  -'MMMMM:'
         `.  .'                   :    /:'       |-'MMMM.-'
          |  |                   .'   /'        .'MMM.-'
          `'`'                   :  ,'          |MMM<
            |                     `'            |tbap\
             \                                  :MM.-'
              \                 |              .''
               \.               `.            /
                /     .:::::::.. :           /
               |     .:::::::::::`.         /
               |   .:::------------\       /
              /   .''               >::'  /
              `',:                 :    .'

``````¶0````1¶1_```````````````````````````````````````
```````¶¶¶0_`_¶¶¶0011100¶¶¶¶¶¶¶001_````````````````````
````````¶¶¶¶¶00¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶0_````````````````
`````1_``¶¶00¶0000000000000000000000¶¶¶¶0_`````````````
`````_¶¶_`0¶000000000000000000000000000¶¶¶¶¶1``````````
```````¶¶¶00¶00000000000000000000000000000¶¶¶_`````````
````````_¶¶00000000000000000000¶¶00000000000¶¶`````````
`````_0011¶¶¶¶¶000000000000¶¶00¶¶0¶¶00000000¶¶_````````
```````_¶¶¶¶¶¶¶00000000000¶¶¶¶0¶¶¶¶¶00000000¶¶1````````
``````````1¶¶¶¶¶000000¶¶0¶¶¶¶¶¶¶¶¶¶¶¶0000000¶¶¶````````
```````````¶¶¶0¶000¶00¶0¶¶`_____`__1¶0¶¶00¶00¶¶````````
```````````¶¶¶¶¶00¶00¶10¶0``_1111_`_¶¶0000¶0¶¶¶````````
``````````1¶¶¶¶¶00¶0¶¶_¶¶1`_¶_1_0_`1¶¶_0¶0¶¶0¶¶````````
````````1¶¶¶¶¶¶¶0¶¶0¶0_0¶``100111``_¶1_0¶0¶¶_1¶````````
```````1¶¶¶¶00¶¶¶¶¶¶¶010¶``1111111_0¶11¶¶¶¶¶_10````````
```````0¶¶¶¶__10¶¶¶¶¶100¶¶¶0111110¶¶¶1__¶¶¶¶`__````````
```````¶¶¶¶0`__0¶¶0¶¶_¶¶¶_11````_0¶¶0`_1¶¶¶¶```````````
```````¶¶¶00`__0¶¶_00`_0_``````````1_``¶0¶¶_```````````
``````1¶1``¶¶``1¶¶_11``````````````````¶`¶¶````````````
``````1_``¶0_¶1`0¶_`_``````````_``````1_`¶1````````````
``````````_`1¶00¶¶_````_````__`1`````__`_¶`````````````
````````````¶1`0¶¶_`````````_11_`````_``_``````````````
`````````¶¶¶¶000¶¶_1```````_____```_1``````````````````
`````````¶¶¶¶¶¶¶¶¶¶¶¶0_``````_````_1111__``````````````
`````````¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶01_`````_11____1111_```````````
`````````¶¶0¶0¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶1101_______11¶_```````````
``````_¶¶¶0000000¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶0¶0¶¶¶1````````````
`````0¶¶0000000¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶1`````````````
````0¶0000000¶¶0_````_011_10¶110¶01_1¶¶¶0````_100¶001_`
```1¶0000000¶0_``__`````````_`````````0¶_``_00¶¶010¶001
```¶¶00000¶¶1``_01``_11____``1_``_`````¶¶0100¶1```_00¶1
``1¶¶00000¶_``_¶_`_101_``_`__````__````_0000001100¶¶¶0`
``¶¶¶0000¶1_`_¶``__0_``````_1````_1_````1¶¶¶0¶¶¶¶¶¶0```
`_¶¶¶¶00¶0___01_10¶_``__````1`````11___`1¶¶¶01_````````
`1¶¶¶¶¶0¶0`__01¶¶¶0````1_```11``___1_1__11¶000`````````
`1¶¶¶¶¶¶¶1_1_01__`01```_1```_1__1_11___1_``00¶1````````
``¶¶¶¶¶¶¶0`__10__000````1____1____1___1_```10¶0_```````
``0¶¶¶¶¶¶¶1___0000000```11___1__`_0111_```000¶01```````
```¶¶¶00000¶¶¶¶¶¶¶¶¶01___1___00_1¶¶¶`_``1¶¶10¶¶0```````
```1010000¶000¶¶0100_11__1011000¶¶0¶1_10¶¶¶_0¶¶00``````
10¶000000000¶0________0¶000000¶¶0000¶¶¶¶000_0¶0¶00`````
¶¶¶¶¶¶0000¶¶¶¶_`___`_0¶¶¶¶¶¶¶00000000000000_0¶00¶01````
¶¶¶¶¶0¶¶¶¶¶¶¶¶¶_``_1¶¶¶00000000000000000000_0¶000¶01```
1__```1¶¶¶¶¶¶¶¶¶00¶¶¶¶00000000000000000000¶_0¶0000¶0_``
```````¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶00000000000000000000010¶00000¶¶_`
```````0¶¶¶¶¶¶¶¶¶¶¶¶¶¶00000000000000000000¶10¶¶0¶¶¶¶¶0`
````````¶¶¶¶¶¶¶¶¶¶0¶¶¶00000000000000000000010¶¶¶0011```
````````1¶¶¶¶¶¶¶¶¶¶0¶¶¶0000000000000000000¶100__1_`````
`````````¶¶¶¶¶¶¶¶¶¶¶¶¶¶¶000000000000000000¶11``_1``````
`````````1¶¶¶¶¶¶¶¶¶¶¶0¶¶¶00000000000000000¶11___1_`````
``````````¶¶¶¶¶¶0¶0¶¶¶¶¶¶¶0000000000000000¶11__``1_````
``````````¶¶¶¶¶¶¶0¶¶¶0¶¶¶¶¶000000000000000¶1__````__```
``````````¶¶¶¶¶¶¶¶0¶¶¶¶¶¶¶¶¶0000000000000000__`````11``
`````````_¶¶¶¶¶¶¶¶¶000¶¶¶¶¶¶¶¶000000000000011_``_1¶¶¶0`
`````````_¶¶¶¶¶¶0¶¶000000¶¶¶¶¶¶¶000000000000100¶¶¶¶0_`_
`````````1¶¶¶¶¶0¶¶¶000000000¶¶¶¶¶¶000000000¶00¶¶01`````
`````````¶¶¶¶¶0¶0¶¶¶0000000000000¶0¶00000000011_``````_
````````1¶¶0¶¶¶0¶¶¶¶¶¶¶000000000000000000000¶11___11111
````````¶¶¶¶0¶¶¶¶¶00¶¶¶¶¶¶000000000000000000¶011111111_
```````_¶¶¶¶¶¶¶¶¶0000000¶0¶00000000000000000¶01_1111111
```````0¶¶¶¶¶¶¶¶¶000000000000000000000000000¶01___`````
```````¶¶¶¶¶¶0¶¶¶000000000000000000000000000¶01___1````
``````_¶¶¶¶¶¶¶¶¶00000000000000000000000000000011_111```
``````0¶¶0¶¶¶0¶¶0000000000000000000000000000¶01`1_11_``
``````¶¶¶¶¶¶0¶¶¶0000000000000000000000000000001`_0_11_`
``````¶¶¶¶¶¶¶¶¶00000000000000000000000000000¶01``_0_11`
``````¶¶¶¶0¶¶¶¶00000000000000000000000000000001```_1_11
 */
public class ColorSensor extends SequentialCommandGroup {
    public final Color[] colorOrder = new Color[] { Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN };

    public Color currentColor = null;
    private int colorsPassed = 0;
    public boolean doneSpinning = false;

    public ColorSensor() {
    }

    public void trackColorChange() {
        if (currentColor == null) {
            currentColor = getColor();
            return;
        }
        Color tempColor = getColor();
        if (currentColor != tempColor) {
            Color oldColor = currentColor;
            currentColor = tempColor;
            colorsPassed++;
            if (getIndex(currentColor) == 3) {
                if (currentColor == colorOrder[0]) {
                    if (colorsPassed == 23) {
                        doneSpinning = true;
                    }
                } else {
                    LogKitten.wtf("A color somehow was skipped and we have no code to handle it! :)");
                    // it is very unlikely for a color to be skipped because the control panel will
                    // not be rotating that quickly
                }
            } else {
                if (currentColor == colorOrder[getIndex(oldColor) + 1]) {
                    if (colorsPassed == 23) {
                        doneSpinning = true;
                    }
                } else {
                    LogKitten.wtf("A color somehow was skipped and we have no code to handle it! :) please consider not dying");
                    // it is very unlikely for a color to be skipped because the control panel will
                    // not be rotating that quickly
                }
            }
        }
    }

    /**
     * 
     * @return String color
     */
    public Color getColor() {
        String colorResult = NetworkTables.Sensors.controlPanelColor.getString("ERROR");
        if (colorResult == "ERROR") {
            LogKitten.wtf("Control panel color not in network table. ERROR was returned instead.");
            return null;
        } else if (colorResult == null) {
            LogKitten.wtf("Control panel color not in network table. Null was returned instead.");
            return null;
        }
        switch (colorResult) { // TODO: get correct format for strings
        case "RED":
            return Color.RED;
        case "GREEN":
            return Color.GREEN;
        case "YELLOW":
            return Color.YELLOW;
        case "BLUE":
            return Color.BLUE;
        default:
            return null;
        }
    }

    /**
     * An enum of the different colors on the control panel.
     */
    enum Color {
        RED, YELLOW, BLUE, GREEN;
    }

    public int getIndex(Color color) {
        for (int index = 0; index < colorOrder.length; index++) {
            if (colorOrder[index] == color) {
                return index;
            }
        }
        return -1;
    }

    /**
     * 
     * Classifies the rgb color value from the camera to red, yellow, blue, or green
     * 
     * @param colorString
     * @return Color
     */
    /*
     * public Color colorClassifier(String colorString) { if (colorString == null) {
     * return null; } int closestColorIndex = -1; int smallestDistance = 765; //
     * TODO: determine how the colorString is formatted so that we can get the three
     * // values below from it int red; int green; int blue; for (int index = 0;
     * index < ColorValuesArray.length; index++) { int distance = Math.abs(red -
     * ColorValuesArray[index][0]) + Math.abs(green - ColorValuesArray[index][1]) +
     * Math.abs(blue - ColorValuesArray[index][2]); if (distance < smallestDistance)
     * { smallestDistance = distance; closestColorIndex = index; } } switch
     * (closestColorIndex) { case 0: return Color.RED; case 1: return Color.YELLOW;
     * case 2: return Color.BLUE; case 3: return Color.GREEN; default: return null;
     * } }
     */
}
