package com.github.shortenURL;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnectionTests {
    @Test
    void TestConnection() {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try {
            Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/shorten_url", "root", "dhtp17");
            Assertions.assertTrue(connection != null);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
