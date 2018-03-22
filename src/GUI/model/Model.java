/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import BE.User;
import BLL.UserManager;

/**
 *
 * @author frederik
 */
public class Model 
{
    
    private UserManager usermanager = new UserManager();
    
    public User login(String username, String password) 
    {
        return usermanager.login(username, password);
    }
    
    
}
