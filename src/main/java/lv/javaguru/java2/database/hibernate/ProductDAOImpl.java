package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.products.Product;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vijai3D on 24.05.2017.
 */
@Component("HibernateProductDAOImpl")
@Transactional
public class ProductDAOImpl extends DAOImpl<Product> implements ProductDAO{

    @Override
    public void create(Product product) throws DBException {
        getCurrentSession().persist(product);
    }

    @Override
    public void update(Product product) throws DBException {
        getCurrentSession().update(product);
    }


    @Override
    public void delete(int id) throws DBException {
        Product product = (Product) getCurrentSession().get(Product.class, new Integer(id));
        if(null != product){
            getCurrentSession().delete(product);
        }
    }

    @Override
    public Product getById(int id) throws DBException {
        Product product = (Product) getCurrentSession().get(Product.class, new Integer(id));
        return product;
    }

    @Override
    public List<Product> getAll() {
        List<Product> products = getCurrentSession().createQuery("from Product ").list();
        return products;
    }

    @Override
    public List<Object[]> getAllofTwo() throws DBException {
        List<Object[]> productsList = getCurrentSession().createQuery("SELECT pr, pic FROM Product pr, Pictures pic")
                .list();
        return productsList;
    }
    @Override
    public List<Product> getAllByCategory(Long categoryId) throws DBException {
        List<Product> products = (List<Product>) getCurrentSession().createQuery("from Product where catid = :id")
                .setParameter("id", categoryId)
                .list();
        return products;
    }
}
