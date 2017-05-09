package lv.javaguru.java2.services.products;

import lv.javaguru.java2.domain.products.Category;

import java.util.List;

/**
 * Created by Victor on 24.03.2017.
 */

public interface CategoryService {
//    TODO create more services
    void delete(int categoryId);

    List<Category> getAll();

    Category findById(Short categoryId);

}
