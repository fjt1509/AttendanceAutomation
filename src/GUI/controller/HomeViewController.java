/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

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
    private Label welcomeLbl;
    @FXML
    private JFXButton detailsBtn;
    @FXML
    private Label registerSuccesfulLbl;
    @FXML
    private Label dateLbl;
    @FXML
    private Label classLbl;
    @FXML
    private ImageView easvLogo;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
    {
        easvLogo.setImage(new Image(getClass().getResourceAsStream("/res/easvlogo.png")));
        dateLbl.setText("Current date: " + sdf.format(date)); 
        //welcomeLbl.setText();
    }    
    
}
