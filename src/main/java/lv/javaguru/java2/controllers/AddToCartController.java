package lv.javaguru.java2.controllers;

import lv.javaguru.java2.services.cart.ShoppingCart;
import lv.javaguru.java2.domain.products.Product;
import lv.javaguru.java2.services.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Vijai3D on 09.05.2017.
 */
@Controller
@RequestMapping("addToCart")
public class AddToCartController {

    @Autowired
    private ProductService productService;

    @PostMapping
    public String addToCart(HttpServletRequest request) {

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
        return "category";
    }
}
