package myjava.concurrent.condition;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockDemo {
    private static Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        try {
            lock.lock();

            Thread.sleep(10);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}
