package com.studentdetail.engine;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.studentdetail.dao.InsertDataInList;
import com.studentdetail.dao.OperationOnDatabase;

public class InsertData extends HttpServlet {
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    String studentName = req.getParameter("name");
    String studentLastName = req.getParameter("lastName");
    Student student = new Student();
    student.setStudentName(studentName);
    student.setStudentLastName(studentLastName);
    ArrayList<Student> listOfStudent = new ArrayList<Student>();
    listOfStudent = (new InsertDataInList()).insertDataInArrayList(student);
    OperationOnDatabase operation = new OperationOnDatabase();
    int rowAffected = operation.insertDataInDataBase(listOfStudent);
    if (rowAffected > 0) {
      DisplayAllData data = new DisplayAllData();
      data.doGet(req, resp);
    } else {
      out.println("No Row Affected");
    }
  }
}
