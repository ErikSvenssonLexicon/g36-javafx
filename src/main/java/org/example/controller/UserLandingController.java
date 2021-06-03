package org.example.controller;

import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import org.example.model.AppUser;

public class UserLandingController {
    @FXML
    private AnchorPane rootAnchorPane;

    @FXML
    private TextField firstNameTextField;

    @FXML
    private TextField lastNameTextField;

    @FXML
    private TextField emailTextField;

    @FXML
    private Button updateButton;

    @FXML
    private Button undoButton;


    private AppUser appUser;
    private final SimpleBooleanProperty updateDisableProperty = new SimpleBooleanProperty(true);

    public void setAppUser(AppUser user) {
        appUser = user;
        firstNameTextField.setText(appUser.getFirstName());
        lastNameTextField.setText(appUser.getLastName());
        emailTextField.setText(appUser.getEmail());

    }

    private boolean userUnchanged(){
        if(appUser == null) return true;
        return firstNameTextField.getText().equals(appUser.getFirstName()) &&
                lastNameTextField.getText().equals(appUser.getLastName()) &&
                emailTextField.getText().equals(appUser.getEmail());
    }

    @FXML
    void initialize() {
        updateDisableProperty.set(true);
        updateButton.disableProperty().bind(updateDisableProperty);
        updateButton.setOnAction(this::update);
        undoButton.setOnAction(this::undo);

        firstNameTextField.textProperty().addListener(((observable, oldValue, newValue) -> {
            if(appUser == null){
                updateDisableProperty.set(true);
            }else updateDisableProperty.set(userUnchanged());
        }));

        lastNameTextField.textProperty().addListener(((observable, oldValue, newValue) -> {
            if(appUser == null){
                updateDisableProperty.set(true);
            }else {
                updateDisableProperty.set(userUnchanged());
            }
        }));

        emailTextField.textProperty().addListener(((observable, oldValue, newValue) -> {
            if(appUser == null){
                updateDisableProperty.set(true);
            }else {
                updateDisableProperty.set(userUnchanged());
            }
        }));

    }

    private void undo(ActionEvent actionEvent) {
        setAppUser(appUser);
        updateDisableProperty.set(true);
    }

    private void update(ActionEvent actionEvent) {
        System.out.println("Clicked");
    }
}
