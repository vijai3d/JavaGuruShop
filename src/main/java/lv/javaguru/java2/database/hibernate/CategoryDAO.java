package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.domain.products.Category;

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
