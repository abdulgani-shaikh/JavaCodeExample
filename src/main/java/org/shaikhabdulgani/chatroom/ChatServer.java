package org.shaikhabdulgani.chatroom;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatServer {

    private ServerSocket serverSocket;

    ChatServer(int port) throws IOException {
        try {
            serverSocket = new ServerSocket(port);
            System.out.println("Chat Server Started");
            System.out.println("Waiting for clients...");

            while (!serverSocket.isClosed()) {
                Socket socket = serverSocket.accept();
                System.out.println("New user connected");
                Thread thread = new ClientHandler(socket);
                thread.start();
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (serverSocket != null) {
                serverSocket.close();
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new ChatServer(3000);
    }
}
