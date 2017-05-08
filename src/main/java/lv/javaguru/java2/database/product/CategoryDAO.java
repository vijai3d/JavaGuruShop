package lv.javaguru.java2.database.product;

import lv.javaguru.java2.domain.products.Category;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Created by Victor on 24.03.2017.
 */

public interface CategoryDAO {
    Category save(Category category);

    Optional<Category> findById(Short id);

    void delete(Short id);

    void update(Category category);

    List<Category> getAll();


}
