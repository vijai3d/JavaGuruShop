package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.domain.products.Product;
import java.util.List;

/**
 * Created by Vijai3D on 24.05.2017.
 */
public interface ProductDAO extends BaseDAO<Product> {
     void create(Product product);
     void update(Product product);
     List<Product> getAll();
     void delete(int id);
     Product getById(int id);
     List<Product> getAllByCategory(Short categoryId);
}
