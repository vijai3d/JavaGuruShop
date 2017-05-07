package lv.javaguru.java2.database.product;

import lv.javaguru.java2.domain.products.Product;

import java.util.List;
import java.util.Optional;

/**
 * Created by Vijai3D on 23.03.2017.
 */
public interface ProductDAO {

    Product save(Product product);

    Optional<Product> getById(int id);

    void delete(int id);

    void update(Product product);

    List<Product> getAll();
}
