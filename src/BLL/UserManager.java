/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.User;
import DAL.UserDAO;
import java.util.List;

/**
 *
 * @author frederik
 */
public class UserManager {
    
    private UserDAO userdao = new UserDAO();

    public User login(String username, String password) 
    {
        return userdao.login(username, password);
    }

    public List<String> getClassesToday(User currentUser, String currentDate) 
    {
        return userdao.getClassesToday(currentUser, currentDate);
    }
    
}
