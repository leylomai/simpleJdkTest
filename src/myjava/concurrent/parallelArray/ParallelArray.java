package myjava.concurrent.parallelArray;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;

public class ParallelArray {
    public static void main(String[] args) {
        try {
            byte[] bytes = Files.readAllBytes(Paths.get("F:\\alice.txt"));
            String contents = new String(bytes, StandardCharsets.UTF_8);
            String[] words = contents.split("[\\P{L}]+");          //split along nonletters
            //Arrays.parallelSort(words);
            Arrays.parallelSort(words, Comparator.comparing(String::length));

            for (String word : words) {
                System.out.println(word);
            }
        } catch (Exception e) {

        }

    }
}
