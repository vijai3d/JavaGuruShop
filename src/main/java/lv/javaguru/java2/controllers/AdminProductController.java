package lv.javaguru.java2.controllers;

import lv.javaguru.java2.database.hibernate.FileUploadDAO;
import lv.javaguru.java2.domain.Pictures;
import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.domain.products.Product;
import lv.javaguru.java2.services.products.CategoryService;
import lv.javaguru.java2.services.products.ProductFactory;
import lv.javaguru.java2.services.products.ProductService;
import lv.javaguru.java2.services.utils.DecimalFormatUtil;
import org.apache.commons.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

@Controller
public class AdminProductController {
    @Autowired private ProductService productService;
    @Autowired private FileUploadDAO fileUploadDAO;
    @Autowired private CategoryService categoryService;
    @Autowired private DecimalFormatUtil decimalFormatUtil;
    @Autowired private ProductFactory productFactory;

    @GetMapping("/admin/products")
    public String viewProducts(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String productId = request.getQueryString();
        List<Product> productList = productService.getAll();
        List<Pictures> pictureList = fileUploadDAO.getAll();
        if (productId != null) {
            Product selectedProduct = productService.findById(Integer.parseInt(productId));
            session.setAttribute("selectedProduct", selectedProduct);
        }
        session.setAttribute("pictureList", pictureList);
        session.setAttribute("productsList", productList);
        return "/admin/products";
    }

    @GetMapping("/admin/products/delete/{id}")
    public String deleteProduct(@PathVariable("id") int productId) {
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

        //TODO create update pictures
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
                pictures.setEncodedData(encode64(aFile.getBytes()));
                pictures.setProduct(product);
                if (isPrimaryValue.equals(String.valueOf(numberOfUploadedPictures)) ) {
                    pictures.setPrymary(1);
                }
                fileUploadDAO.save(pictures);
            }
        }

        List<String> imageList = new ArrayList<>();
        //need to try save images to the filesystem and connect unique names with database
   /* String rootDirectory = request.getSession().getServletContext().getRealPath("/");
 +        path = Paths.get(rootDirectory + "\\resources\\images\\products\\" + product.getProductId() + ".png" );
 +        if (productImage != null && !productImage.isEmpty()) {
 +            try {
 +                productImage.transferTo(new File(path.toString()));
 +            } catch (Exception e) {
 +                e.printStackTrace();
 +                throw new RuntimeException("Product image saving failed", e);
 +            }
 +        }*/
        return "redirect:/admin/products";
    }

    public String encode64(byte[] bytes) throws UnsupportedEncodingException {

        byte[] encodeBase64 = Base64.encodeBase64(bytes);
        String base64Encoded = new String(encodeBase64, "UTF-8");
        return base64Encoded;
    }



}
