/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import BE.User;
import BLL.UserManager;
import java.util.Date;
import java.util.List;

/**
 *
 * @author frederik
 */
public class Model 
{
    private static Model model = new Model();
    
    private User currentUser;
    private UserManager usermanager = new UserManager();
    
    
    private Model(){}
    
    public static Model getInstance()
    {
        return model;
    }
    
    
    public User login(String username, String password) 
    {
        currentUser = usermanager.login(username, password);
        return currentUser;
    }

    public User getCurrentUser() 
    {
        return currentUser;
    }
    public void logoutUser()
    {
        currentUser = null;
    }

    public List<String> getClassesToday(User currentUser, String currentDate) 
    {
        return usermanager.getClassesToday(currentUser, currentDate);
    }
    

  
    
    
}
