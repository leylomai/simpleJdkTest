package myjava.concurrent.condition;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.function.IntConsumer;
import java.util.stream.IntStream;

public class LockDemo {
    private static Lock lock = new ReentrantLock();
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

    public static void main(String[] args) {
        IntStream.range(0, 5).parallel().forEach(new IntConsumer() {
            @Override
            public void accept(int value) {
                executorService.execute(new LockDemoThread(value));
            }
        });

        /*try {
            Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }*/
    }

    private static class LockDemoThread implements Runnable {
        private Integer count;

        public LockDemoThread(Integer count) {
            this.count = count;
        }

        @Override
        public void run() {
            try {
                lock.lock();
                System.out.println(count + " acquire lock");
                Thread.sleep(1000000);
            } catch (Exception e) {
                e.printStackTrace();
            } finally {
                lock.unlock();
                System.out.println(count + " release lock");
            }
        }
    }
}
