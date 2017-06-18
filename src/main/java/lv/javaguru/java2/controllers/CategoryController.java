package lv.javaguru.java2.controllers;

import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.services.products.CategoryService;
import lv.javaguru.java2.services.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Created by Vijai3D on 07.05.2017.
 */
@Controller
@RequestMapping("/category")
public class CategoryController {


    @Autowired private CategoryService categoryService;
    @Autowired private ProductService productService;

    @GetMapping
    public String showCategoryViews(HttpServletRequest request) {
        HttpSession session = request.getSession();
        session.setAttribute("categories", categoryService.getAll());

        String categoryId = request.getQueryString();
        if (categoryId != null) {
            // get selected by user category
            Category selectedCategory = categoryService.getById(Long.valueOf(categoryId));
            session.setAttribute("selectedCategory", selectedCategory);
            // get all products for selected category


            session.setAttribute("categoryProducts", productService.getAllByCategory(Long.valueOf(categoryId)));
        }
        return "category";
    }
}
