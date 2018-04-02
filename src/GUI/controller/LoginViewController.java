/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controller;

import BE.User;
import GUI.model.Model;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

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
    @FXML
    private Label loginErrorLbl;
    @FXML
    private JFXButton loginBtn;  
    
    private Model model = Model.getInstance();
    
    private String nextView;
    private String style;
    


    
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
        
        User currentUser = model.login(username, password);
       
    
        
        if(currentUser != null)
        {
            for (String roles : currentUser.getRoles()) 
            {   
                if(roles.equals("Teacher"))
                { 
                    nextView = "/GUI/view/TeacherView.fxml";
                    style = "res/TeacherView.css";
                    loadNextView();
                    Stage stage = (Stage) loginBtn.getScene().getWindow();
                    stage.close();
                }           
                else if (roles.equals("Student"))
                {
                    nextView = "/GUI/view/StudentView.fxml";
                    style = "res/StudentView.css";
                    loadNextView();    
                    Stage stage  = (Stage) loginBtn.getScene().getWindow();
                    stage.close();
                }
            
            }
        }
        else
        {
            loginErrorLbl.setText("*Wrong Username or Password");
        }    
    }
    
    private void loadNextView()
    {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource(nextView));
            Parent root = (Parent) fxmlLoader.load();
            Stage stage = new Stage();
            Scene scene = new Scene(root);
            scene.getStylesheets().add(style);
            stage.setScene(scene);
                    
            stage.show();
        } catch (IOException ex) {
            Logger.getLogger(LoginViewController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
            
}
