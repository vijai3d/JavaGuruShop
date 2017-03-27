package lv.javaguru.java2.services.products;

import lv.javaguru.java2.domain.products.Category;

import java.text.DecimalFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Vijai3D on 26.03.2017.
 */
public class ProductValidatorImpl implements ProductValidator {

    @Override
    public void validate(String code, String description, Double price, Category category) {
        validateCode(code);
        validateDescription(description);
        validatePrice(price);
        validateCategory(category);
    }

    private void validateCode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code must be not empty!");
        }else if (code.length() > 120) {
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

    private void validatePrice(Double price) {

        if (price == null ) {
            throw new IllegalArgumentException("Price must be not empty!");
        }else if (price.isNaN()) {
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
