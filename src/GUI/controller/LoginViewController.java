/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controller;

import GUI.model.Model;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author Frederik Tubæk
 */
public class LoginViewController implements Initializable {
    
    private Label label;
    @FXML
    private AnchorPane loginAnchorPane;
    @FXML
    private ImageView backgroundImage;
    @FXML
    private ImageView easvLogoImage;
    @FXML
    private JFXTextField userTxtfield;
    @FXML
    private JFXPasswordField passTxtfield;
    
    private Model model = new Model();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        backgroundImage.setImage(new Image(getClass().getResourceAsStream("/res/loginscreen.jpg")));
        easvLogoImage.setImage(new Image(getClass().getResourceAsStream("/res/easv.png")));
        
    }    

    @FXML
    private void loginEvent(ActionEvent event) 
    {
        String username = userTxtfield.getText();
        String password = passTxtfield.getText();
        
       boolean access = model.login(username, password);
        
    }
    
}
