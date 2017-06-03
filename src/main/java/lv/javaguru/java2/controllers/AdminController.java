package lv.javaguru.java2.controllers;

/**
 * Created by Vijai3D on 31.05.2017.
 */


import lv.javaguru.java2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private CustomerService customerService;

    @GetMapping
    public String admin(Model model) {
        model.addAttribute("customerList", customerService.getAll());
    return "/admin/index";
    }
}
