package org.shaikhabdulgani.inheritance;

class Animal {
    void eat() {
        System.out.println("Animal is eating");
    }
}

class Dog extends Animal {
    void bark() {
        System.out.println("Dog is barking");
    }
}

class Pug extends Dog {
    void color() {
        System.out.println("Pug is brown in color");
    }
}


public class Multilevel {
    public static void main(String[] args) {
        Pug pug = new Pug();
        pug.eat();  //level1
        pug.bark(); //level2
        pug.color(); //level3
    }
}
