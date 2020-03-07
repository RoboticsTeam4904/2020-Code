package org.usfirst.frc4904.robot.udp;

import java.io.*;
import org.usfirst.frc4904.robot.udp.Client;
import org.usfirst.frc4904.robot.udp.Server;
 
public class UDPTest {
    Client client;
 
    public void setup() {
        System.out.println("Setting up the test.");
        try{
            new Server().start();
            client = new Client();
        }
        catch (IOException ex){
            System.out.println("ERR: IOException during setup. This error is from creating the Server.");
            ex.printStackTrace();
        }
    }
 
    public void whenCanSendAndReceivePacket_thenCorrect() { // the name of this function is nonsensical and this function is useless
        System.out.println("Sending and receiving");
        System.out.println("Client is " + this.client);
        System.out.println(client.sendEcho("Hello server!")); // this is pointless
        System.out.println(client.sendEcho("Server is working")); // not necissarily
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