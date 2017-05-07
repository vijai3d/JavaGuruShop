package lv.javaguru.java2.services.products;

import lv.javaguru.java2.database.product.CategoryDAO;
import lv.javaguru.java2.domain.products.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

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
        System.out.println("catList from CategoryServiceImpl");
        List<Category> categoryList = categoryDAO.getAll();

        return categoryList;
    }
}
