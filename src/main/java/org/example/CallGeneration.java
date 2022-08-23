package org.example;

import java.util.concurrent.BlockingQueue;

public class CallGeneration {
    public static int callsPerSecond = 60;

    public void toGenerate(BlockingQueue<Integer> queue) {
        int count = 1;
        while (count < 105) {
            for (int i = 0; i < callsPerSecond; i++) {
                if (count == 105) break;
                try {
                    queue.put(count);
                    System.out.println("new call #" + count);
                    count++;
                } catch (InterruptedException e) {
                    return;
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
