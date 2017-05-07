package lv.javaguru.java2.services.products;

import lv.javaguru.java2.domain.products.Category;

import java.math.BigDecimal;

/**
 * Created by Vijai3D on 26.03.2017.
 */
public interface ProductValidator {
    void validate(String name, String description, BigDecimal price, Category category);
}
