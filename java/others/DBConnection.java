package main.java.others;

import main.java.controllers.PromptDialogController;

import java.sql.*;


/**
 * Author: 10905039
 * Written on: within July/2023
 * Project: CeeInventory
 **/
//jdbc:mysql://127.0.0.1:330/?user=root
public class DBConnection {

    private static final String URL = "jdbc:mysql://root@127.0.0.1:330/inventory?serverTimezone=UTC&autoReconnect=yes&useSSL=no";

    public static Connection getConnection() {
        Connection con;
        try {
            con = DriverManager.getConnection("jdbc:mysql://root@127.0.0.1:330/inventory?serverTimezone=UTC&autoReconnect=yes&useSSL=no", "root", "10905039Cindy");
        } catch (SQLException e) {
            e.printStackTrace();
            if (e.getErrorCode() == 0) { //Error Code 0: database server offline
                new PromptDialogController("Error!", "Database server is offline!");
            }
            return null;
        }
        return con;
    }
}

//import java.sql.Connection;
//        import java.sql.DriverManager;
//        import java.sql.Statement;
//        import java.sql.ResultSet;
//
//public class Main {
//    public static void main(String[] args)  {
//        Connection c = null;
//
//        try {
//            // CONNECTING TO POSTGRESQL
//            Class.forName("org.postgresql.Driver");
//            c = DriverManager.getConnection("jdbc:postgresql://localhost:5432/Employees", "postgres", "root");
//            System.out.println("Opened database successfully");
//
//            Statement statement = c.createStatement();
//
//            ResultSet resultSet = statement.executeQuery("select * from departments");
//
//            while (resultSet.next()) {
//                System.out.println(resultSet.getString("dept_name"));
//            }
//
//
//            // CONNECTING TO MYSQL
////            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/javaDB", "root", "mysqlroot");
////
////            Statement statement = connection.createStatement();
////
////            ResultSet resultSet = statement.executeQuery("select * from people");
////
////            while (resultSet.next()) {
////                System.out.println(resultSet.getString("firstName"));
////            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//}