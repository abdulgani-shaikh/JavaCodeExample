package org.shaikhabdulgani.inheritance;

//Java doesn't support multiple inheritance directly.
//But you can use interface to implement multiple inheritance
public class Multiple {
    public static void main(String[] args) {
        Human john = new Human("John");
        john.pedal();
        john.swim();
    }
}

interface Cyclist{
    void pedal();
}

interface Swimmer{
    void swim();
}

class Human implements Cyclist, Swimmer {

    private String name;

    Human(String name) {
        this.name = name;
    }

    @Override
    public void pedal() {
        System.out.printf("%s is Peddling\n",name);
    }

    @Override
    public void swim() {
        System.out.printf("%s is Swimming\n",name);
    }
}
