package org.shaikhabdulgani.polymorphism;

class Animal {
    void sound() {
        System.out.println("Animal makes a sound");
    }
}

class Dog extends Animal {
    @Override
    void sound() {
        System.out.println("Dog barks");
    }
}

// Main class
public class Overriding {
    public static void main(String[] args) {
        Animal animal = new Animal();
        animal.sound();

        Animal dog = new Dog();
        dog.sound();
    }
}
