package business.bll;

import data.data_access.LoginDAO;
import data.models.Login;

/**
 * Created by Mortimer on 3/28/2018.
 */
public class LoginBLL {

    private LoginDAO loginDAO;

    public LoginBLL(){
        loginDAO = new LoginDAO();
    }

    public Login findById(int id){
        return loginDAO.findById(id);
    }

    public Login findByUsername(String username){
        return loginDAO.findByUsername(username);
    }

    public  void updateLogin(Login login){
        loginDAO.update(login);
    }

    public void insertLogin(Login login){ loginDAO.insert(login);}
}
