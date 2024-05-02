package org.shaikhabdulgani.inheritance;

class Cat{
    void meow(){
        System.out.println("Cat is meowing");
    }
}

class Persian extends Cat{
    void hair(){
        System.out.println("Persian has a lot of hairs");
    }
}

class Sphynx extends Cat{
    void bald(){
        System.out.println("Sphynx is bald");
    }
}

public class Hierarchical {
    public static void main(String[] args) {
        Persian persian = new Persian();
        persian.meow();
        persian.hair();

        Sphynx sphynx = new Sphynx();
        sphynx.meow();
        sphynx.bald();
    }
}
