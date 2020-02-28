package org.usfirst.frc4904.robot.udp;

<<<<<<< HEAD
import java.io.*;
=======
import org.junit.*;
>>>>>>> e584e392b294c399641b08ff9d733508096d6f4d

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