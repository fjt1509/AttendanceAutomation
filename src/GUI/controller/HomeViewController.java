/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controller;

import BE.Course;
import BE.Registration;
import BE.User;
import GUI.model.Model;
import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Kent Juul
 */
public class HomeViewController implements Initializable
{
    
    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    

    @FXML
    private JFXButton submitBtn;
    @FXML
    private JFXButton detailsBtn;
    @FXML
    private Label registerSuccesfulLbl;
    private Label dateLbl;
    @FXML
    private ImageView easvLogo;
    @FXML
    private ImageView backgroundImage;
    @FXML
    private AnchorPane redAnchorPane;
    @FXML
    private Label notYetRegisteredlbl;
    
    
    Model model = new Model();
    LoginViewController loginViewController = new LoginViewController();
    User user;
    Course course;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        backgroundImage.setImage(new Image(getClass().getResourceAsStream("/res/loginscreen.jpg")));
        easvLogo.setImage(new Image(getClass().getResourceAsStream("/res/easv.png")));
        //dateLbl.setText("Current date: " + sdf.format(date)); 
        //welcomeLbl.setText();
        registerSuccesfulLbl.setVisible(false);
        notYetRegisteredlbl.setVisible(true);
    }    

    @FXML
    private void submitAttendanceActionEvent(ActionEvent event)
    {
        registerSuccesfulLbl.setVisible(true);
        notYetRegisteredlbl.setVisible(false);
        
        
        int userID = user.getId();
        int courseID = course.getId();
        Date date = sdf.get2DigitYearStart();
        int isPresent = 1;
        
        model.register(userID, courseID, date, isPresent);
        
        
        
    }
    
}
