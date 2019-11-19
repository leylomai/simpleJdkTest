package myjava.concurrent.concurrentMapEntry;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ConcurrentMappingEntry {
    public static void main(String[] args) {
        /*Map<String, String> map = new ConcurrentHashMap<>();
        map.put("1", "2");
        String oldValue = map.putIfAbsent("1", "1");

        System.out.println(oldValue);*/

        StatStudentEntity statStudentEntity = new StatStudentEntity();
        statStudentEntity.normalMethod();
        statStudentEntity.mergeMethod();

    }
}
