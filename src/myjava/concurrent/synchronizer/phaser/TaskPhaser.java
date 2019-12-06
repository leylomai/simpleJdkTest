package myjava.concurrent.synchronizer.phaser;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Phaser;

public class TaskPhaser extends Phaser {
    private final static DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    TaskPhaser(int parties) {
        super(parties);
    }

    @Override
    protected boolean onAdvance(int phase, int registeredParties) {
        switch (phase) {
            case 0:
                firstPhaser();
                return false;
            case 1:
                secondPhaser();
                return false;
            case 2:
                thirdPhaser();
                return false;
                default:
                    return true;
        }
    }

    private void firstPhaser() {
        System.out.println(String.format("阶段=0, 线程=%s, 时间=%s 完成 \n", Thread.currentThread().getName(), sdf.format(new Date())));
    }

    private void secondPhaser() {
        System.out.println(String.format("阶段=1, 线程=%s, 时间=%s 完成 \n", Thread.currentThread().getName(), sdf.format(new Date())));
    }

    private void thirdPhaser() {
        System.out.println(String.format("阶段=2, 线程=%s, 时间=%s 完成 \n", Thread.currentThread().getName(), sdf.format(new Date())));
    }
}
