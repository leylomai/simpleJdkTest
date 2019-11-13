package myjava.concurrent;

public class Odd_Even_Print {
    public int count = 1;

    public synchronized void printOddEven() {
        try {
            notifyAll();
            System.out.println(count++ + "====" + Thread.currentThread().getName());
            wait();

            if (count > 100) {
                System.exit(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
