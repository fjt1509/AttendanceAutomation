/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BLL;

import DAL.RegistrationDAO;
import java.util.Date;

/**
 *
 * @author Daniels PC
 */
public class RegistrationManager
{

    RegistrationDAO registrationDAO = new RegistrationDAO();
    
    public void register(int userID, int courseID, Date date, int isPresent)
    {
        registrationDAO.register(userID, courseID, date, isPresent);
    }
    
}
