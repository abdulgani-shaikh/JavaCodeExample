package org.shaikhabdulgani.chatroom;

import java.io.*;
import java.lang.ref.Cleaner;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientHandler extends Thread {

    private Socket socket;
    private DataInputStream dis;
    private DataOutputStream dos;
    public static List<ClientHandler> users = new ArrayList<>();
    private String username;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            this.dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
            this.dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            username = dis.readUTF();
            users.add(this);
            broadcastMessage(STR."Server: \{username} joined!");
        } catch (IOException e) {
            closeEverything();
        }
    }

    private void closeEverything() {
        removeUser();
        close(socket);
        close(dis);
        close(dos);
    }

    private <T extends Closeable>void close(T res){
        try {
            if (res!=null) {
                res.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeUser(){
        users.remove(this);
        broadcastMessage(STR."\{username} left");
    }

    private void broadcastMessage(String message) {
        for (ClientHandler clientHandler : users) {
            try {
                if (!clientHandler.username.equals(username)) {
                    clientHandler.dos.writeUTF(message);
                    clientHandler.dos.flush();
                }
            } catch (Exception e) {
                closeEverything();
            }
        }

    }

    @Override
    public void run() {
        String newMessage;
        while (socket.isConnected()) {
            try {
                newMessage = dis.readUTF();
                broadcastMessage(newMessage);
            } catch (Exception e) {
                closeEverything();
            }
        }
    }
}

