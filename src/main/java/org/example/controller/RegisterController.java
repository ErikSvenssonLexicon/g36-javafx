package org.example.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import org.example.model.AppUser;
import org.example.util.SceneSwapper;

import java.io.IOException;

public class RegisterController {

    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private TextField firstNameField;

    @FXML
    private TextField lastNameField;

    @FXML
    private TextField emailField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private PasswordField passwordRepeatField;

    @FXML
    private Button submitButton;

    @FXML
    private Button resetButton;

    @FXML
    void initialize() {
        submitButton.setOnAction(this::submit);
        resetButton.setOnAction(this::reset);
    }

    private void reset(ActionEvent actionEvent) {
        System.out.println("Reset clicked");
    }

    private void submit(ActionEvent actionEvent) {
        String firstName = firstNameField.getText().trim();
        String lastName = lastNameField.getText().trim();
        String email = emailField.getText().trim();
        String password = passwordField.getText().trim();
        String repeatedPassword = passwordRepeatField.getText().trim();
        if(password.equals(repeatedPassword)){
            AppUser appUser = new AppUser(
                    1,
                    firstName,
                    lastName,
                    email,
                    password
            );

            Platform.runLater(()-> SceneSwapper.getInstance().swapScene("/fxml/user_landing.fxml", appUser, rootAnchorPane.getScene().getWindow()));
        }
    }
}
