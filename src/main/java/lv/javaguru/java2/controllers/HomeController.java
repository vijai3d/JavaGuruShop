package lv.javaguru.java2.controllers;

import lv.javaguru.java2.services.products.CategoryService;
import lv.javaguru.java2.servlet.mvc.MVCController;
import lv.javaguru.java2.servlet.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vijai3D on 07.05.2017.
 */
@Component
public class HomeController implements MVCController {
    @Autowired
    private CategoryService categoryService;

    @Override
    public MVCModel processGet(HttpServletRequest request) {
        request.setAttribute("categories", categoryService.getAll());
        return new MVCModel("/index.jsp");

    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {

        return null;
    }
}
