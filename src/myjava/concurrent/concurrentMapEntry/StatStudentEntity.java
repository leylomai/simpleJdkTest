package myjava.concurrent.concurrentMapEntry;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StatStudentEntity {
    public List<StudentEntity> buildTestList() {
        List<StudentEntity> studentEntityList = new ArrayList<>();
        StudentEntity studentEntity1 = new StudentEntity(){
            {
                setStudentName("张三");
                setSubject("语文");
                setScore(60);
            }
        };
        StudentEntity studentEntity2 = new StudentEntity(){
            {
                setStudentName("张三");
                setSubject("数学");
                setScore(70);
            }
        };
        StudentEntity studentEntity3 = new StudentEntity(){
            {
                setStudentName("张三");
                setSubject("英语");
                setScore(80);
            }
        };
        StudentEntity studentEntity4 = new StudentEntity(){
            {
                setStudentName("李四");
                setSubject("语文");
                setScore(85);
            }
        };
        StudentEntity studentEntity5 = new StudentEntity(){
            {
                setStudentName("李四");
                setSubject("数学");
                setScore(75);
            }
        };
        StudentEntity studentEntity6 = new StudentEntity(){
            {
                setStudentName("李四");
                setSubject("英语");
                setScore(65);
            }
        };
        StudentEntity studentEntity7 = new StudentEntity(){
            {
                setStudentName("王五");
                setSubject("语文");
                setScore(80);
            }
        };
        StudentEntity studentEntity8 = new StudentEntity(){
            {
                setStudentName("王五");
                setSubject("数学");
                setScore(85);
            }
        };
        StudentEntity studentEntity9 = new StudentEntity(){
            {
                setStudentName("王五");
                setSubject("英语");
                setScore(90);
            }
        };

        studentEntityList.add(studentEntity1);
        studentEntityList.add(studentEntity2);
        studentEntityList.add(studentEntity3);
        studentEntityList.add(studentEntity4);
        studentEntityList.add(studentEntity5);
        studentEntityList.add(studentEntity6);
        studentEntityList.add(studentEntity7);
        studentEntityList.add(studentEntity8);
        studentEntityList.add(studentEntity9);

        return studentEntityList;
    }

    public void normalMethod() {
        Long startTime = System.currentTimeMillis();
        // 造一个学生成绩列表
        List<StudentEntity> studentEntityList = buildTestList();

        Map<String, Integer> studentScore = new HashMap<>();
        studentEntityList.forEach(studentEntity -> {
            if (studentScore.containsKey(studentEntity.getStudentName())) {
                studentScore.put(studentEntity.getStudentName(),
                        studentScore.get(studentEntity.getStudentName()) + studentEntity.getScore());
            } else {
                studentScore.put(studentEntity.getStudentName(), studentEntity.getScore());
            }
        });
        System.out.println("各个学生的成绩：{" + studentScore + "}，耗时：{" + (System.currentTimeMillis()-startTime) + "}");
    }

    public void mergeMethod() {
        Long startTime = System.currentTimeMillis();

        List<StudentEntity> studentEntityList = buildTestList();
        Map<String, Integer> studentScore = new HashMap<>();

        /*studentEntityList.forEach(studentEntity -> {
            studentScore.merge(studentEntity.getStudentName(), studentEntity.getScore(), new BiFunction<Integer, Integer, Integer>() {
                @Override
                public Integer apply(Integer integer, Integer integer2) {
                    return Integer.sum(integer, integer2);
                }
            });
        });*/
        studentEntityList.parallelStream().forEach(studentEntity -> {
            studentScore.merge(studentEntity.getStudentName(), studentEntity.getScore(), Integer::sum);
        });

        System.out.println("各个学生的成绩：{" + studentScore + "}，耗时：{" + (System.currentTimeMillis()-startTime) + "}");
    }
}
