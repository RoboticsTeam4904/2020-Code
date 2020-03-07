package org.usfirst.frc4904.robot.udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.io.*;

public class Server extends Thread {

    protected DatagramSocket socket = null;
    protected boolean running;
    protected byte[] buf = new byte[256];
    protected String endString = "end";

    public Server() throws IOException {
        socket = new DatagramSocket(4444);
    }

    public void run() {
        System.out.println("Server Running");
        running = true;
        while (running) {
            try {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                String received = new String(packet.getData(), 0, packet.getLength());
                System.out.println("received: '" + received + "', length: " + received.length());
                if (endString.equals(received)) {
                    System.out.println("It's a SUCCESS!");
                    running = false;
                    continue;
                }
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
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