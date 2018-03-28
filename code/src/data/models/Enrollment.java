package data.models;

/**
 * Created by Mortimer on 3/27/2018.
 */
public class Enrollment {
    private int id;
    private int student_id;
    private int course_id;
    private int grade;

    public Enrollment(){
        
    }

    public Enrollment(int id, int student_id, int course_id, int grade) {
        this.id = id;
        this.student_id = student_id;
        this.course_id = course_id;
        this.grade = grade;
    }

    public String toString(){
        return "Enrollment [id=" + id + ", student id=" + student_id + ", taught course id:" + course_id + "]";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudent_id() {
        return student_id;
    }

    public void setStudent_id(int student_id) {
        this.student_id = student_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }
}
