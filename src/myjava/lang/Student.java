package myjava.lang;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class Student {
    private String name;
    private String age;

    public static final ThreadLocal<SimpleDateFormat> dateFormat = ThreadLocal.withInitial(() -> new SimpleDateFormat("yyyy-MM-dd"));

    public static void main(String[] args) {
        //dateFormat.get();
        List<String> list = new ArrayList<>();

    }
}
