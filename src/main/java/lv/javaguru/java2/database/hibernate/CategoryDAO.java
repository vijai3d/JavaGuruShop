package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.products.Category;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vijai3D on 24.05.2017.
 */
public interface CategoryDAO {
     void create(Category category);
     void update(Category category);
     List<Category> getAll();
     void delete(byte id);
     Category getById(byte id);
}

@Component("HibernateCategoryDAOImpl")
class CategoryDAOImpl extends DAOImpl<Category> implements CategoryDAO{

     @Override
     public void create(Category category)  throws DBException {
          getCurrentSession().persist(category);
     }

     @Override
     public void update(Category category)  throws DBException {
          getCurrentSession().update(category);
     }

     @Override
     public void delete(byte id)  throws DBException {
          Category category = (Category) getCurrentSession().get(Category.class, new Byte(id));
          if(null !=  category){
               getCurrentSession().delete(category);
          }
     }

     @Override
     public Category getById(byte id)  throws DBException{
          Category category = (Category) getCurrentSession().get(Category.class, new Byte(id));
          return category;
     }

     @Override
     public List<Category> getAll() throws DBException {
          List<Category> categoryList = getCurrentSession().createQuery("from Category").list();
          return categoryList;
     }
}