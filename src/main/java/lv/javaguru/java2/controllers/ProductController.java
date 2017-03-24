package lv.javaguru.java2.controllers;

import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.domain.products.Product;
import lv.javaguru.java2.services.products.ProductFactory;
import lv.javaguru.java2.services.products.ProductFactoryImpl;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public class ProductController {
    public static void main(String[] args) {

        Category cat = new Category("CD");
        /*Product p1 = new Product("Ticket to the moon", "Description of Ticket to the moon", 18.88 );
        p1.setCategory(category);

        Product p2 = new Product("Ambient", "Description of Ambient", 19.90);
        p2.setCategory(category);
        category.addProduct(p1);
        category.addProduct(p2);

        System.out.println(p2);
        System.out.println(category);*/

        ProductFactory productFactory = new ProductFactoryImpl();
        cat.setCategoryId(1002);

        System.out.println(cat.getCategoryId());
        System.out.println(cat.getCategoryName());
        productFactory.create("CHASING HIGHS", "Going Backwards\n" +
                "Where's the Revolution\n" +
                "The Worst Crime\n" +
                "Scum\n" +
                "You Move\n" +
                "Cover Me\n" +
                "Eternal\n" +
                "Poison Heart\n" +
                "So Much Love\n" +
                "Poorman\n" +
                "No More (This is the Last Time)\n" +
                "Fail", 18.99, cat);

    }
}