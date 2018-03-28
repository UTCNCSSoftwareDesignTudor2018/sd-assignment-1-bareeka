package business.bll;

import data.data_access.TeacherDAO;
import data.models.Teacher;
import data.models.User;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class TeacherBLL {
    private TeacherDAO teacherDAO;

    public TeacherBLL(){
        this.teacherDAO = new TeacherDAO();
    }

    public Teacher findById(int id){
        return teacherDAO.findById(id);
    }

    public Teacher findByUser(User user){
        return teacherDAO.findByUser(user);
    }


}
