package com.studentdetail.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.configfile.ConfigureClass;
import com.model.Student;

public class OperationOnDatabase {
  public int insertDataInDataBase(ArrayList<Student> listOfStudent) {
    ConfigureClass configure = new ConfigureClass();
    Connection connection = configure.getConnection();
    int rowAffected = 0;
    try {
      for (Student student : listOfStudent) {
        PreparedStatement statement =
            connection.prepareStatement("insert into student(name,lastname) values(?,?)");
        statement.setString(1, student.getStudentName());
        statement.setString(2, student.getStudentLastName());
        rowAffected = statement.executeUpdate();
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return rowAffected;
  }

  public ArrayList<Student> getDataFromDataBase() {
    ArrayList<Student> listOfStudent = new ArrayList<>();
    ConfigureClass configure = new ConfigureClass();
    Connection connection = configure.getConnection();
    try {
      Statement statement = connection.createStatement();
      ResultSet data = statement.executeQuery("select * from student");
      while (data.next()) {
        Student student = new Student();
        student.setStudentId(data.getInt("id"));
        student.setStudentName(data.getString("name"));
        student.setStudentLastName(data.getString("lastname"));
        listOfStudent.add(student);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return listOfStudent;
  }

  public ArrayList<Student> SearchDataInDatabase(int id) {
    ArrayList<Student> listOfStudent = new ArrayList<>();
    ConfigureClass configure = new ConfigureClass();
    Connection connection = configure.getConnection();
    try {
      Statement statement = connection.createStatement();
      ResultSet data = statement.executeQuery("select * from student where id=" + id);
      if (data.next()) {
        Student student = new Student();
        student.setStudentId(data.getInt("id"));
        student.setStudentName(data.getString("name"));
        student.setStudentLastName(data.getString("lastname"));
        listOfStudent.add(student);
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return listOfStudent;
  }

  public int updateDataInDatabse(ArrayList<Student> listOfStudent) {
    int rowAffected = 0;
    ConfigureClass configure = new ConfigureClass();
    Connection connection = configure.getConnection();
    try {
      for (Student student : listOfStudent) {
        PreparedStatement statement =
            connection.prepareStatement("update student set name=?,lastname=? where id=?");
        statement.setString(1, student.getStudentName());
        statement.setString(2, student.getStudentLastName());
        statement.setInt(3, student.getStudentId());
        rowAffected = statement.executeUpdate();
      }
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return rowAffected;
  }

  public int deleteDataFromDatabase(int id) {
    int rowAffected = 0;
    ConfigureClass configure = new ConfigureClass();
    Connection connection = configure.getConnection();
    try {
      PreparedStatement statement = connection.prepareStatement("delete from student where id=?");
      statement.setInt(1, id);
      rowAffected = statement.executeUpdate();
    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return rowAffected;
  }
}
