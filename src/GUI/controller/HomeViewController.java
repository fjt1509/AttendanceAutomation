/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

/**
 * FXML Controller class
 *
 * @author Kent Juul
 */
public class HomeViewController implements Initializable
{

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
        // TODO
    }    
    
}
