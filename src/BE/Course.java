/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

/**
 *
 * @author Daniels PC
 */
public class Course
{
    private final int id;
    private String courseName;
    private int semester;

    public Course(int id, String courseName, int semester)
    {
        this.id = id;
        this.courseName = courseName;
        this.semester = semester;
    }

    public int getId()
    {
        return id;
    }
    
    

    public String getCourseName()
    {
        return courseName;
    }

    public void setCourseName(String courseName)
    {
        this.courseName = courseName;
    }

    public int getSemester()
    {
        return semester;
    }

    public void setSemester(int semester)
    {
        this.semester = semester;
    }
    
    
    
    
}
