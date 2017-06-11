package lv.javaguru.java2.services.products;

import lv.javaguru.java2.domain.customer.Customer;
import lv.javaguru.java2.domain.products.Product;

import java.util.List;

/**
 * Created by Victor on 24.03.2017.
 */
public interface ProductService {


    void delete(int productId);
    void update(Product product);
    List<Product> getAll();
    List<Product> getAllByCategory(byte categoryId);
    Product findById(int productId);
}
