package lv.javaguru.java2.controllers;

import lv.javaguru.java2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MyAccount {

    @Autowired
    private CustomerService customerService;

    @GetMapping("myAccount")
    public String myAccount(Model model) {

    return "myAccount";
}
}
