package lv.javaguru.java2.services.validators;

import lv.javaguru.java2.domain.products.Category;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by Vijai3D on 26.03.2017.
 */
@Component
public interface ProductValidator {
    void validate(String name, String description, BigDecimal price, Category category);
}
