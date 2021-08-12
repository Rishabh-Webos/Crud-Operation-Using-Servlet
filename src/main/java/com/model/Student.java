package com.model;

public class Student {
  @Override
  public String toString() {
    return "student [studentId="
        + studentId
        + ", studentName="
        + studentName
        + ", studentLastName="
        + studentLastName
        + "]";
  }

  private int studentId;
  private String studentName, studentLastName;

  public int getStudentId() {
    return studentId;
  }

  public void setStudentId(int studentId) {
    this.studentId = studentId;
  }

  public String getStudentName() {
    return studentName;
  }

  public void setStudentName(String studentName) {
    this.studentName = studentName;
  }

  public String getStudentLastName() {
    return studentLastName;
  }

  public void setStudentLastName(String studentLastName) {
    this.studentLastName = studentLastName;
  }
}
