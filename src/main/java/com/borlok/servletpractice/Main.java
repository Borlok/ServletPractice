package com.borlok.servletpractice;


import java.sql.*;

public class Main {

    static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DATABASE_URL = "jdbc:postgresql://localhost:5432/servlets_tutorial";
    static final String DATABASE_USER = "student";
    static final String DATABASE_PASSWORD = "123";
    static final String GET_ALL_DEVELOPERS_RECORDS = "SELECT * FROM developers";


    public static void main(String[] args) throws ClassNotFoundException {

        Class.forName(JDBC_DRIVER);

        try {
            Connection connection = DriverManager.getConnection(DATABASE_URL,DATABASE_USER,DATABASE_PASSWORD);
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(GET_ALL_DEVELOPERS_RECORDS);

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String specialty = resultSet.getString(4);
                int experience = resultSet.getInt(5);
                int salary = resultSet.getInt(6);

                System.out.println("id: " + id + "\n" +
                        "firstName: " +firstName + "\n" +
                        "last name: " + lastName + "\n" +
                        "specialty: " + specialty + "\n" +
                        "experience: " + experience + "\n" +
                        "salary: " + salary + "\n" +
                        "++++++++++++++++++++++++++++++++++++++++++++\n");

            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
