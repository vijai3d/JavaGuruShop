package lv.javaguru.java2.controllers;

import lv.javaguru.java2.cart.ShoppingCart;
import lv.javaguru.java2.validators.Validator;
import lv.javaguru.java2.domain.products.Product;
import lv.javaguru.java2.filter.mvc.MVCController;
import lv.javaguru.java2.filter.mvc.MVCModel;
import lv.javaguru.java2.services.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Vijai3D on 13.05.2017.
 */
@Component
public class UpdateController implements MVCController{
    @Autowired
    private Validator validator;

    @Autowired
    private ProductService productService;

    @Override
    public MVCModel processGet(HttpServletRequest request) {

        return null;
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {

        HttpSession session = request.getSession();
        ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");

        // get input from request
        String productId = request.getParameter("productId");
        String quantity = request.getParameter("quantity");

        boolean invalidEntry = validator.validateQuantity(productId, quantity);

        if (!invalidEntry) {

            Product product = productService.findById(Integer.parseInt(productId));
            cart.update(product, quantity);
        }

        return new MVCModel("/view/cart.jsp");
    }
}
