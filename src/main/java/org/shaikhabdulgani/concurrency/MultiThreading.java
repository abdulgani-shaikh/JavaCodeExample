package org.shaikhabdulgani.concurrency;

public class MultiThreading {
    public static void main(String[] args) {
        Thread1 thread1 = new Thread1();
        Thread thread2 = new Thread(new Thread2());

        thread1.start();
        thread2.setName("Thread2");
        thread2.setPriority(10);
        thread2.start();
    }
}

class Thread1 extends Thread {
    @Override
    public void run() {
        System.out.println("Thread1 is created by extending Thread class.");
        System.out.println("--------------------Thread1 starts here----------------------");
        for (int i = 0; i < 500; i++) {
            System.out.println(STR."In thread1 \{i}");
        }
        System.out.println("--------------------Thread1 ends here----------------------");
    }
}

class Thread2 implements Runnable {

    @Override
    public void run() {
        System.out.println("Thread2 is created by implementing Runnable interface.");
        System.out.println("--------------------Thread2 starts here----------------------");
        for (int i = 0; i < 500; i++) {
            System.out.println(STR."In thread2 \{i}");
        }
        System.out.println("--------------------Thread2 ends here----------------------");
    }
}
