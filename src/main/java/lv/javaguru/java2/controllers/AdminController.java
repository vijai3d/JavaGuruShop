package lv.javaguru.java2.controllers;

import lv.javaguru.java2.database.hibernate.FileUploadDAO;
import lv.javaguru.java2.domain.Pictures;
import lv.javaguru.java2.domain.customer.Customer;
import lv.javaguru.java2.domain.customer.CustomerOrder;
import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.domain.products.Product;
import lv.javaguru.java2.services.CustomerOrderService;
import lv.javaguru.java2.services.CustomerService;
import lv.javaguru.java2.services.products.CategoryService;
import lv.javaguru.java2.services.products.ProductFactory;
import lv.javaguru.java2.services.products.ProductService;
import lv.javaguru.java2.services.utils.DecimalFormatUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class AdminController {

    private Path path;

    @Autowired private CustomerService customerService;

    @Autowired private CustomerOrderService customerOrderService;

    @Autowired private ProductService productService;

    @Autowired private CategoryService categoryService;

    @Autowired private DecimalFormatUtil decimalFormatUtil;

    @Autowired private ProductFactory productFactory;

    @Autowired
    private FileUploadDAO fileUploadDAO;

    @GetMapping("/admin")
    public String index(Model model) {

        return "/admin/index";
    }
    @GetMapping("/admin/customers")
    public String viewCustomers(HttpServletRequest request) {
        HttpSession session = request.getSession();

        String customerId = request.getQueryString();
        session.setAttribute("customerList", customerService.getAll());
        if (customerId != null) {
            Customer selectedCustomer = customerService.getById(Integer.parseInt(customerId));
            List<CustomerOrder> orders = customerOrderService.findByCustomer(selectedCustomer);

            session.setAttribute("selectedCustomer", selectedCustomer);
            session.setAttribute("ordersList", orders);
        }
    return "/admin/customers";
    }

    @GetMapping("/admin/customers/delete/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id) {

        customerService.delete(id);
        return "redirect:/admin/customers";
    }



    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login() {
        return "/login";
    }

}
