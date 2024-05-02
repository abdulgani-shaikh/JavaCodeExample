package org.shaikhabdulgani.encapsulation;

class Human{
    private String name;
    private int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return String.format("I'm %s and I'm %d years old.",name,age);
    }
}

public class Encapsulation {
    public static void main(String[] args) {
        Human human1 = new Human("Abdul Gani Shaikh",22);
        Human human2 = new Human("John Doe",51);

        System.out.println(human1);
        System.out.println(human2);
    }
}
