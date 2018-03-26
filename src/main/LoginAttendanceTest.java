package main;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Frederik Tubæk
 */
public class LoginAttendanceTest extends Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/GUI/view/LoginView.fxml"));
              

        Scene scene = new Scene(root);
        scene.getStylesheets().add("/res/LoginView.css");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
        stage.setTitle("Attendance Automation EASV");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
