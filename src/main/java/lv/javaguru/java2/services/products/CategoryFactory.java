package lv.javaguru.java2.services.products;

import lv.javaguru.java2.domain.products.Category;

/**
 * Created by Victor on 24.03.2017.
 */
public interface CategoryFactory {
    Category create(String categoryName);

}
