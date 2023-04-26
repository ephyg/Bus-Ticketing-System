package com.astu.bustransportsystem.controllers;

import com.astu.bustransportsystem.Exceptions.AuthenticationException;
import com.astu.bustransportsystem.HelloApplication;
import com.astu.bustransportsystem.Models.Roles;
import com.astu.bustransportsystem.Models.User;
import com.astu.bustransportsystem.Utilities.DBController;
import com.astu.bustransportsystem.Exceptions.FormException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginController {
    @FXML
    private TextField ssnField, passwordField;
    @FXML
    private Label ssnError, passwordError;
    @FXML
    private Button loginBtn;

    @FXML
    private void login(ActionEvent e) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        ssnError.setText("");
        passwordError.setText("");
        try {
            if (ssnField.getText().length() < 9) {
                throw new FormException("ssn", "Please Enter a Valid SSN");
            }
            if (passwordField.getText().length() < 6) {
                throw new FormException("password", "Password should be more than 5 characters");
            }

            int ssn = Integer.parseInt(ssnField.getText());
            String pass = passwordField.getText();

            User current  = User.login(ssn, pass);

            HelloApplication.switchScene("agent_dashboard");

        } catch (FormException ex) {
            if(ex.formElement == "ssn") {
                ssnError.setText(ex.errorMessage);
            }else if (ex.formElement == "password") {
                passwordError.setText(ex.errorMessage);
            }
        } catch (AuthenticationException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Authentication Error");
            alert.setHeaderText(ex.getMessage());
            alert.show();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }
}
