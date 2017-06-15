package lv.javaguru.java2.controllers;

import lv.javaguru.java2.services.cart.ShoppingCart;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Vijai3D on 11.05.2017.
 */
@Controller
@RequestMapping("/checkout")
public class CheckoutController {

    final String surcharge = "15";

    @GetMapping
    public String checkout(HttpServletRequest request) {
        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
        boolean validationErrorFlag = false;
        session.setAttribute("surcharge", surcharge);
        request.setAttribute("validationErrorFlag", validationErrorFlag);
        // calculate total + surcharge
        cart.calculateTotal(surcharge);
        return "checkout";
    }
}
