package org.example;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class Main {
    public static void main(String[] args) {
        DatabaseConnector dbConnector = new DatabaseConnector();
        Connection connection = dbConnector.connect();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                System.out.println(resultSet.getInt("id") + " " + resultSet.getString("full_name") + " " + resultSet.getInt("age"));
            }
            } catch (SQLException e) {
            e.printStackTrace();
            }

//  Inserting Records on Database
//        try {
//            Statement statement = connection.createStatement();
//            int rowsAffected = statement.executeUpdate("INSERT INTO Students (id, full_name, age) VALUES (1, 'John Doe', 20)");
//            System.out.println("Inserted " + rowsAffected + " row(s) into the database.");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//// Don't forget to close your connections when you're done
//            try {
//                if(connection != null) connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }

// Updating Records on Database
//        try {
//            Statement statement = connection.createStatement();
//            int rowsAffected = statement.executeUpdate("UPDATE students SET full_name = 'Jane Doe' WHERE id=1");
//
//            System.out.println("Updated " + rowsAffected + " row(s) in the database");
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } finally {
//            try {
//                if(connection != null) connection.close();
//            } catch (SQLException e){
//                e.printStackTrace();
//            }
//        }
        // Deleting records on Database
        try {
            Statement statement = connection.createStatement();
            int rowsAffected = statement.executeUpdate("DELETE FROM students WHERE id = 1");

            System.out.println("Deleted " + rowsAffected + " row(s) in the database");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if(connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
