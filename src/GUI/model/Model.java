/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.model;

import BE.Course;
import BE.User;
import BLL.UserManager;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author frederik
 */
public class Model 
{
    private static Model model = new Model();
    
    private User currentUser;
    private UserManager usermanager = new UserManager();
    
    private ObservableList<User> listOfStudents = FXCollections.observableArrayList();
    
    
    private Model()
    {
        listOfStudents.addAll(usermanager.getAllStudents());
    }
    
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

    public List<Course> getClassesToday(User currentUser, String currentDate) 
    {
        return usermanager.getClassesToday(currentUser, currentDate);
    }

    public void registerAttendance(int courseId, int userId, String date, boolean attending, int currentWeekOfYear) 
    {
        usermanager.registerAttendance(courseId, userId, date, attending, currentWeekOfYear);
    }

    public void updateAttendance(int courseId, int userId, String date, boolean attending, int currentWeekOfYear) 
    {
        usermanager.updateAttendance(courseId, userId, date, attending, currentWeekOfYear);
    }

     public Boolean getTodaysAttendanceStatus(int userId, String date) 
    {
       return usermanager.getTodaysAttendanceStatus(userId, date);
    }


    public List<String> getAllClasses()
    {
        return usermanager.getAllClasses();
    }
    
    public ObservableList<User> getAllStudents()
    {
  
        listOfStudents.setAll(usermanager.getAllStudents());
        return listOfStudents;
    }

    public HashMap<String, Boolean> getStudentAttendance(int id) 
    {
        return usermanager.getStudentAttendance(id);
    }

    public List<User> getStudentsForClass(String className) 
    {
        listOfStudents.setAll(usermanager.getStudentsForClass(className));
        return listOfStudents;
    }
}

   

