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
        running = true;

        while (running) {
            try {
                DatagramPacket packet = new DatagramPacket(buf, buf.length);
                socket.receive(packet);
                InetAddress address = packet.getAddress();
                int port = packet.getPort();
                packet = new DatagramPacket(buf, buf.length, address, port);
                String received = new String(packet.getData(), 0, packet.getLength());
                if (received.equals("end")) {
                    running = false;
                    System.out.println(packet.getData());
                    continue;
                }
                socket.send(packet);
            } catch (IOException e) {
                e.printStackTrace();
                running = false;
            }
        }
        socket.close();
    }
}