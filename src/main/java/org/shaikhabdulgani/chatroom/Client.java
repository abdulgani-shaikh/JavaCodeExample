package org.shaikhabdulgani.chatroom;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    private Socket socket;
    private BufferedReader reader;
    private BufferedWriter writer;
    private String username;

    public Client(String username) {
        try {
            socket = new Socket("10.0.61.81", 3000);
            writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            this.username = username;
            writer.write(username);
            writer.newLine();
            writer.flush();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void sendMessages() throws IOException {
        Scanner sc = new Scanner(System.in);
        String message = "";
        while (!message.equals("quit")) {
            message = sc.nextLine();
            writer.write(String.format("%s: %s", username, message));
            writer.newLine();
            writer.flush();
        }
        closeEverything();
    }

    public void receiveMessages() {
        new Thread(() -> {
            String newMessage;
            while (socket.isConnected()) {
                try {
                    newMessage = reader.readLine();
                    System.out.println(newMessage);
                } catch (IOException e) {
                    closeEverything();
                }
            }
        }).start();
    }

    public void closeEverything() {
        close(socket);
        close(reader);
        close(writer);
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

    public static void main() {
        Client client = null;
        try {
            System.out.print("Enter username: ");

            Scanner sc = new Scanner(System.in);
            String username = sc.next();

            client = new Client(username);
            client.receiveMessages();
            client.sendMessages();
        } catch (IOException e) {
            client.closeEverything();
        }
    }
}
