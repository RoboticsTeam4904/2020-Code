package org.usfirst.frc4904.robot.udp;

import java.io.*;

public class UDPTest {
    Client client;
 
    public void setup() {
        try{
        new Server().start();
        client = new Client();
        }
        catch (IOException ex){

            System.out.println(ex);
        }
    }
 
    public void whenCanSendAndReceivePacket_thenCorrect() {
        System.out.println(this.client);
        client.sendEcho("hello server");
        client.sendEcho("server is working");
    }
 
    public void tearDown() {
        client.sendEcho("end");
        client.close();
    }

    public static void main(String[] args) {
        UDPTest udpthing = new UDPTest();
        udpthing.setup();
        udpthing.whenCanSendAndReceivePacket_thenCorrect();
        udpthing.tearDown();
    }
}