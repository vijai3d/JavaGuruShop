package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import java.util.List;

/**
 * Created by Vijai3D on 24.05.2017.
 */
public interface BaseDAO<T> {
    void create(T type) throws DBException;

    T getById(Long id) throws DBException;

    void delete(Long id) throws DBException;

    void update(T type) throws DBException;

    List<T> getAll() throws DBException;
}

