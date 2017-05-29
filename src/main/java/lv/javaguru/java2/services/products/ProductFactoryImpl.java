package lv.javaguru.java2.services.products;


import lv.javaguru.java2.database.hibernate.ProductDAO;
import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.domain.products.Product;
import lv.javaguru.java2.validators.ProductValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.math.BigDecimal;

import static lv.javaguru.java2.domain.products.ProductBuilder.createProduct;

/**
 * Created by Vijai3D on 23.03.2017.
 */
@Component
//@Transactional
public class ProductFactoryImpl implements ProductFactory {
    @Autowired
    @Qualifier("HibernateProductDAOImpl")
    private ProductDAO productDAO;
    @Autowired
    private ProductValidator productValidator;

    @Override
    public void create(String name, String description, BigDecimal price, Category category) {

        productValidator.validate(name, description, price, category);

        Product product = createProduct()
                .withName(name)
                .withDescription(description)
                .withPrice(price)
                .withCategory(category).build();

       productDAO.create(product);
    }
}
