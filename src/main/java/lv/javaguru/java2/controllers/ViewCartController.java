package lv.javaguru.java2.controllers;

import lv.javaguru.java2.services.cart.ShoppingCart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Vijai3D on 09.05.2017.
 */
@Controller
@RequestMapping("/viewCart")
public class ViewCartController {

    @GetMapping
    public String viewCart(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String clear = request.getParameter("clear");

        if ((clear != null) && clear.equals("true")) {
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            cart.clear();
        }
    return "cart";
    }
}
