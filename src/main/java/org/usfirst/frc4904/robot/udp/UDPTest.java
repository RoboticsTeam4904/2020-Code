package org.usfirst.frc4904.robot.udp;

import java.io.*;

public class UDPTest {
    Client client;
    private int socketNum = 3344;

    public void setup() {
        System.out.println("Setting up the test on socket #" + socketNum + ".");
        try {
            new Server(socketNum).start();
            client = new Client("CLIENT##", socketNum);
        } catch (IOException ex) {
            System.out.println("ERR: IOException during setup. This error is from creating the Server.");
            ex.printStackTrace();
        }
    }

    public void test() {
        System.out.println(client.sendEcho("test"));
        client.close();
    }

    public static void main(String[] args) {
        UDPTest udpTest = new UDPTest();
        udpTest.setup();
        udpTest.test();
    }
}