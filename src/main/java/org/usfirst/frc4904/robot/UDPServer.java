package org.usfirst.frc4904.robot;

import java.io.*;
import java.net.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

import org.usfirst.frc4904.standard.LogKitten;

//https://systembash.com/a-simple-java-udp-server-and-udp-client/
class UDPServer extends Thread {
    static int udp_port = 1234;

    private static UDPServer instance = null;
    private HashMap<byte[], ArrayList<UDPListener>> listeners = new HashMap<byte[], ArrayList<UDPListener>>();
    public void run() {
        try {
            DatagramSocket serverSocket = new DatagramSocket(udp_port);
            byte[] receiveData = new byte[1024];
            while(true) {
                try {
                    DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
                    serverSocket.receive(receivePacket);
                    byte[] receivedBytes = receivePacket.getData();
                    InetAddress ip = receivePacket.getAddress();
                    int port = receivePacket.getPort();
                    byte[] header = Arrays.copyOfRange(receivedBytes, 0, 8);
                    byte[] data = Arrays.copyOfRange(receivedBytes, 8, receivedBytes.length);
                    UDPEvent event = new UDPEvent(ip, port, header, data);
                    if(listeners.containsKey(header)){
                        for(UDPListener listener : listeners.get(header)){
                            listener.onEvent(event);
                        }
                    }
                }catch(IOException e){
                    LogKitten.wtf("Server has IOException!");
                    LogKitten.wtf(e.getMessage());
                }
            }
        }catch(SocketException e){
            LogKitten.wtf("Server cannot bind to socket!");
        }
        
    }
    private UDPServer(){
        //Yay?
    }
    public static UDPServer getInstance(){
        if(instance == null){
            instance = new UDPServer();
        }
        return instance;
    }

    public void registerListener(byte[] header, UDPListener listener){
        if(!listeners.containsKey(header)){
            listeners.put(header, new ArrayList<UDPListener>());
        }
        listeners.get(header).add(listener);
    }
}