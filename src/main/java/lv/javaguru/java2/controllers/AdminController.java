package lv.javaguru.java2.controllers;

/**
 * Created by Vijai3D on 31.05.2017.
 */


import lv.javaguru.java2.database.hibernate.ProductDAO;
import lv.javaguru.java2.domain.customer.Customer;
import lv.javaguru.java2.domain.customer.CustomerOrder;
import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.domain.products.Product;
import lv.javaguru.java2.services.CustomerOrderService;
import lv.javaguru.java2.services.CustomerService;
import lv.javaguru.java2.services.products.CategoryService;
import lv.javaguru.java2.services.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;
import java.util.List;


@Controller
public class AdminController {
    @Autowired
    private CustomerService customerService;

    @Autowired
    private CustomerOrderService customerOrderService;

    @Autowired
    private ProductService productService;

    @Autowired
    private CategoryService categoryService;


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

    @GetMapping("/admin/products")
    public String viewProducts(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String productId = request.getQueryString();
        List<Product> products= productService.getAll();
        session.setAttribute("productsList", products);
        if (productId != null) {
            Product selectedProduct = productService.findById(Integer.parseInt(productId));
            session.setAttribute("selectedProduct", selectedProduct);
        }
        return "/admin/products";
    }

    @GetMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") int productId) {
        System.out.println("in delete controller");
        productService.delete(productId);
        return "redirect:/admin/products";
    }

    @RequestMapping("/admin/edit-product/{id}")
    public String editProduct(@PathVariable("id") int productId, HttpServletRequest request) {
        HttpSession session = request.getSession();
       Product product = productService.findById(productId);
       List<Category> categoryList = categoryService.getAll();
        session.setAttribute("selectedProduct", product);
        session.setAttribute("categoryList", categoryList);
        return "/admin/edit-product";
    }
    @RequestMapping("/admin/edit-product/update")
    public String updateProduct(HttpServletRequest request) {
        HttpSession session = request.getSession();

        Product product = (Product) session.getAttribute("selectedProduct");
        Category cat = (Category) session.getAttribute("productCategory");
        //TODO cat is null
        System.out.println(cat);
        product.setCategory(cat);
        String name = request.getParameter("productName");
        product.setName(name);
        String desc = request.getParameter("productDesc");
        product.setDescription(desc);
        String price = request.getParameter("productPrice");
        //TODO Refactoring needed: create bean from that
        // Create a DecimalFormat that fits your requirements
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setGroupingSeparator(',');
        symbols.setDecimalSeparator('.');
        String pattern = "#,##0.0#";
        DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
        decimalFormat.setParseBigDecimal(true);
        try {
            BigDecimal priceFormatted = (BigDecimal) decimalFormat.parse(price);
            product.setPrice(priceFormatted);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        productService.update(product);
        return "/admin/edit-product";
    }
    @GetMapping("/login")
    public String login(Model model) {

        return "/login";
    }
}
