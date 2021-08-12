package com.studentdetail.engine;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.studentdetail.dao.OperationOnDatabase;

public class UpdateDatabase extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    int id = Integer.parseInt(req.getParameter("id"));
    String name = req.getParameter("name");
    String lastName = req.getParameter("lastName");
    Student student = new Student();
    student.setStudentId(id);
    student.setStudentLastName(lastName);
    student.setStudentName(name);
    ArrayList<Student> listOfStudent = new ArrayList<>();
    listOfStudent.add(student);
    OperationOnDatabase operation = new OperationOnDatabase();
    int rowAffected = operation.updateDataInDatabse(listOfStudent);
    if (rowAffected > 0) {
      out.println("<h1>Updated Succesfully</h1>");
    }
  }
}
