package myjava.concurrent.callableFuture;

import java.io.File;
import java.util.Scanner;
import java.util.concurrent.FutureTask;

public class FutureTest {

    public static void main(String[] args) {
        try (Scanner in = new Scanner(System.in)) {
            System.out.print("Enter base directory(e.g. /opt/jdk1.8.0/src):");
            String directory = in.nextLine();
            System.out.print("Enter keyword(e.g. volatile):");
            String keyword = in.nextLine();

            MatchCounter counter = new MatchCounter(new File(directory), keyword);
            FutureTask<Integer> task = new FutureTask<>(counter);
            Thread t = new Thread(task);
            t.start();

            try {
                System.out.println(task.get() + " matching files.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
