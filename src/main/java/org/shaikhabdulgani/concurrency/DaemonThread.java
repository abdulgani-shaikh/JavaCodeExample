package org.shaikhabdulgani.concurrency;

@SuppressWarnings("preview")
public class DaemonThread {
    public static void main() {
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 500; i++) {
                System.out.println(STR."In thread1 \{i}");
            }
            System.out.println("--------------------Thread1 ends here----------------------");
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 100000; i++) {
                System.out.println(STR."In thread2 \{i}");
            }
            System.out.println("--------------------Thread2 ends here----------------------");
        });
        thread2.setDaemon(true);

        thread1.start();
        thread2.start();
        System.out.println("--------------------Main thread ends here----------------------");
    }
}
