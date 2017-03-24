package lv.javaguru.java2.services.products;

import lv.javaguru.java2.database.jdbc.product.CategoryDAOIMmpl;
import lv.javaguru.java2.database.product.CategoryDAO;
import lv.javaguru.java2.domain.products.Category;

import static lv.javaguru.java2.domain.products.CategoryBuilder.createCategory;

/**
 * Created by Victor on 24.03.2017.
 */
public class CategoryFactoryImpl  implements CategoryFactory{

    private CategoryDAO categoryDAO = new CategoryDAOIMmpl();

    @Override
    public Category create(String categoryName) {

        Category category = createCategory()
                .withCategoryName(categoryName).build();

        return categoryDAO.save(category);
    }
}
