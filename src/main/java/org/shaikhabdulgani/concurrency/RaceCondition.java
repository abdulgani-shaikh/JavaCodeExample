package org.shaikhabdulgani.concurrency;

import lombok.Getter;
import lombok.Setter;

public class RaceCondition {
    public static void main(String[] args) {
        CriticalSection section1 = new CriticalSection();

        System.out.println("----------Without synchronization----------");
        System.out.println(STR."Before: \{CriticalSection.getSharedVariable()}");
        Thread incrementer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                section1.increment();
            }
        });
        Thread decrementer = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                section1.decrement();
            }
        });

        incrementer.start();
        decrementer.start();

        try {
            incrementer.join();
            decrementer.join();
            System.out.println(STR."After: \{CriticalSection.getSharedVariable()}");

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        CriticalSection section2 = new CriticalSection();

        System.out.println("----------With synchronization----------");
        System.out.println(STR."Before: \{CriticalSection.getSharedVariable()}");
        Thread incrementer2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                section2.incrementWithSync();
            }
        });
        Thread decrementer2 = new Thread(() -> {
            for (int i = 0; i < 1000; i++) {
                section2.decrementWithSync();
            }
        });

        incrementer2.start();
        decrementer2.start();

        try {
            incrementer2.join();
            decrementer2.join();
            System.out.println(STR."After: \{CriticalSection.getSharedVariable()}");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class CriticalSection {
    @Getter
    @Setter
    private static int sharedVariable = 1000;

    public CriticalSection() {
        sharedVariable = 1000;
    }

    void increment() {
        sharedVariable++;
    }

    void decrement() {
        sharedVariable--;
    }

    synchronized void incrementWithSync() {
        sharedVariable++;
    }

    synchronized void decrementWithSync() {
        sharedVariable--;
    }
}
