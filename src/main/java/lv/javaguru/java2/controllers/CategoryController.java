package lv.javaguru.java2.controllers;

import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.services.CustomerService;
import lv.javaguru.java2.services.products.CategoryService;
import lv.javaguru.java2.services.products.ProductService;
import lv.javaguru.java2.filter.mvc.MVCController;
import lv.javaguru.java2.filter.mvc.MVCModel;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

/**
 * Created by Vijai3D on 07.05.2017.
 */
@Controller
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
            Category selectedCategory = categoryService.getById(Byte.valueOf(categoryId));


            session.setAttribute("selectedCategory", selectedCategory);

            // get all products for selected category
            session.setAttribute("categoryProducts", productService.getAllByCategory(Byte.valueOf(categoryId)));
        }
        return new MVCModel("/view/category.jsp");
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        return null;
    }
}
