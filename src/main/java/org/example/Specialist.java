package org.example;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

public class Specialist {
    public void response(BlockingQueue<Integer> queue) {
        while (true) {

            try {
                System.out.println("call # " + queue.poll(4000, TimeUnit.MILLISECONDS) + " serviced");
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                return;
            }
            if (queue.isEmpty()) break;
        }
    }
}
