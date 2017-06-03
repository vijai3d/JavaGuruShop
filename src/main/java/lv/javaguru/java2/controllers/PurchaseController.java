package lv.javaguru.java2.controllers;

import lv.javaguru.java2.cart.ShoppingCart;
import lv.javaguru.java2.services.OrderManager;
import lv.javaguru.java2.validators.Validator;
import lv.javaguru.java2.filter.mvc.MVCController;
import lv.javaguru.java2.filter.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Map;


/**
 * Created by Vijai3D on 14.05.2017.
 */
@Controller
@RequestMapping("purchase")
public class PurchaseController {
    @Autowired
    private OrderManager orderManager;

    @Autowired
    private Validator validator;

    @PostMapping
    public String purchase(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        if (cart != null) {
            // extract user data from request
            String name = request.getParameter("name");
            String email = request.getParameter("email");
            String phone = request.getParameter("phone");
            String address = request.getParameter("address");
            String city = request.getParameter("city");
            String country = request.getParameter("country");

            // validate user data
            boolean validationErrorFlag = false;
            validationErrorFlag = validator.validateForm(name, email, phone, address, city, country, request);

            // if validation error found, return user to checkout
            if (validationErrorFlag == true) {
                request.setAttribute("validationErrorFlag", validationErrorFlag);

                return "checkout";

                // TODO otherwise, save order to database
            } else {
                int orderId = orderManager.placeOrder(name, email, phone, address, city, country, cart);

                if (orderId != 0) {


                    // dissociate shopping cart from session
                    cart = null;

                    // end session
                    session.invalidate();

                    // get order details
                    Map orderMap = orderManager.getOrderDetails(orderId);

                    // place order details in request scope
                    request.setAttribute("customer", orderMap.get("customer"));
                    request.setAttribute("products", orderMap.get("products"));
                    request.setAttribute("orderRecord", orderMap.get("orderRecord"));
                    request.setAttribute("orderedProducts", orderMap.get("orderedProducts"));

                    return "confirmation";

                    // otherwise, send back to checkout page and display error
                } else {
                    return"checkout";

                }
            }
        }
        request.setAttribute("orderFailureFlag", true);
        return "confirmation";
    }
}
