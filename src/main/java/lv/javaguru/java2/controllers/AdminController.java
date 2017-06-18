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
import org.springframework.beans.factory.annotation.Autowired;
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
import java.util.ArrayList;
import java.util.List;




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

    @GetMapping("/admin/products")
    public String viewProducts(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String productId = request.getQueryString();
        List<Product> productList = productService.getAll();
        List<Pictures> pictureList = fileUploadDAO.getAll();
       /* List<Object[]> products= productService.getAllofTwo();
        List<Product> prList = new ArrayList<>();
        List<Pictures> picList = new ArrayList<>();
        for (Object result[] : products) {
            prList.add((Product) result[0]);
            System.out.println(prList);
        }

        int picount =0;
        for (Object result[] : products  ) {
            picList.add((Pictures) result[1]);
            picount++;
            System.out.println(picList + " " + picount);
        }*/
        session.setAttribute("pictureList", pictureList);
        session.setAttribute("productsList", productList);
        if (productId != null) {
            Product selectedProduct = productService.findById(Integer.parseInt(productId));
            session.setAttribute("selectedProduct", selectedProduct);
        }

      /*  byte[] bytes;
        byte[] encodeBase64 = Base64.encodeBase64(bytes);
        String base64Encoded = new String(encodeBase64, "UTF-8");
        session.setAttribute("picture", base64Encoded);*/
        return "/admin/products";
    }

    @GetMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") int productId, HttpServletRequest request) {
        Product product = productService.findById(productId);
        String rootDirectory = request.getSession().getServletContext().getRealPath("/");
        path = Paths.get(rootDirectory + "\\resources\\productImages\\" + product.getProductId() + ".png" );
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
        Category cat = categoryService.getById(Long.parseLong(selectedCategoryId));
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
    public String addProductPost(@RequestParam("productImage") CommonsMultipartFile[] productImage, HttpServletRequest request) throws IOException {
        String selectedCategoryId = request.getParameter("productCategoryId");
        Category cat = categoryService.getById(Long.parseLong(selectedCategoryId));
        String name = request.getParameter("productName");
        String desc = request.getParameter("productDesc");
        String price = request.getParameter("productPrice");
        String isPrimaryValue = request.getParameter("isPrimaryValue");
        Product product = productFactory.create(name, desc, decimalFormatUtil.format(price), cat);

        int numberOfUploadedPictures = 0;
        if (productImage != null && productImage.length > 0) {
            for (CommonsMultipartFile aFile : productImage){
                numberOfUploadedPictures++;
                Pictures pictures = new Pictures();
                pictures.setName(aFile.getOriginalFilename());
                pictures.setImageData(aFile.getBytes());
                pictures.setProduct(product);
                if (isPrimaryValue.equals(String.valueOf(numberOfUploadedPictures)) ) {
                    pictures.setPrymary(1);
                }
                fileUploadDAO.save(pictures);
            }
        }






        return "redirect:/admin/products";
    }




    @GetMapping("/login")
    public String login(Model model) {

        return "/login";
    }
}
