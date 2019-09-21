package com.udacity.course3.lesson1.exercise1.exercise1;


import org.flywaydb.core.Flyway;
import java.sql.*;
import java.util.Properties;

public class Application {

    public static void main(String[] args) throws SQLException {
        // STEP 1: Create the JDBC URL for JDND-C3 database
        String jdbcUrl = "jdbc:mysql://localhost:3306/JDND_C3?serverTimezone=UTC&useSSL=false";
        Properties properties = new Properties();
        properties.setProperty("user", "root");
        properties.setProperty("password", "root");

        // STEP 2: Setup and Run Flyway migration that creates the member table using its Java API
        // https://flywaydb.org/getstarted/firststeps/api#integrating-flyway
        // Note the above link talks about connecting to H2 database, for this exercise, MySQL is used. Adapt the code accordingly.
        Flyway flyway = Flyway.configure().dataSource(jdbcUrl, "root", "root").load();
        flyway.baseline();
        flyway.migrate();

        // STEP 3: Obtain a connection to the JDND-C3 database
//        Connection connection = DriverManager.getConnection(jdbcUrl, properties);
//        System.out.println("connected: "+ connection.getMetaData());
//        // STEP 4: Use Statement to INSERT 2 records into the member table
//        // NOTE: The member table is created using Flyway by placing the migration file in src/main/resources/db/migration
//
//        String insertTableSQL = "INSERT INTO member"
//                + "(ID, NAME) VALUES"
//                + "(?,?)";
//        PreparedStatement preparedStatement = connection.prepareStatement(insertTableSQL);
//        preparedStatement.setString(1, "Sarah");
//        preparedStatement.setString(2 ,"James");
//
//        preparedStatement.executeUpdate();
//        // STEP 5: Read ALL the rows from the member table and print them here
//        Statement stmt = connection.createStatement();
//        ResultSet set = stmt.executeQuery("SELECT * FROM MEMBER");
//        while(set.next()){
//            int id = set.getInt("ID");
//            String name = set.getString("NAME");
//
//            System.out.println("ID: "+ id);
//            System.out.println("NAME: " + name);
//        }


        // STEP 6: verify that all inserted rows have been printed
    }

}