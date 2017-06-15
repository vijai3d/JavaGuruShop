package lv.javaguru.java2.controllers;

import lv.javaguru.java2.services.products.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Vijai3D on 07.05.2017.
 */
@Controller
@RequestMapping("/index")
public class HomeController{
    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String index(Model model) {
        model.addAttribute("categories", categoryService.getAll());
    return "../index";
    }
}
