/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import BE.Course;
import BE.User;
import DAL.UserDAO;
import java.util.HashMap;
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

    public List<Course> getClassesToday(User currentUser, String currentDate) 
    {
        return userdao.getClassesToday(currentUser, currentDate);
    }

    public void registerAttendance(int courseId, int userId, String date, boolean attending, int currentWeekOfYear) 
    {
        userdao.registerAttendance(courseId, userId, date, attending, currentWeekOfYear);
    }

    public Boolean getTodaysAttendanceStatus(int userId, String date) 
    {
        return userdao.getTodaysAttendanceStatus(userId, date);
    }

    public void updateAttendance(int courseId, int userId, String date, boolean attending, int currentWeekOfYear) 
    {
        userdao.updateAttendance(courseId, userId, date, attending, currentWeekOfYear);    
    }

    public List<String> getAllClasses()
    {
        return userdao.getAllClasses();
    }

    public List<User> getAllStudents() 
    {
        return userdao.getAllStudents();
    }

    public HashMap<String, Boolean> getStudentAttendance(int id) 
    {
        return userdao.getStudentAttendance(id);
    }

    public List<User> getStudentsForClass(String className) 
    {
        return userdao.getStudentsForClass(className);
    }
    
}
