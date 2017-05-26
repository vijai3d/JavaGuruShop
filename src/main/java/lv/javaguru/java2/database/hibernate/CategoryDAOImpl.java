package lv.javaguru.java2.database.hibernate;


import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.customer.Customer;
import lv.javaguru.java2.domain.products.Category;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vijai3D on 24.05.2017.
 */
@Component("HibernateCategoryDAOImpl")
@Transactional
public class CategoryDAOImpl  implements CategoryDAO{
    @Autowired
    private SessionFactory sessionFactory;
    @Override
    public void create(Category category)  throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.persist(category);
    }

    @Override
    public void update(Category category)  throws DBException {
        Session session = sessionFactory.getCurrentSession();
        session.update(category);
    }

    @Override
    public void delete(byte id)  throws DBException {
        Session session = sessionFactory.getCurrentSession();
        Category category = session.load(Category.class, new Byte(id));
        if(null !=  category){
            session.delete(category);
        }
    }

    @Override
    public Category getById(byte id)  throws DBException{
        Session session = sessionFactory.getCurrentSession();
        Category category = session.load(Category.class, new Byte(id));
        return category;
    }

    @Override
    public List<Category> getAll() throws DBException {
        Session session = sessionFactory.getCurrentSession();
        List<Category> categoryList = session.createQuery("from Category").list();
        return categoryList;
    }
}
