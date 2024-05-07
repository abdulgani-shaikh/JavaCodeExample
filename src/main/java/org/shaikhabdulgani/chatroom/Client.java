package org.shaikhabdulgani.chatroom;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public Client() {
        try {
            Socket socket = new Socket("localhost", 3000);
            DataOutputStream dos = new DataOutputStream(new BufferedOutputStream(socket.getOutputStream()));
            DataInputStream dis = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter username: ");
            String username = sc.next();

            dos.writeUTF(username);
            new ReaderThread(
                    socket,
                    dis
            ).start();

            String message = sc.nextLine();
            while (!message.equals("quit")) {
                dos.writeUTF(STR."\{username}: \{message}");
            }
            closeEverything(socket,dos,dis);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private void closeEverything(Socket socket, DataOutputStream dos, DataInputStream dis) {
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

    public static void main(String[] args) {
        new Client();
    }
}

class ReaderThread extends Thread {
    DataInputStream is;
    Socket socket;

    public ReaderThread(Socket socket, DataInputStream is) {
        this.is = is;
        this.socket = socket;
    }

    @Override
    public void run() {
        String newMessage;
        while (socket.isConnected()) {
            try {
                newMessage = is.readUTF();
                System.out.println(newMessage);
            } catch (Exception e) {
                try {
                    if (is != null) {
                        is.close();
                    }
                    if (socket != null) {
                        socket.close();
                    }
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    }
}
