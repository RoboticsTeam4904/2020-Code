package org.usfirst.frc4904.robot;

import java.net.DatagramPacket;
import java.net.InetAddress;

class UDPEvent {
    static int header_size = 8;
    static int message_size = 1024-header_size;
    byte[] header;
    byte[] message;
    InetAddress ip;
    int port;
    public UDPEvent(InetAddress ip, int port, byte[] header, byte[] message){
        this.ip = ip;
        this.port = port;
        this.header = header;
        this.message = message;
    }
    public InetAddress getIPAddress(){
        return this.ip;
    }
    public int getPort(){
        return this.port;
    }
    public byte[] getHeader(){
        return this.header;
    }
    public byte[] getMessage(){
        return this.message;
    }
    public void sendQuickResponse(byte[] data){
        byte[] sendData = new byte[header_size + data.length];
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, this.ip, this.port);
    }
}