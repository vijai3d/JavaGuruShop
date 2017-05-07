package lv.javaguru.java2.servlet.mvc;

import lv.javaguru.java2.services.products.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vijai3D on 07.05.2017.
 */
@Component
public class CategoryController implements MVCController{

    @Autowired
    private CategoryService categoryService;
    @Override
    public MVCModel processGet(HttpServletRequest request) {
        request.setAttribute("categories", categoryService.getAll());

            String categoryId = request.getQueryString();
        if (categoryId != null) {
            Short selectedCategory = categoryService.find(Short.parseShort(categoryId));
            request.setAttribute("selectedCategory", selectedCategory);
        }
        return new MVCModel("/view/category.jsp");
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        return null;
    }
}
