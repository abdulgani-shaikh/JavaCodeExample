package org.shaikhabdulgani.abstraction;

interface Shape{
    void draw();
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Square");
    }
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("Drawing Circle");
    }
}

public class Full {
    public static void main(String[] args) {
        Shape square = new Square();
        square.draw();

        Shape circle = new Circle();
        circle.draw();
    }
}
