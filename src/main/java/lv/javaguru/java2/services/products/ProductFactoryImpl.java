package lv.javaguru.java2.services.products;

import lv.javaguru.java2.database.jdbc.product.ProductDAOImpl;
import lv.javaguru.java2.database.product.ProductDAO;
import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.domain.products.Product;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;

import static lv.javaguru.java2.domain.products.ProductBuilder.createProduct;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public class ProductFactoryImpl implements ProductFactory {
    @Autowired
    private ProductDAO productDAO;
    @Autowired
    private ProductValidator productValidator;

    @Override
    public Product create(String name, String description, BigDecimal price, Category category) {

        productValidator.validate(name, description, price, category);

        Product product = createProduct()
                .withName(name)
                .withDescription(description)
                .withPrice(price)
                .withCategory(category).build();

        return productDAO.save(product);
    }
}
