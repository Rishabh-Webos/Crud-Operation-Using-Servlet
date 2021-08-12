package com.validate;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter(urlPatterns = {"/insertData", "/updateDatabase"})
public class validation implements Filter {

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
      throws IOException, ServletException {
    // TODO Auto-generated method stub
    //		HttpServlet req = (HttpServlet)request;
    try {
      if (request instanceof HttpServletRequest) {
        String url = ((HttpServletRequest) request).getRequestURL().toString();
        if (url.contains("insertData")) {
          System.out.println("Present");
        } else {
          // System.out.println("Not Present");
          try {
            int id = Integer.valueOf(request.getParameter("id"));
          } catch (NumberFormatException ex) {
            request.setAttribute("id", "Please Enter Number");
            request.getRequestDispatcher("index.jsp").forward(request, response);
          }
        }
      }
    } catch (NullPointerException ex) {
      System.out.println(ex.getLocalizedMessage());
    }
    String name = request.getParameter("name");
    Pattern pattern = Pattern.compile("^[A-Za-z]\\w{5,29}$");
    Matcher matcher = pattern.matcher(name);
    if (!matcher.matches()) {
      request.setAttribute("name", "Please Enter Proper Name");
      request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    String lastName = request.getParameter("lastName");
    pattern = Pattern.compile("^[A-Za-z]\\w{5,29}$");
    matcher = pattern.matcher(lastName);
    if (!matcher.matches()) {
      request.setAttribute("lastName", "Please Enter Proper Last Name");
      request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    chain.doFilter(request, response);
  }
}
