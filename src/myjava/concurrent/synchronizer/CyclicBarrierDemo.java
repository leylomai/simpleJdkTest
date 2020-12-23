package myjava.concurrent.synchronizer;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclicBarrierDemo {
    //一个士兵
    public static class Soldier implements Runnable {
        private String soldier;
        private final CyclicBarrier cyclicBarrier;

        public Soldier(CyclicBarrier cyclicBarrier, String soldier) {
            this.cyclicBarrier = cyclicBarrier;
            this.soldier = soldier;
        }

        @Override
        public void run() {
            try {
                //士兵集合，所有士兵集合完毕（线程同步）后，执行BarrierRun线程
                cyclicBarrier.await();
                //执行任务
                doWork();
                //所有士兵任务完成（线程同步）后，执行BarrierRun线程
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }

        private void doWork() {
            try {
                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
            } catch (Exception e) {
                e.printStackTrace();
            }
            System.out.println(soldier + ":任务完成");
        }
    }

    public static class BarrierRun implements Runnable {
        boolean flag;
        int N;
        public BarrierRun(boolean flag, int N) {
            this.flag = flag;
            this.N = N;
        }

        @Override
        public void run() {
            if (flag) {
                System.out.println("司令:[士兵" + N + "个，任务完成！");
            } else {
                System.out.println("司令:[士兵" + N + "个，集合完毕！");
                flag = true;
            }
        }
    }

    public static void main(String[] args) {
        final int N = 10;
        Thread[] allSoldiers = new Thread[N];
        boolean flag = false;
        //线程到达屏障时，回调BarrierRun
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(flag, N));
        System.out.println("集合队伍！");
        for (int i=0; i<N; i++) {
            System.out.println("士兵" + i + "报到！");
            allSoldiers[i] = new Thread(new Soldier(cyclicBarrier, "士兵"+i));
            allSoldiers[i].start();
        }
    }
}
