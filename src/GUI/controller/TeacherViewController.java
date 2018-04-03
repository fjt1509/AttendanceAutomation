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
import com.jfoenix.controls.JFXTextField;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
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
    private ListView<?> studentListView;
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
    private JFXTextField searchTxtField;

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
      
      
 
    }    

    @FXML
    private void searchEvent(ActionEvent event)
    {
        /*
     FilteredList filter = new FilteredList(studentListView.getItems(), e -> true);
        searchTxtField.textProperty().addListener((observable, oldValue, newValue) -> 
        {

            filter.setPredicate((Predicate<? super User>) (User user) -> {

                if (newValue.isEmpty() || newValue == null) 
                {
                    return true;
                } else if (user.getFname().toLowerCase().contains(newValue.toLowerCase())) {
                    return true;
                } else
                {
                    return false;
                }
                

                
            });
            SortedList sort = new SortedList(filter);
            sort.comparatorProperty().bind(studentListView.comparatorProperty());

            studentListView.setItems(sort);   
        }*/
    }
        
}
           
    

