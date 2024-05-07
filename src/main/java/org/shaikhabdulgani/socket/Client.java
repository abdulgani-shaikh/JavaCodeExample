package org.shaikhabdulgani.socket;



import javax.sound.sampled.Port;
import java.io.*;
import java.net.*;

public class Client {
    
    private Socket socket = null;
    private DataInputStream input = null;
    private DataOutputStream out = null;
    
    public Client(InetAddress address, int port) {
        try {
            socket = new Socket(address, port);
            System.out.println("Connected!!!");
            input = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());
        }catch (Exception e) {
            e.printStackTrace();
            return;
        }

        String line = "";

        while (!line.equals("Over")) {
            try {
                line = input.readLine();
                out.writeUTF(line);
            } catch (IOException i) {
                System.out.println(i);
            }
        }

        try {
            input.close();
            out.close();
            socket.close();
        } catch (IOException i) {
            System.out.println(i);
        }
    }

    public static void main(String args[]) {
        try {
            new Client(InetAddress.getLocalHost(), Server.PORT);
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        }
    }
}

