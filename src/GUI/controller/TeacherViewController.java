/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controller;

import BE.User;
import GUI.model.Model;
import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.Properties;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import static sun.net.www.http.HttpClient.New;

/**
 * FXML Controller class
 *
 * @author Kent Juul
 */
public class TeacherViewController implements Initializable
{

    private String attendanceAxis;
    private String daysAxis;
    
    
    @FXML
    private JFXButton editStudentBtn;
 
    @FXML
    private AnchorPane toolAnchorPane1;
    @FXML
    private ImageView easvLogoImage;
    @FXML
    private FontAwesomeIconView userIcon;
    @FXML
    private FontAwesomeIconView absenceIcon;
    @FXML
    private Label timeLbl;
    @FXML
    private JFXComboBox<String> classComboBox;
    
    private Model model = Model.getInstance();
    @FXML
    private TableView<User> studentTableView;
    @FXML
    private TableColumn<User, String> studentNameColumn;
    @FXML
    private TableColumn<User, Integer> studentAbsenceColumn;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb)
            
    {
      easvLogoImage.setImage(new Image(getClass().getResourceAsStream("/res/easv.png")));  
      
      classComboBox.getItems().add("All Students");
      classComboBox.getItems().addAll(model.getAllClasses());
      classComboBox.getSelectionModel().select("All Students");
      
      
      studentTableView.getItems().addAll(model.getAllStudents());
      studentNameColumn.setCellValueFactory(new PropertyValueFactory(""));
      
     
     
 
    }    
    
}
