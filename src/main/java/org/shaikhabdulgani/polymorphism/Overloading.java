package org.shaikhabdulgani.polymorphism;

public class Overloading {

    public void add(int a,int b){
        System.out.printf("Addition of a and b is %d\n",(a+b));
    }

    public void add(int a,int b,int c){
        System.out.printf("Addition of a, b and c is %d\n",(a+b+c));
    }

    public static void main(String[] args) {
        Overloading overloading = new Overloading();
        overloading.add(1,3);
        overloading.add(1,3,6);
    }
}
