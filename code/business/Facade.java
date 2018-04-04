package business;

import business.bll.*;
import data.models.*;
import javax.swing.table.DefaultTableModel;
import java.util.ArrayList;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class Facade {
    private UserBLL userBLL;
    private StudentBLL studentBLL;
    private TeacherBLL teacherBLL;
    private LoginBLL loginBLL;
    private EnrollmentBLL enrollmentBLL;
    private CourseBLL courseBLL;


    public Facade(){
        userBLL = new UserBLL();
        studentBLL = new StudentBLL();
        teacherBLL = new TeacherBLL();
        loginBLL = new LoginBLL();
        enrollmentBLL = new EnrollmentBLL();
        courseBLL = new CourseBLL();
    }

    // User Operations

    public User userFindById(int id){
        return userBLL.findById(id);
    }

    public void insertUser(User user){
        userBLL.insertUser(user);

    }

    public void updateUser(User user){
        userBLL.updateUser(user);
    }

    public User userFindByLoginId(int id){ return userBLL.findByLoginId(id);}

    // Student Operations

    public Student studentFindById(int id){
        return studentBLL.findById(id);
    }

    public void insertStudent(Student student){
        studentBLL.insertStudent(student);

    }

    public void updateStudent(Student student){
        studentBLL.updateStudent(student);
    }

    public void deleteStudent(int id){
        studentBLL.deleteStudent(id);
    }

    public DefaultTableModel studentsToTable(){
        return studentBLL.studentsToTable();
    }

    // Teacher Operations

    public Teacher teacherFindById(int id){
        return teacherBLL.findById(id);
    }

    // Login Operations

    public Login loginFindById(int id){
        return loginBLL.findById(id);
    }

    public Login loginFindByUsername(String username){
        return loginBLL.findByUsername(username);
    }

    public void updateLogin(Login login){
        loginBLL.updateLogin(login);
    }

    public void insertLogin(Login login){ loginBLL.insertLogin(login);}

    // Enrollment Operations

    public Enrollment enrollmentFindById(int id){
        return enrollmentBLL.findById(id);
    }

    public boolean enrollStudent(Student student, Course course){
        return enrollmentBLL.enroll(course,student);

    }


    public boolean isEnrolled(Student student, int courseid){
        return enrollmentBLL.isEnrolled(student, courseid);
    }
    // Course Operations

    public Course courseFindById(int id){
        return courseBLL.findById(id);
    }

    public ArrayList<Course> findCourses(){
        return courseBLL.findAll();
    }

    public DefaultTableModel coursesToTable(){
        return courseBLL.courseToTable();
    }
    public DefaultTableModel studentEnrollmentsTable(Student student){
        return enrollmentBLL.enrollmentsTable(student);
    }

}
