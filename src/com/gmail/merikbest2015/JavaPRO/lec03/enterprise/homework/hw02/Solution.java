package com.gmail.merikbest2015.JavaPRO.lec03.enterprise.homework.hw02;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class Solution extends HttpServlet {
//    static final String TEMPLATE = "<html>" +
//            "<head><title>Prog.kiev.ua</title></head>" +
//            "<body><h1>%s</h1></body></html>";

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);

        String name = req.getParameter("name");
        String lastName = req.getParameter("lastName");
        String age = req.getParameter("age");

        resp.setContentType("text/html");

        PrintWriter pw = resp.getWriter();
        pw.println("<html><head><title>Prog.kiev.ua Test</title></head>" +
                "<body><p>" + name + "<br></p>" +
                "<p>" + lastName + "<br></p>" +
                "<p>" + age + "<br></p></body></html>");
    }
}