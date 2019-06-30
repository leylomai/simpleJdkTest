package myjava.packageUtil;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class CounyLongWords {

    public static void main(String[] args) {
        try {
            Path path = Paths.get("E:\\iot\\FileOfCmiot", "100059999270000007_cardUsageDaily_20190421_md5.txt");
            String contents = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
            String[] stringArray = contents.split("\\PL+");
            List<String> list = Arrays.asList(stringArray);
            long count = 0;
            for (String w : list) {
                //System.out.println(w);
                if (w.length() >= 2) {
                    count++;
                }
            }
            System.out.println(count);

            count = list.stream().filter(w -> w.length() >= 2).count();
            System.out.println(count);

            count = list.parallelStream().filter(w -> w.length() >= 2).count();
            System.out.println(count);

            Stream.generate(new Supplier<Object>() {
                @Override
                public Object get() {
                    return null;
                }
            });
        } catch (Exception e) {
            System.out.println(e.getMessage());

        }

    }
}
