package myjava.concurrent.concurrentMapEntry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;

public class ConcurrentMappingEntry {
    public static void main(String[] args) {
        Map<String, String> map = new ConcurrentHashMap<>();
        //map.put("1", "2");
        //String oldValue = map.putIfAbsent("1", "1");
        String oldValue = map.computeIfAbsent("1", new Function<String, String>() {
            @Override
            public String apply(String s) {
                System.out.println("parameter s = [" + s + "]");
                return null;
            }
        });

        System.out.println(oldValue + "###" + map.get("1"));

        /*StatStudentEntity statStudentEntity = new StatStudentEntity();
        statStudentEntity.normalMethod();
        statStudentEntity.mergeMethod();*/

    }
}
