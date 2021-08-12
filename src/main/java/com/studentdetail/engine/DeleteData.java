package com.studentdetail.engine;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.studentdetail.dao.OperationOnDatabase;

public class DeleteData extends HttpServlet {
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    int id = Integer.parseInt(req.getParameter("id"));
    OperationOnDatabase operation = new OperationOnDatabase();
    int rowAffected = operation.deleteDataFromDatabase(id);
    resp.setContentType("text/html");
    PrintWriter out = resp.getWriter();
    if (rowAffected > 0) {
      out.print("<h1>Row Deleted</h1>");
    }
  }
}
