package com.configfile;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConfigureClass {
  public Connection getConnection() {
    Connection connection = null;
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection =
          DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "root");
    } catch (ClassNotFoundException | SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return connection;
  }
}
