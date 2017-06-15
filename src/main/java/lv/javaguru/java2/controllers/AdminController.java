package lv.javaguru.java2.controllers;

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
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;




@Controller
public class AdminController {

    private Path path;
    private static final Resource PICTURES_DIR = new
            FileSystemResource("v/img");

    @Autowired private CustomerService customerService;

    @Autowired private CustomerOrderService customerOrderService;

    @Autowired private ProductService productService;

    @Autowired private CategoryService categoryService;

    @Autowired private DecimalFormatUtil decimalFormatUtil;

    @Autowired private ProductFactory productFactory;


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
    public String deleteProduct(@PathVariable("id") int productId, HttpServletRequest request) {
        Product product = productService.findById(productId);
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\resources\\productImages\\" + product.getName() + ".png" );
        if (Files.exists(path)) {
            try {
                Files.delete(path);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
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

        String selectedCategoryId = request.getParameter("productCategoryId");
        Category cat = categoryService.getById(Byte.parseByte(selectedCategoryId));
        product.setCategory(cat);

        String name = request.getParameter("productName");
        product.setName(name);
        String desc = request.getParameter("productDesc");
        product.setDescription(desc);
        String price = request.getParameter("productPrice");
        product.setPrice(decimalFormatUtil.format(price));

        productService.update(product);
        return "redirect:/admin/products";
    }

    @RequestMapping("/admin/products/add")
    public String addProduct(Model model) {
        List<Category> categoryList = categoryService.getAll();
        model.addAttribute("categoryList", categoryList);
        return "/admin/add-product";
    }

    @RequestMapping(value = "/admin/products/add", method = RequestMethod.POST)
    public String addProductPost(@RequestParam("productImage") CommonsMultipartFile productImage, HttpServletRequest request) throws IOException {
        String selectedCategoryId = request.getParameter("productCategoryId");
        Category cat = categoryService.getById(Byte.parseByte(selectedCategoryId));
        String name = request.getParameter("productName");
        String desc = request.getParameter("productDesc");
        String price = request.getParameter("productPrice");
        Product product = productFactory.create(name, desc, decimalFormatUtil.format(price), cat);

        String filename = productImage.getOriginalFilename();
        File tempFile = File.createTempFile("pic",
                getFileExtension(filename), PICTURES_DIR.getFile());
        try (InputStream in = productImage.getInputStream();
             OutputStream out = new FileOutputStream(tempFile)) {
            IOUtils.copy(in, out);
        }
        return "redirect:/admin/products";
    }
    private static String getFileExtension(String name) {
        return name.substring(name.lastIndexOf("."));
    }

       /* String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\resources\\images\\products\\" + product.getProductId() + ".png" );
        if (productImage != null && !productImage.isEmpty()) {
            try {
                productImage.transferTo(new File(path.toString()));
            } catch (Exception e) {
                e.printStackTrace();
                throw new RuntimeException("Product image saving failed", e);
            }
        }*/



    @GetMapping("/login")
    public String login(Model model) {

        return "/login";
    }
}
