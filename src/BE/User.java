/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BE;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author frederik
 */
public class User implements Serializable
{
    private final int id;
    private String fname;
    private String lname;
    private String email;
    private final List<String> roles;
    
    
    public User (int id, String fname, String lname, String email, List<String> roles)
    {
        this.id = id;
        this.fname = fname;
        this.lname = lname;
        this.email = email;
        this.roles = roles;
                
    }

    public int getId() {
        return id;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getEmail() {
        return email;
    }

    public List<String> getRoles() {
        return roles;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    
}
