package lv.javaguru.java2.services.products;

import lv.javaguru.java2.database.jdbc.product.ProductDAOImpl;
import lv.javaguru.java2.database.product.ProductDAO;
import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.domain.products.Product;

import static lv.javaguru.java2.domain.products.ProductBuilder.createProduct;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public class ProductFactoryImpl implements ProductFactory {

    private ProductDAO productDAO = new ProductDAOImpl();
    private ProductValidator productValidator = new ProductValidatorImpl();

    @Override
    public Product create(String code, String description, Double price, Category category) {

        productValidator.validate(code, description, price, category);

        Product product = createProduct()
                .withCode(code)
                .withDescription(description)
                .withPrice(price)
                .withCategory(category).build();

        return productDAO.save(product);
    }
}
