package lv.javaguru.java2.controllers;

import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.domain.products.Product;
import lv.javaguru.java2.services.products.CategoryService;
import lv.javaguru.java2.services.products.ProductService;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Collection;
import java.util.Optional;

/**
 * Created by Vijai3D on 07.05.2017.
 */
@Component
public class CategoryController implements MVCController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;


    @Override
    public MVCModel processGet(HttpServletRequest request) {

        HttpSession session = request.getSession();

            // get All categories
        session.setAttribute("categories", categoryService.getAll());

            String categoryId = request.getQueryString();

        if (categoryId != null) {
            // get selected category
            Category selectedCategory = categoryService.findById(Short.valueOf(categoryId));
            System.out.println(selectedCategory);

            session.setAttribute("selectedCategory", selectedCategory);

            // get all products for selected category
            session.setAttribute("categoryProducts", productService.getAllByCategory(Integer.parseInt(categoryId)));
        }
        return new MVCModel("/view/category.jsp");
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        return null;
    }
}
