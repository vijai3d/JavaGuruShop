package lv.javaguru.java2.database.product;

import lv.javaguru.java2.domain.products.Category;

/**
 * Created by Victor on 24.03.2017.
 */
public interface CategoryDAO {
    Category save(Category category);
}
