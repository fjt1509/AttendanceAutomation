/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import BE.Registration;
import BE.User;
import BLL.RegistrationManager;
import BLL.UserManager;
import java.util.Date;

/**
 *
 * @author frederik
 */
public class Model 
{
    
    private UserManager usermanager = new UserManager();
    private RegistrationManager registrationManager = new RegistrationManager();
    
    public User login(String username, String password) 
    {
        return usermanager.login(username, password);
    }


    
    public void register(int userID, Date date, int isPresent)
    {
        registrationManager.register(userID, date, isPresent);
        
    
    }

  
    
    
}
