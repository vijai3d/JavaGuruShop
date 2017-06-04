package lv.javaguru.java2.controllers;

/**
 * Created by Vijai3D on 31.05.2017.
 */


import lv.javaguru.java2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller

public class AdminController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/admin")
    public String admin(Model model) {
        model.addAttribute("customerList", customerService.getAll());
    return "/admin/index";
    }

    @GetMapping("/login")
    public String login(Model model) {

        return "/login";
    }
}
