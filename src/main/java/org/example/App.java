package org.example;


import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class App extends Application
{
    @Override
    public void init() {
        System.out.println("Starting application");
    }

    @Override
    public void stop() {
        System.out.println("Terminates");
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        /*
            Stage
            Many scenes
         */
        Parent root = FXMLLoader.load(getClass().getResource("/fxml/register.fxml"));
        Scene scene = new Scene(root, 1280, 768);
        primaryStage.setScene(scene);
        primaryStage.show();

        //Create a Scene


    }
}
