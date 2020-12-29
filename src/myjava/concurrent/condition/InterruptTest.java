package myjava.concurrent.condition;

import java.util.concurrent.locks.LockSupport;

public class InterruptTest {

    public static void main(String[] args) {
        Thread t = new Thread(new Work());
        t.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t.interrupt();
        System.out.println("main thread stop");
    }

    private static class Work implements Runnable {
        @Override
        public void run() {
            System.out.println("work start");
            LockSupport.park();
            System.out.println("wake up:" + Thread.currentThread().isInterrupted());

        }
    }
}
