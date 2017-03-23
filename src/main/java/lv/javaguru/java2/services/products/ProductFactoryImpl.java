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
    @Override
    public Product create(String code, String description, Double price, Category category) {

        Product product = createProduct()
                .withCode()
                .withDescription()
                .withPrice()
                .withCategory().build();

        return productDAO.save(product);
    }
}
