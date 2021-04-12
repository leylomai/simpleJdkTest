package myjava.concurrent.threadPool;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.concurrent.*;

public class Test {
    private static TimingThreadPool timingThreadPool = new TimingThreadPool(8, 8,
            0, TimeUnit.SECONDS, new ArrayBlockingQueue<>(100000), Executors.defaultThreadFactory(),
            new ThreadPoolExecutor.CallerRunsPolicy());

    public static void main(String[] args) {
        File file = new File("F:\\offlineLocation\\23g.log");
        try (FileInputStream fis = new FileInputStream(file);
             InputStreamReader isr = new InputStreamReader(fis);
             BufferedReader br = new BufferedReader(isr)) {

            String content = null;

            while (null != (content = br.readLine())) {
                timingThreadPool.execute(new TestThread(content));
            }
        } catch (Exception e) {

        } finally {
            timingThreadPool.shutdown();
        }
    }

    private static class TestThread implements Runnable {
        private String content;

        public TestThread(String content) {
            this.content = content;
        }

        @Override
        public void run() {

        }
    }
}
