package myjava.concurrent.synchronizer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Semaphore简单来说设置了一个信号量池state，当线程执行时会从state中获取值，如果可以获取则线程执行，
 * 并且在执行后将获取的资源返回到信号量池中，并唤起其他阻塞线程；
 * 如果信号量池中的资源无法满足某个线程的需求则将此线程阻塞。
 */
public class SemaphoreLearn {
    //信号总数
    private static final int SEM_MAX = 12;

    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(SEM_MAX);

        ExecutorService threadPool = Executors.newFixedThreadPool(3);
        threadPool.submit(new MyThread(semaphore, 7));
        threadPool.submit(new MyThread(semaphore, 4));
        threadPool.submit(new MyThread(semaphore, 2));

        threadPool.shutdown();
    }
}

class MyThread extends Thread {
    private volatile Semaphore sem;
    private int count;

    MyThread(Semaphore sem, int count) {
        this.sem = sem;
        this.count = count;
    }

    @Override
    public void run() {
        try {
            sem.acquire(count);
            Thread.sleep(2000);
            System.out.println(Thread.currentThread().getName() + "acquire count = " +  count);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            sem.release(count);
            System.out.println(Thread.currentThread().getName() + "release " + count);
        }
    }
}
