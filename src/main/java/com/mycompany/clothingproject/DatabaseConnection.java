package com.mycompany.clothingproject;

import java.sql.*;
import javax.swing.*;

public class DatabaseConnection {
    Connection conn = null;

    public static Connection ConnecrDB() {
        try {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:Proma.db");
            JOptionPane.showMessageDialog(null, "Connection Established");
            return conn;
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
            return null;
        }
    }
}
