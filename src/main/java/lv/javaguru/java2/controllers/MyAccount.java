package lv.javaguru.java2.controllers;

import lv.javaguru.java2.domain.customer.Customer;
import lv.javaguru.java2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class MyAccount {

    @Autowired
    private CustomerService customerService;

    @GetMapping("myAccount")
    public String myAccount(HttpServletRequest request, Model model) {
        HttpSession session = request.getSession();
        Customer customer = (Customer) session.getAttribute("customer");
        model.addAttribute("customer", customer);
    return "myAccount";
}
}
