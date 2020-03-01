package org.usfirst.frc4904.robot.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.*;

public class Server extends Thread {

    protected DatagramSocket socket = null;
    protected boolean running;
    protected byte[] buf = new byte[256];

    public Server() throws IOException {
        socket = new DatagramSocket(4445);
    }

    public void run() {
        System.out.println("Server Running");
        running = true;
        while (running) {
            try {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                String received = new String(packet.getData());//, 0, packet.getLength());
                received.replaceAll("\\s+", "");
                System.out.println("received: " + received + ", length: " + received.length());
                String convertedReceived = "";
                try {
                    byte[] utf8Bytes = received.getBytes("UTF-8");
                    convertedReceived = new String(utf8Bytes, "UTF-8");
                }
                catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                String endString = "end";
                if (convertedReceived.equals(endString)) {
                    System.out.println("Server received 'end'");
                    running = false;
                    System.out.println(packet.getData());
                    continue;
                }
                socket.send(packet);
                buf = new byte[256];
            } catch (IOException e) {
                e.printStackTrace();
                running = false;
            }
        }
        socket.close();
    }
}