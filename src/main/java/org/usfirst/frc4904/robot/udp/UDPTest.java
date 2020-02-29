package org.usfirst.frc4904.robot.udp;

import java.io.*;

public class UDPTest {
    Client client;
 
    public void setup() {
        System.out.println("Setting up test");
        try{
            new Server().start();
            client = new Client();
        }
        catch (IOException ex){
            System.out.println("Setup error");
            System.out.println(ex);
        }
    }
 
    public void whenCanSendAndReceivePacket_thenCorrect() {
        System.out.println("Sending and receiving");
        System.out.println("Client is " + this.client);
        System.out.println(client.sendEcho("hello server"));
        System.out.println(client.sendEcho("server is working"));
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