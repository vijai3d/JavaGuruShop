package lv.javaguru.java2.services.validators;

import lv.javaguru.java2.domain.products.Category;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

/**
 * Created by Vijai3D on 26.03.2017.
 */
@Component
public class ProductValidatorImpl implements ProductValidator {

    @Override
    public void validate(String name, String description, BigDecimal price, Category category) {
        validateName(name);
        validateDescription(description);
        validatePrice(price);
        validateCategory(category);
    }

    private void validateName(String name) {
        if (name == null || name.isEmpty()) {
            throw new IllegalArgumentException("Code must be not empty!");
        }else if (name.length() > 120) {
            throw new IllegalArgumentException("Code is too long");
        }
    }

    private void validateDescription(String description) {
        if (description == null || description.isEmpty()) {
            throw new IllegalArgumentException("Description must be not empty!");
        }else if (description.length() > 120) {
            throw new IllegalArgumentException("Description is too long");
        }
    }

    private void validatePrice(BigDecimal price) {
        Double temp = Double.valueOf(String.valueOf(price));
        if (price == null ) {
            throw new IllegalArgumentException("Price must be not empty!");
        }else if (Double.isNaN(temp)){
            throw new IllegalArgumentException("Price must br numeric");
            }


    }

    private void validateCategory(Category category) {
        if (category == null || category.getCategoryName().isEmpty()) {
            throw new IllegalArgumentException("Category must be not empty!");
        }else if (category.getCategoryName().length() > 30) {
            throw new IllegalArgumentException("Code is too long");
        }
    }


}
