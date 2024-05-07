package org.shaikhabdulgani.socket;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 12354;
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket = new ServerSocket(PORT);
            System.out.println(STR."Server started running on port \{PORT}...");

            Socket socket = serverSocket.accept();
            System.out.println("Client connected!!!");

            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            String line = "";
            while (!line.equals("Over"))
            {
                try
                {
                    line = dis.readUTF();
                    System.out.println(line);
                }
                catch(IOException i)
                {
                    System.out.println(i);
                }
            }
            System.out.println("Closing connection...");

            socket.close();
            dis.close();

            System.out.println("Connection closed.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
