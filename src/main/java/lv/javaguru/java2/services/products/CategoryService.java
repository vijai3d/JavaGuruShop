package lv.javaguru.java2.services.products;

import lv.javaguru.java2.domain.products.Category;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/**
 * Created by Victor on 24.03.2017.
 */

public interface CategoryService {
//    TODO create more services
    void delete(int categoryId);

    List<Category> getAll();

    Optional<Category> findById(Short categoryId);

}
