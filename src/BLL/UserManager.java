/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.UserDAO;

/**
 *
 * @author frederik
 */
public class UserManager {
    
    private UserDAO userdao = new UserDAO();

    public boolean login(String username, String password) 
    {
        return userdao.login(username, password);
    }
    
}
