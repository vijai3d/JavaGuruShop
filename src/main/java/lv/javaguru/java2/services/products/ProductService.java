package lv.javaguru.java2.services.products;

import lv.javaguru.java2.domain.customer.Customer;
import lv.javaguru.java2.domain.products.Product;

import java.util.List;

/**
 * Created by Victor on 24.03.2017.
 */
public interface ProductService {

//    TODO create more services
    void delete(int productId);
    void update(Customer customer);
    List<Product> getAll();
    List<Product> getAllByCategory(Short categoryId);
    Product findById(int productId);
}
