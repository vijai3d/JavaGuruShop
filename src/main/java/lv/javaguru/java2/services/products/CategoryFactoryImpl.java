package lv.javaguru.java2.services.products;

import lv.javaguru.java2.database.jdbc.CategoryDAO;
import lv.javaguru.java2.domain.products.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import static lv.javaguru.java2.domain.products.CategoryBuilder.createCategory;

/**
 * Created by Victor on 24.03.2017.
 */
@Component
//@Transactional
class CategoryFactoryImpl  implements CategoryFactory{
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public Category create(String categoryName) {

        Category category = createCategory()
                .withCategoryName(categoryName)
                .build();

        return categoryDAO.save(category);
    }
}
