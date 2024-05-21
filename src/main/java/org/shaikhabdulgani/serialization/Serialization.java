package org.shaikhabdulgani.serialization;

import java.io.*;

public class Serialization {

    private static final String filePath = "C:\\Users\\Dell\\Desktop\\SpringBoot\\employee.txt";

    public static void main(String[] args) {
        Serialization serialization = new Serialization();
        serialization.writeObjectToPath(new User(
                "abdulgani4",
                "Abdul Gani Shaikh",
                22,
                new String[]{"Java", "Kotlin"}
        ), filePath);
        User user = serialization.readObjectFromPath(filePath);
        System.out.println(user.toString());
    }

    void writeObjectToPath(User user, String path) {
        try (FileOutputStream outputStream = new FileOutputStream(path);
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream)) {

            objectOutputStream.writeObject(user);
            System.out.println("Object stored in system");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    User readObjectFromPath(String path) {
        try (FileInputStream outputStream = new FileInputStream(path);
             ObjectInputStream objectOutputStream = new ObjectInputStream(outputStream)) {

            Object result = objectOutputStream.readObject();
            if (result instanceof User) {
                return (User) result;
            }
            throw new RuntimeException("File doesn't store object of User class");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
