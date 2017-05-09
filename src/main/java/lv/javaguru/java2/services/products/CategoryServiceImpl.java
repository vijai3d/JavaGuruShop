package lv.javaguru.java2.services.products;

import lv.javaguru.java2.database.product.CategoryDAO;
import lv.javaguru.java2.domain.products.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

/**
 * Created by Vijai3D on 06.05.2017.
 */
@Component
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private CategoryDAO categoryDAO;

    @Override
    public void delete(int categoryId) {

    }

    @Override
    public List<Category> getAll() {

        List<Category> categoryList = categoryDAO.getAll();

        return categoryList;
    }

    @Override
    public Category findById(Short categoryId) {
        Category category = categoryDAO.findById(categoryId);
        return category;
    }
}
