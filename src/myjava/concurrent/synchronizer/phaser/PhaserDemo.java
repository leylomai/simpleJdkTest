package myjava.concurrent.synchronizer.phaser;

public class PhaserDemo {
    public static void main(String[] args) {
        int parties = 3;

        TaskPhaser phaser = new TaskPhaser(parties);

        Thread thread = null;

        for (int i=0; i<parties; i++) {
            thread = new Thread(new Task(phaser), "thread"+i);
            thread.start();
        }
    }
}
