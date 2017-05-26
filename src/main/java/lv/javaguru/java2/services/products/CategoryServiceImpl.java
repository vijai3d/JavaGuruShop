package lv.javaguru.java2.services.products;


import lv.javaguru.java2.database.hibernate.CategoryDAO;
import lv.javaguru.java2.domain.products.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vijai3D on 06.05.2017.
 */
@Component
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    @Qualifier("HibernateCategoryDAOImpl")
    private CategoryDAO categoryDAO;

    @Override
    public void delete(byte categoryId) {

    }

    @Override
    public List<Category> getAll() {

        List<Category> categoryList = categoryDAO.getAll();

        return categoryList;
    }

    @Override
    public Category getById(byte categoryId) {
        Category category = categoryDAO.getById(categoryId);
        return category;
    }
}
