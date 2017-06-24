package lv.javaguru.java2.controllers;

import lv.javaguru.java2.domain.customer.Customer;
import lv.javaguru.java2.services.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;

/**
 * Created by Vijai3D on 21.06.2017.
 */
@Controller
@RequestMapping("/signup")
public class SignupController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private CustomerService customerService;

    @GetMapping
    @ModelAttribute
    private String signup(Model model) {
        model.addAttribute("newCustomer", new Customer());
        return "signup";
    }

    @PostMapping
    private String signupPost(@Valid @ModelAttribute("newCustomer") Customer customer, BindingResult bindingResult,
                              Model model, HttpServletRequest request) {

        String confirmPassword = request.getParameter("confirmPassword");
        if (customer.getPassword() != confirmPassword && bindingResult.hasErrors()) {
            model.addAttribute("passwordMessage", "Passwords didn't match");
            return "signup";
        } else {
            HttpSession session = request.getSession();
            String plain_password = customer.getPassword();
            String pw_hash = BCrypt.hashpw(plain_password, BCrypt.gensalt(12));
            customer.setPassword(pw_hash);
            customerService.create(customer);
            session.setAttribute("customer", customer);
            return "redirect:/index";
        }
    }
}
