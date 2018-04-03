/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI.controller;

import BE.Course;
import BE.User;
import GUI.model.Model;
import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import java.net.URL;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Formatter;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Label;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
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
    @FXML
    private Label dateLbl;
    @FXML
    private FontAwesomeIconView userIcon;
    @FXML
    private FontAwesomeIconView absenceIcon;    
    @FXML
    private Label timeLbl;
    @FXML
    private Label currentStatusLbl; 
     @FXML
    private JFXButton presentBtn;
    @FXML
    private JFXButton absentBtn;
    @FXML
    private Label currentClassesLbl; 
    
    private Boolean attendanceStatus;
    
    private Model model = Model.getInstance();

    private String currentWeekDay;
    private List<Course> classesToday;
   
    
    private Date date = new Date();
    private SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    
    /**
     * initialises the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {
        easvLogoImage.setImage(new Image(getClass().getResourceAsStream("/res/easv.png")));
        
        dateLbl.setText("Todays date: " + sdf.format(date));
        
        currentWeekDay = getcurrentWeekDay();
        
        displayTime();
        displayTodaysClasses();
        displayCurrentAttendanceStatus();
    }    

    private void displayTime() 
    {
   
    }

    @FXML
    private void presentEvent(ActionEvent event) 
    {
        registerAttendance(true);
    }

    @FXML
    private void absentEvent(ActionEvent event) 
    {
        registerAttendance(false);
    }
    
    private boolean checkIfValidTimePeriod() 
    {
        try 
        {
            String string1 = "08:15:00";
            Date time1 = new SimpleDateFormat("HH:mm:ss").parse(string1);
            Calendar calendar1 = Calendar.getInstance();
            calendar1.setTime(time1);

            String string2 = "16:00:00";
            Date time2 = new SimpleDateFormat("HH:mm:ss").parse(string2);
            Calendar calendar2 = Calendar.getInstance();
            calendar2.setTime(time2);
            calendar2.add(Calendar.DATE, 1);
            
            
            Date currentDate = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            String currentTime = sdf.format(currentDate);
            
            Date d = new SimpleDateFormat("HH:mm:ss").parse(currentTime);
            Calendar calendar3 = Calendar.getInstance();
            calendar3.setTime(d);
            calendar3.add(Calendar.DATE, 1);

            Date x = calendar3.getTime();
            if (x.after(calendar1.getTime()) && x.before(calendar2.getTime())) 
            {
                return true;               
            }

        } 
        catch (ParseException e) 
        {
            e.printStackTrace();
        }    
        return false;
    }


    private String getcurrentWeekDay() 
    {
        String[] dayNames = {"Saturday","Sunday","Monday","Tuesday","Wednesday","Thursday","Friday"};
        Calendar date2 = Calendar.getInstance();
        return dayNames[date2.get(Calendar.DAY_OF_WEEK)];
    }
    
    private int getCurrentWeekOfYear()
    {
        LocalDate date = LocalDate.now();
        WeekFields weekFields = WeekFields.of(Locale.getDefault());
        return date.get(weekFields.weekOfWeekBasedYear());
    }

    private void displayTodaysClasses() 
    {
        
        classesToday = model.getClassesToday(model.getCurrentUser(), currentWeekDay);
        if(!classesToday.isEmpty())
        {
            List<String> courseNames = new ArrayList();
            for (Course course : classesToday) 
            {
                courseNames.add(course.getName());
            }
            String allCourses = String.join(", ", courseNames);
            currentClassesLbl.setText(allCourses);
        }
        else
        {
            currentClassesLbl.setText("No classes today");
        }
    }

    private void displayCurrentAttendanceStatus() 
    {
        attendanceStatus = model.getTodaysAttendanceStatus(model.getCurrentUser().getId(), sdf.format(date));
        System.out.println(attendanceStatus);
        String currentStatus = null;
        if(attendanceStatus != null)
        {
            if(attendanceStatus == true)
            {
                currentStatus = "Present";
                currentStatusLbl.setStyle("-fx-text-fill: Green;");
            }
            else if(attendanceStatus == false)
            {
                currentStatus ="Absent";
                currentStatusLbl.setStyle("-fx-text-fill: Red;"); 
            }               
        }
        else
        {
            currentStatus = "Unattended";
            currentStatusLbl.setStyle("-fx-text-fill: Black;");

        }        
        currentStatusLbl.setText(currentStatus);
    }
    
    private void registerAttendance(Boolean attending)
    {
        if(checkIfValidTimePeriod())
        {
            if(attendanceStatus == null)
            {
                for (Course course : classesToday) 
                {
                    model.registerAttendance(course.getId(), model.getCurrentUser().getId(), sdf.format(date), attending, getCurrentWeekOfYear());
                }
                displayCurrentAttendanceStatus();
            }
            else
            {
                for (Course course : classesToday) 
                {
                    model.updateAttendance(course.getId(), model.getCurrentUser().getId(), sdf.format(date), attending, getCurrentWeekOfYear());
                }
                displayCurrentAttendanceStatus();               
            }
        }
        else
        {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Invalid Timeperiod error");
            alert.setHeaderText("Unable to register attendacne due to invalid time period");
            alert.setContentText("You can only register attendance during the hours 08:15 - 16:00");

            alert.showAndWait();
        }     
    }
    
 
}
