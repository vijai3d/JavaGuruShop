package lv.javaguru.java2.controllers;

import lv.javaguru.java2.cart.ShoppingCart;
import lv.javaguru.java2.domain.products.Product;
import lv.javaguru.java2.services.products.ProductService;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Vijai3D on 09.05.2017.
 */
@Component
public class AddToCartController implements MVCController{
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

        if (cart == null) {
            cart = new ShoppingCart();
            session.setAttribute("cart", cart);
        }

        // get user input from request
        String productId = request.getParameter("productId");

        if (!productId.isEmpty()) {

            Product product = productService.findById(Integer.parseInt(productId));
            cart.addItem(product);

        }

        return new MVCModel("/view/category.jsp");
    }
}
