/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author frederik
 */
public class UserDAO {
    
        private DataBaseConnector dbConnector;

    public UserDAO() 
    {
            try 
            {
                dbConnector = new DataBaseConnector();
            } catch (IOException ex) 
            {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public boolean login(String username, String password) 
    {
       return false; 
    }
    
    
}
