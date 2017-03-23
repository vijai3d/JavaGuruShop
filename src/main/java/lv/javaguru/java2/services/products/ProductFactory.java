package lv.javaguru.java2.services.products;

import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.domain.products.Product;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public interface ProductFactory {
    Product create(String code, String description, Double price, Category category);
}
