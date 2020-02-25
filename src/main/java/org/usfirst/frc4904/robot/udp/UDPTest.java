package org.usfirst.frc4904.robot.udp;

import org.junit.*;

public class UDPTest {
    Client client;
 
    @Before
    public void setup(){
        new Server().start();
        client = new Client();
    }
 
    @Test
    public void whenCanSendAndReceivePacket_thenCorrect() {
        String echo = client.sendEcho("hello server");
        assertEquals("hello server", echo);
        echo = client.sendEcho("server is working");
        assertFalse(echo.equals("hello server"));
    }
 
    @After
    public void tearDown() {
        client.sendEcho("end");
        client.close();
    }
}