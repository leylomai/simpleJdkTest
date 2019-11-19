package myjava.concurrent.concurrentMapEntry;

public class StudentEntity {
    private String studentName;
    private String subject;
    private Integer score;

    {
        System.out.println("111");
    }

    public StudentEntity() {
        System.out.println("222");
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }
}
