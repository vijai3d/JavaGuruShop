package lv.javaguru.java2.services.products;

import lv.javaguru.java2.domain.products.Product;

import java.util.List;

/**
 * Created by Victor on 24.03.2017.
 */
public interface ProductService {

//    TODO create more services
    void delete(int productId);

    List<Product> getAll();

    List<Product> getAllByCategory(int categoryId);
}
