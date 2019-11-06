package myjava.concurrent;

public class Demo {
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
        Demo demo = new Demo();
        Thread t1 = new Thread(() -> {
            demo.printEven();
        });
        Thread t2 = new Thread(() -> {
           demo.printOdd();
        });

        t1.start();
        t2.start();
    }
}
