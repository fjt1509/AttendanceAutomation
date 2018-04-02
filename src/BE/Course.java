/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.io.Serializable;

/**
 *
 * @author Frederik Tubæk
 */
public class Course implements Serializable {
    
    private final int id;
    private String name;
    private int semester;
    
    public Course(int id, String name, int semester)
    {
        this.id = id;
        this.name = name;
        this.semester = semester;       
    }

    public int getId() 
    {
        return id;
    }

    public String getName() 
    {
        return name;
    }

    public int getSemester() 
    {
        return semester;
    }
    
    
       
    
}
