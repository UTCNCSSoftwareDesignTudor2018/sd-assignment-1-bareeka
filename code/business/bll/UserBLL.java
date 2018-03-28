package business.bll;

import data.data_access.UserDAO;
import data.models.User;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class UserBLL {
    private UserDAO userDAO;

    public UserBLL(){
        this.userDAO = new UserDAO();
    }

    public User findById(int id){
        return userDAO.findById(id);
    }

    public void updateUser(User user){
        userDAO.update(user);
    }

    public void insertUser(User user){
        userDAO.insert(user);
    }


}
