package lv.javaguru.java2.database.product;

import lv.javaguru.java2.domain.products.Product;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public interface ProductDAO {
    Product save(Product product);
}
