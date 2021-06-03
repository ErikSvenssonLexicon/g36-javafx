package org.example.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.Window;
import org.example.controller.UserLandingController;
import org.example.model.AppUser;

import java.io.IOException;

public class SceneSwapper {
    private static final SceneSwapper INSTANCE;

    static {
        INSTANCE = new SceneSwapper();
    }

    private SceneSwapper(){}

    public static SceneSwapper getInstance(){
        return INSTANCE;
    }


    public void swapScene(String resource, Window oldWindow){

        Stage stage = new Stage();
        Parent node = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        try{
            node = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(node != null){
            Scene scene = new Scene(node);
            stage.setScene(scene);
            stage.show();
            oldWindow.hide();
        }
    }

    public void swapScene(String resource, Object object, Window oldWindow){
        if(object instanceof AppUser){
            internalSwap(resource, (AppUser) object, oldWindow);
        }

    }

    private void internalSwap(String resource, AppUser object, Window oldWindow) {

        Stage stage = new Stage();
        Parent node = null;
        FXMLLoader loader = new FXMLLoader(getClass().getResource(resource));
        try{
            node = loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(node != null){
            Scene scene = new Scene(node);
            stage.setScene(scene);
            UserLandingController landingController = loader.getController();
            landingController.setAppUser(object);
            stage.show();
            oldWindow.hide();
        }
    }
}
