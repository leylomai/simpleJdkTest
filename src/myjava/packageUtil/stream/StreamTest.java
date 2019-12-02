package myjava.packageUtil.stream;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        /*Student stu1 = new Student("stu1", "1");
        Student stu2 = new Student("stu2", "2");

        List<Student> studentList = new ArrayList<>();
        List<Map<String, String>> list = studentList.parallelStream().<Map<String, String>>map(new Function<Student, Map<String, String>>() {
            @Override
            public Map<String, String> apply(Student student) {
                Map<String, String> map = new HashMap<>();
                map.put("name", student.getName());
                map.put("age", student.getAge());
                return map;
            }
        }).collect(Collectors.toList());*/
        try {
            long stamp1 = System.currentTimeMillis();
            String str1 = String.valueOf(stamp1);
            System.out.println(str1);

            Thread.sleep(100);

            long stamp2 = System.currentTimeMillis();
            String str2 = String.valueOf(stamp2);
            System.out.println(str2);

            Set<String> set = new HashSet<>();
            set.add(str1);
            set.add(str2);

            long result = set.stream().mapToLong(string -> {return Long.valueOf(string);}).min().getAsLong();
            System.out.println(result);
        } catch (Exception e) {

        }

    }

    static class Student {
        private String name;
        private String age;

        public Student (String name, String age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getAge() {
            return age;
        }

        public void setAge(String age) {
            this.age = age;
        }
    }
}
