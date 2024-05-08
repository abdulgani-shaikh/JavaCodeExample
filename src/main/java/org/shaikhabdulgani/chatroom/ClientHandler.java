package org.shaikhabdulgani.chatroom;

import lombok.Getter;

import java.io.*;
import java.lang.ref.Cleaner;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ClientHandler extends Thread {

    private Socket socket;
    private BufferedReader reader;
    @Getter
    private BufferedWriter writer;
    public static List<ClientHandler> users = new ArrayList<>();
    @Getter
    private String username;

    public ClientHandler(Socket socket) {
        try {
            this.socket = socket;
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            username = reader.readLine();
            users.add(this);
            System.out.println(String.format("%s connected", username));
            broadcastMessage(STR."Server: \{username} joined!");
        } catch (IOException e) {
            closeEverything();
        }
    }

    private void closeEverything() {
        removeUser();
        close(socket);
        close(reader);
        close(writer);

        socket = null;
        reader = null;
        writer = null;
    }

    private <T extends Closeable> void close(T res) {
        try {
            if (res != null) {
                res.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void removeUser() {
        broadcastMessage(STR."\{username} left");
        users.remove(this);
    }

    private void broadcastMessage(String message) {
        System.out.println(message);
        for (ClientHandler clientHandler : users) {
            try {
                if (!clientHandler.getUsername().equals(username)) {
                    clientHandler.writer.write(message);
                    clientHandler.writer.newLine();
                    clientHandler.writer.flush();
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
                closeEverything();
            }
        }

    }

    @Override
    public void run() {
        String newMessage;
        while (socket.isConnected()) {
            try {
                newMessage = reader.readLine();
                if (newMessage.endsWith("quit()")) {
                    closeEverything();
                    break;
                }
                broadcastMessage(newMessage);
            } catch (Exception e) {
                closeEverything();
                break;
            }
        }
    }
}

