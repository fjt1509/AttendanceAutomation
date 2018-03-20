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
            try {
                dbConnector = new DataBaseConnector();
            } catch (IOException ex) 
            {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }

    public boolean login(String username, String password)
    {    
        if(loginVerification(username, password))
        {
            System.out.println("you've logged in");
            return true;

        }

          
        return false;
    }

    private boolean loginVerification(String username, String password) 
    {
        try (Connection con = dbConnector.getConnection()) 
        {
            String sql = "SELECT * FROM Users WHERE username = ? AND password = ?"; 
            
            PreparedStatement statement = con.prepareStatement(sql);

            statement.setString(1, username);
            statement.setString(2, password);
            
            ResultSet rs = statement.executeQuery();
            
            while(rs.next())
            {
                return true;
            }
        }   
        catch (SQLException ex)     
        {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);    
        }
        return false;
    }
    
    
}
