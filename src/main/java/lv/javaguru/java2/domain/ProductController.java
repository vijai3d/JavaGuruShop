package lv.javaguru.java2.domain;

import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.domain.products.Product;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public class ProductController {
    public static void main(String[] args) {
        Category category = new Category("CD");
       Product p1 = new Product("Ticket to the moon", "Description of Ticket to the moon", 18.88 );
        p1.setCategory(category);

        Product p2 = new Product("Ambient", "Description of Ambient", 19.90);
        p2.setCategory(category);
        category.addProduct(p1);
        category.addProduct(p2);

        System.out.println(p2);
        System.out.println(category);

    }
}
