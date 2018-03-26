/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Daniels PC
 */
public class Registration implements Serializable
{

    private final int userID;
    private final int courseID;
    private Date date;
    private int isPresent;

    public Registration(int userID, int courseID, Date date, int isPresent)
    {
        this.userID = userID;
        this.courseID = courseID;
        this.date = date;
        this.isPresent = isPresent;
    }

    public int getUserID()
    {
        return userID;
    }

    public int getCourseID()
    {
        return courseID;
    }

    public Date getDate()
    {
        return date;
    }

    public void setDate(Date date)
    {
        this.date = date;
    }

    public int getIsPresent()
    {
        return isPresent;
    }

    public void setIsPresent(int isPresent)
    {
        this.isPresent = isPresent;
    }

}
