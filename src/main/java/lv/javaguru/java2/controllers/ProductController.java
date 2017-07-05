package lv.javaguru.java2.controllers;

import lv.javaguru.java2.database.hibernate.FileUploadDAO;
import lv.javaguru.java2.domain.Pictures;
import lv.javaguru.java2.services.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by Vijai3D on 05.07.2017.
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @Autowired
    private FileUploadDAO fileUploadDAO;

    @GetMapping
    public String showProduct(HttpServletRequest request) {
        HttpSession session = request.getSession();


        String productId = request.getQueryString();
        session.setAttribute("product", productService.findById(Integer.parseInt(productId)));
        List<Pictures> pictureList = fileUploadDAO.getAll();
        session.setAttribute("pictureList", pictureList);
        return "/product";
    }

}
