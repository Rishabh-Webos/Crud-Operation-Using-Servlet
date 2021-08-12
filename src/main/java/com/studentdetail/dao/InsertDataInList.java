package com.studentdetail.dao;

import java.util.ArrayList;

import com.model.Student;

public class InsertDataInList {
  public ArrayList<Student> insertDataInArrayList(Student student) {
    ArrayList<Student> listOfStudent = new ArrayList();
    listOfStudent.add(student);
    return listOfStudent;
  }
}
