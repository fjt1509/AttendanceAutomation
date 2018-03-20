/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controller;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Frederik Tubæk
 */
public class StudentViewController implements Initializable {

    @FXML
    private AnchorPane toolAnchorPane;
    @FXML
    private ImageView easvLogoImage;

    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    @FXML
    private Label dateLbl;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        easvLogoImage.setImage(new Image(getClass().getResourceAsStream("/res/easv.png")));
        dateLbl.setText(sdf.format(date));
        
    }    
    
}
