/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAL;

import BE.User;
import com.microsoft.sqlserver.jdbc.SQLServerException;
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


    public User login(String username, String password) 
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
                int id = rs.getInt("id");
                String fname = rs.getString("fname");
                String lname = rs.getString("lname");
                String email = rs.getString("email");
                List<String> roles = getUserRoles(id);
                
                User user = new User(id, fname, lname, email, roles);
                return user;
            }
        }   
        catch (SQLException ex)     
        {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);    
        }
        return null;
    }

    private List<String> getUserRoles(int id) 
    {
        try (Connection con = dbConnector.getConnection()) 
        {
            String sql = "SELECT r.position\n" +
                         "FROM Users u join UserRole ur on u.id = ur.userId\n" +
                         "join Roles r on ur.roleId = r.id\n" +
                         "WHERE u.id = ?";   
            
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1, id);
            
            ResultSet rs = statement.executeQuery();
            List<String> roles = new ArrayList<>();
            
            while(rs.next())
            {
                roles.add(rs.getString("position"));
            }
        return roles;                           
        }       
        catch (SQLException ex) 
        {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
       
    }

    public List<String> getClassesToday(User currentUser, String currentDate) 
    {
        try (Connection con = dbConnector.getConnection()) 
        {
            String sql = "SELECT c.name\n" +
                         "FROM Users u join ClassUser cu on u.id = cu.userId \n" +
                         "              join Class cl on cu.classId = cl.id\n" +
                         "              join ClassCourse cc on cl.id = cc.classId\n" +
                         "              join Course c on cc.courseId = c.id\n" +
                         "WHERE u.id = ? AND cc.dayOfWeek = ?";   
            
            PreparedStatement statement = con.prepareStatement(sql);
            
            statement.setInt(1,currentUser.getId());
            statement.setString(2, currentDate);
            
            ResultSet rs = statement.executeQuery();
            List<String> classesToday = new ArrayList<>();  
            
            while(rs.next())
            {
                classesToday.add(rs.getString("name"));
            }
            return classesToday;
        
        }       
        catch (SQLException ex) 
        {
                Logger.getLogger(UserDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
