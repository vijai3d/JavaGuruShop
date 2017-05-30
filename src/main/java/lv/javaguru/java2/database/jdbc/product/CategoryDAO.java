package lv.javaguru.java2.database.jdbc.product;

import lv.javaguru.java2.domain.products.Category;

import java.util.List;

/**
 * Created by Victor on 24.03.2017.
 */

public interface CategoryDAO {
    Category save(Category category);

    Category findById(Short id);

    void delete(Short id);

    void update(Category category);

    List<Category> getAll();


}
