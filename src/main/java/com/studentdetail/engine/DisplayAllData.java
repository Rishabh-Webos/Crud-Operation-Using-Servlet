package com.studentdetail.engine;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.studentdetail.dao.OperationOnDatabase;

public class DisplayAllData extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    OperationOnDatabase operation = new OperationOnDatabase();
    out.print("<table border=1 widht=100%>");
    for (Student student1 : operation.getDataFromDataBase()) {
      out.print("<tr><td>" + student1.getStudentId() + "</td>");
      out.print("<td>" + student1.getStudentName() + "</td>");
      out.print("<td>" + student1.getStudentLastName() + "</td>");
      out.print("<td><a href='update?id=" + student1.getStudentId() + "'>update</a></td>");
      out.print("<td><a href='delete?id=" + student1.getStudentId() + "'>delete</a></td></tr>");
    }
    out.print("</table>");
  }
}
