package org.shaikhabdulgani.concurrency;

public class ProducerConsumer {

    static int queueSize = 0;
    static int maxCap = 20;

    public static void main(String[] args) {

        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread producerThread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    producerConsumer.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        Thread consumerThread = new Thread(() -> {
            for (int i = 0; i < 20; i++) {
                try {
                    producerConsumer.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        producerThread.start();
        consumerThread.start();

    }

    public synchronized void produce() throws InterruptedException {
        if (queueSize>=maxCap){
            wait(100);
        }
        if (queueSize>=maxCap) {
            System.out.printf("%d item is present.%n", queueSize++);
            System.out.printf("%d item after producing.%n", queueSize);
        }
        queueSize++;
        notifyAll();
        Thread.sleep(100);
    }

    public synchronized void consume() throws InterruptedException {
        if (queueSize==0){
            wait();
        }
        if (queueSize>0) {
            System.out.printf("%d item is present.%n",queueSize--);
            System.out.printf("%d item is remaining after consumption.%n",queueSize);
        }
        notifyAll();
        Thread.sleep(100);
    }

}
