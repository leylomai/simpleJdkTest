package myjava.concurrent.synchronizer.phaser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Task implements Runnable {
    private final static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    private TaskPhaser phaser;

    Task(TaskPhaser phaser) {
        this.phaser = phaser;
    }

    @Override
    public void run() {
        //第一阶段
        firstPhaseWork();
        phaser.arriveAndAwaitAdvance();
        //第二阶段
        secondPhaseWork();
        phaser.arriveAndAwaitAdvance();
        //第三阶段
        thirdPhaseWork();
        phaser.arriveAndAwaitAdvance();
    }

    private void firstPhaseWork() {
        System.out.println(String.format("阶段=%s，线程=%s，时间=%s 正在执行", phaser.getPhase(), Thread.currentThread().getName(), sdf.format(new Date())));
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void secondPhaseWork() {
        System.out.println(String.format("阶段=%s，线程=%s，时间=%s 正在执行", phaser.getPhase(), Thread.currentThread().getName(), sdf.format(new Date())));
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void thirdPhaseWork() {
        System.out.println(String.format("阶段=%s，线程=%s，时间=%s 正在执行", phaser.getPhase(), Thread.currentThread().getName(), sdf.format(new Date())));
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
