package lv.javaguru.java2.services.products;

import lv.javaguru.java2.domain.products.Category;

import java.math.BigDecimal;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public interface ProductFactory {
    void create(String name, String description, BigDecimal price, Category category);
}
