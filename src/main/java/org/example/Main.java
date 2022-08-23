package org.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static final int callQueueSize = 100;

    public static void main(String[] args) throws InterruptedException {

        BlockingQueue<Integer> call = new ArrayBlockingQueue<>(callQueueSize);

        CallGeneration callGeneration = new CallGeneration();
        Specialist specialist = new Specialist();

        Thread thread1 = new Thread(() -> {
            callGeneration.toGenerate(call);
        });


        Thread thread2 = new Thread(() -> {
            specialist.response(call);
        });

        Thread thread3 = new Thread(() -> {
            specialist.response(call);
        });

        Thread thread4 = new Thread(() -> {
            specialist.response(call);
        });

        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();

        thread1.join();
        thread2.join();
        thread3.join();
        thread4.join();

        System.out.println("All calls ended");
    }
}