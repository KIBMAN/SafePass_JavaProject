package com.example.login_page;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseConnection {
    public Connection databaseLink;

    public Connection getConnection(){
        String databaseName = "test";
        String databaseUser = "root";
        String databasePassword = "IUT2345678";
        String url = "jdbc:mysql://localhost:3306/"+databaseName;

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            databaseLink = DriverManager.getConnection(url,databaseUser,databasePassword);
        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }

        return databaseLink;
    }

}
