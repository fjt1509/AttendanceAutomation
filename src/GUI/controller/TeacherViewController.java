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
import java.util.HashMap;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.function.Predicate;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SplitMenuButton;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
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
    private int present;
    
    
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

    @FXML
    private JFXTextField searchTxtField;
    @FXML
    private AnchorPane backgroundPane;
    @FXML
    private PieChart absencePieChart;

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
      studentNameColumn.setCellValueFactory(new PropertyValueFactory("fullName"));
      
      tableViewEventHandler();
      
      
    }    


    @FXML 
     private void searchEvent(KeyEvent event) 
    {
        FilteredList filter = new FilteredList(studentTableView.getItems(), e -> true);
        searchTxtField.textProperty().addListener((observable, oldValue, newValue) -> {

            filter.setPredicate((Predicate<? super User>) (User user) -> 
            {
                if (newValue.isEmpty() || newValue == null) 
                {
                    return true;
                } else if (user.getFullName().toLowerCase().contains(newValue.toLowerCase()))
                {
                    return true;    
                }

                return false;
            });
            SortedList sort = new SortedList(filter);
            sort.comparatorProperty().bind(studentTableView.comparatorProperty());

            studentTableView.setItems(sort);
        });

    }

    private void tableViewEventHandler() 
    {
        studentTableView.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<User>() 
        {
            @Override
            public void changed(ObservableValue<? extends User> observable, User oldValue, User newValue) 
            {
                User selectedUser = studentTableView.getSelectionModel().getSelectedItem();
                
                System.out.println(selectedUser.getFullName());
                
                HashMap<String, Boolean> studentAttendance = model.getStudentAttendance(selectedUser.getId());
                
                int hundredpercent = studentAttendance.size();
                present = 0;
                
                studentAttendance.forEach((date, attending) ->
                {
                    if(attending == true)
                    {
                        present++;
                    }
                });
                
                int absent = hundredpercent - present;
                System.out.println("Present days: " + present + " out of " + hundredpercent);
                System.out.println("Absent days: " + absent);
                
                initializePieChart(present, absent);
        
                
            }
        });
    }
    
        private void initializePieChart(int presence, int absence) 
    {
        ObservableList<PieChart.Data> pieChartData =
        FXCollections.observableArrayList(
        new PieChart.Data("Absence " + absence + "%", absence),
        new PieChart.Data("Presence " + presence + "%", presence));
        absencePieChart.setData(pieChartData);
       
        
        applyCustomColorSequence(
            pieChartData, 
            "red", 
            "green"
            );
    }
    
    private void applyCustomColorSequence(ObservableList<PieChart.Data> pieChartData, String... pieColors) 
    {
        int i = 0;
        for (PieChart.Data data : pieChartData) 
        {
            data.getNode().setStyle("-fx-pie-color: " + pieColors[i % pieColors.length] + ";");
            i++;
        }
        
    }

    
        
}
          