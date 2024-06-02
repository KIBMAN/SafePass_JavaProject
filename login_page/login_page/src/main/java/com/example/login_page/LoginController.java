package com.example.login_page;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

import java.net.URL;

public class LoginController implements Initializable {

    @FXML
    private PasswordField EnterPasswordField;

    @FXML
    private Button cancelButton;
    public void cancelButtonOnAction(ActionEvent event){
        Stage stage = (Stage) cancelButton.getScene().getWindow();
        stage.close();
    }

    @FXML
    private Button loginButton;
    @FXML Label loginMessageLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){

    }




    @FXML
    private TextField user_name_TextField;

    public void validateLogin(){
        DatabaseConnection connectNow = new DatabaseConnection();
        Connection connectDB = connectNow.getConnection();

        String verifyLogin = "SELECT count(1) FROM user_account WHERE username = '" + user_name_TextField.getText() + "' AND password ='" + EnterPasswordField.getText() + "'";

        try{
            Statement statement = connectDB.createStatement();
            ResultSet queryResult = statement.executeQuery(verifyLogin);

            while(queryResult.next()){
                if(queryResult.getInt(1)==1){
                    loginMessageLabel.setText("Congratualations!!");
                }else{
                    loginMessageLabel.setText("Invalid login. Please try again");
                }
            }
        }catch(Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void loginButtonOnAction(ActionEvent event){


        if(user_name_TextField.getText().isBlank()==false && EnterPasswordField.getText().isBlank()==false){
            validateLogin();
        }else{
            loginMessageLabel.setText("Please enter User Name and Password");
        }
    }

}