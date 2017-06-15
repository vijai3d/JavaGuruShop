package lv.javaguru.java2.services.products;

import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.domain.products.Product;

import java.math.BigDecimal;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public interface ProductFactory {
    Product create(String name, String description, BigDecimal price, Category category);
}
