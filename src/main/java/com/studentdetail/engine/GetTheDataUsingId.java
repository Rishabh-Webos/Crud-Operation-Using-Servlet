package com.studentdetail.engine;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.model.Student;
import com.studentdetail.dao.OperationOnDatabase;

public class GetTheDataUsingId extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    int id = Integer.parseInt(req.getParameter("id"));
    OperationOnDatabase operation = new OperationOnDatabase();
    for (Student student : operation.SearchDataInDatabase(id)) {
      out.print("<form action='updateDatabase'>");
      out.print("<input type='hidden' name='id' value=" + student.getStudentId() + ">");
      out.print(
          "Enter Name :<input type='text' name='name' value=" + student.getStudentName() + ">");
      out.print(
          "<br>Enter LastName :<input type='text' name='lastName' value="
              + student.getStudentLastName()
              + "> ");
      out.print("<br> <input type='submit'>");
      out.print("</form>");
    }
  }
}
