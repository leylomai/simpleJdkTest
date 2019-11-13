package myjava.concurrent;

public class Odd_Even_Demo {
    public synchronized void printEven() {
        try {
            System.out.println("0");
            //Thread.sleep(5000);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public synchronized void printOdd() {
        try {
            System.out.println("1");
            //Thread.sleep(10000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        /** method 1 */
        /*Odd_Even_Print oddEvenPrint = new Odd_Even_Print();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    oddEvenPrint.printOddEven();
            }
        }, "thread-1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true)
                    oddEvenPrint.printOddEven();
            }
        }, "thread-2");
        t1.start();
        t2.start();*/

        /** method 2 */
        Odd_Even_Print oddEvenPrint1 = new Odd_Even_Print();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                synchronized (this) {
                    try {
                        while (oddEvenPrint1.count <=100) {
                            notify();
                            System.out.println(oddEvenPrint1.count++ + "====" + Thread.currentThread().getName());
                            wait();
                        }

                        if (oddEvenPrint1.count >= 100) {
                            System.exit(0);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }

            }
        };

        Thread thread1 = new Thread(runnable, "thread-1");
        Thread thread2 = new Thread(runnable, "thread-2");
        thread1.start();
        thread2.start();

    }
}
