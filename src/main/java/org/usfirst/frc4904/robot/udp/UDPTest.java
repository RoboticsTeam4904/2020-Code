package org.usfirst.frc4904.robot.udp;

import java.io.*;

public class UDPTest {
    Client client;

    public void setup() {
        System.out.println("Setting up the test.");
        try {
            new Server().start();
            client = new Client();
        } catch (IOException ex) {
            System.out.println("ERR: IOException during setup. This error is from creating the Server.");
            ex.printStackTrace();
        }
    }

    public void whenCanSendAndReceivePacket_thenCorrect() { // the name of this function is nonsensical
        System.out.println("Sending and receiving");
        System.out.println("Client: " + this.client);
        System.out.println("Sent back from server: '" + client.sendEcho("Hello server!") + "'");
    }

    public void tearDown() {
        System.out.println(client.sendEcho("end"));
        System.out.println(client.sendEcho(""));
        client.close();
    }

    public static void main(String[] args) {
        UDPTest udpTest = new UDPTest();
        udpTest.setup();
        udpTest.whenCanSendAndReceivePacket_thenCorrect();
        udpTest.tearDown();
    }
}