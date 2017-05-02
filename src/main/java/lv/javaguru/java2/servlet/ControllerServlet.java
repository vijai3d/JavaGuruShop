package lv.javaguru.java2.servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by Vijai3D on 01.05.2017.
 */

@WebServlet(name="ControllerServlet",
        loadOnStartup = 1,
        urlPatterns = {"/category",
                "/addToCart",
                "/viewCart",
                "/updateCart",
                "/checkout",
                "/purchase",
                "/chooseLanguage"})
public class ControllerServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userPath = request.getServletPath();

        // if addToCart action is called
        if (userPath.equals("/addToCart")) {
            // TODO: Implement add product to cart action

            // if updateCart action is called
        } else if (userPath.equals("/updateCart")) {
            // TODO: Implement update cart action and it not in web xml

            // if purchase action is called
        } else if (userPath.equals("/purchase")) {
            // TODO: Implement purchase action

            userPath = "/confirmation";
        }

        // use RequestDispatcher to forward request internally
        String url = "/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userPath = request.getServletPath();

        // if category page is requested
        if (userPath.equals("/category")) {
            // TODO: Implement category request

            // if cart page is requested
        } else if (userPath.equals("/viewCart")) {

            userPath = "/cart";

            // if checkout page is requested
        } else if (userPath.equals("/checkout")) {
            // TODO: Implement checkout page request

            // if user switches language
        } else if (userPath.equals("/chooseLanguage")) {
            // TODO: Implement language request

        }

        // use RequestDispatcher to forward request internally
        String url = "/view" + userPath + ".jsp";

        try {
            request.getRequestDispatcher(url).forward(request, response);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
