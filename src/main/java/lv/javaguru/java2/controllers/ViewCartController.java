package lv.javaguru.java2.controllers;

import lv.javaguru.java2.cart.ShoppingCart;
import lv.javaguru.java2.filter.mvc.MVCController;
import lv.javaguru.java2.filter.mvc.MVCModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Vijai3D on 09.05.2017.
 */
@Component
public class ViewCartController implements MVCController{
    @Override
    public MVCModel processGet(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String clear = request.getParameter("clear");

        if ((clear != null) && clear.equals("true")) {

            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            cart.clear();
        }
        return new MVCModel("/view/cart.jsp");
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        return null;
    }
}
