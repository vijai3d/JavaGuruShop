package lv.javaguru.java2.services.products;


import lv.javaguru.java2.database.hibernate.FileUploadDAO;
import lv.javaguru.java2.database.hibernate.ProductDAO;
import lv.javaguru.java2.domain.Pictures;
import lv.javaguru.java2.domain.customer.Customer;
import lv.javaguru.java2.domain.products.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Victor on 24.03.2017.
 */
@Component
@Transactional
public class ProductServiceImpl implements ProductService {

    @Autowired
    @Qualifier("HibernateProductDAOImpl")
    private ProductDAO productDAO;

    @Autowired
    private FileUploadDAO fileUploadDAO;

    @Override
    public void delete(int productId) {
        productDAO.delete(productId);
    }

    @Override
    public void update(Product product) {
        productDAO.update(product);
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = productDAO.getAll();
        return productList;
    }

    @Override
    public List<Product> getAllByCategory(Long categoryId) {
        List<Product> productListByCategory = productDAO.getAllByCategory(categoryId);
        return productListByCategory;
    }

    @Override
    public Product findById(int productId) {
        Product product = productDAO.getById(productId);
        return product;
    }
}
