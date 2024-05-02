package org.shaikhabdulgani.abstraction;

abstract class Human{
    abstract void printName();
    void run(){
        System.out.println("Human is running");
    }
}

class Asian extends Human{
    private final String name;

    public Asian(String name) {
        this.name = name;
    }

    @Override
    void printName() {
        System.out.println("Name is "+name);
    }
}

public class Partial {
    public static void main(String[] args) {
        Asian abdulgani = new Asian("Abdul Gani");
        abdulgani.run();
        abdulgani.printName();
    }
}
