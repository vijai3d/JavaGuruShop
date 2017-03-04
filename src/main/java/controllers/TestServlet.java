package controllers;

import business.Customer;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

import java.io.*;

/**
 * Created by Vijai3D on 04.03.2017.
 */
@WebServlet(name = "TestServlet", urlPatterns = "/test")
public class TestServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String url = "/index.jsp";
        String action = request.getParameter("action");
        if (action==null) {
            action = "start";
        }
        if (action.equals("start")) {
            url = "/index.jsp";
        } else if (action.equals("add")) {
            String insertedName = request.getParameter("inputName");
            String insertedLastName = request.getParameter("inputLastName");
            Customer cust = new Customer(null, insertedName, insertedLastName,"" ,true);

            request.setAttribute("customer", cust);
            url = "/includes/test.jsp";
        }
        getServletContext().getRequestDispatcher(url).forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
