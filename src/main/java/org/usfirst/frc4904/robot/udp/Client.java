package org.usfirst.frc4904.robot.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

import java.io.*;


public class Client {
    private DatagramSocket socket;
    private InetAddress address;

    private byte[] buf;

    public Client() {
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("localhost");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String sendEcho(String msg) {
        DatagramPacket packet = null;
        try {
            buf = msg.getBytes();
            packet = new DatagramPacket(buf, buf.length, address, 4445);
            socket.send(packet);
            packet = new DatagramPacket(buf, buf.length);
            socket.receive(packet);
        } catch (IOException e) {
            System.out.println("exception ajsdfjasdflaksdfjl");
            e.printStackTrace();
        }
        String received = new String(packet.getData(), 0, packet.getLength());
        return received;
    }

    public String receiveData() {
        DatagramPacket packet = new DatagramPacket(new byte[256], 256);
        try {
            socket.receive(packet);
            String received = new String(packet.getData(), 0, packet.getLength());
            return received;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void close() {
        socket.close();
    }
}