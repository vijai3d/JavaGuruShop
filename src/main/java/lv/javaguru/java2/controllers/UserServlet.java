package lv.javaguru.java2.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.services.UserService;
import lv.javaguru.java2.services.UserServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

/**
 * Created by Victor on 28.03.2017.
 */
@WebServlet(name = "UserServlet")
public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
// greeting test
        UserService userService = new UserServiceImpl();
        Long userId = Long.valueOf(1003);
        Optional<User> userOpt = userService.showById(userId);
        request.setAttribute("userOpt", userOpt.get());
        // show all users
        List<User> users = userService.showAll();
        request.setAttribute("users", users);
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher("/users.jsp");
        requestDispatcher.forward(request, response);
    }
}
