package org.shaikhabdulgani.generics;

import java.util.List;

public class Generics {
    public static void main(String[] args) {
        NumberGeneric<Integer> integers = new NumberGeneric<>(List.of(1, 2, 3));
        NumberGeneric<Double> doubles =  new NumberGeneric<>(List.of(1.5, 2.2, 3.8));

        System.out.println("Sum of integers: " + integers.sum(List.of(1, 2, 3)));
        System.out.println("Sum of doubles: " + doubles.sum(List.of(1.5, 2.2, 3.8)));

        integers.printElements();
        doubles.printElements();
    }
}

class NumberGeneric<T extends Number>{
    List<T> list;

    public NumberGeneric(List<T> list) {
        this.list = list;
    }

    public static <T extends Number> double sum(List<T> list) {
        double sum = 0.0;
        for (T number : list) {
            sum += number.doubleValue();
        }
        return sum;
    }

    public void printElements() {
        for (T element : list) {
            System.out.println(element);
        }
    }
}