package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import javax.transaction.Transactional;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * Created by Vijai3D on 24.05.2017.
 */
//@Transactional
abstract class DAOImpl<T> implements BaseDAO<T> {

    private Class<T> persistentClass;

    @SuppressWarnings("unchecked")
    public DAOImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().
                getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Autowired
    public SessionFactory sessionFactory;

    public Session getCurrentSession() {
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void create(T type) throws DBException {
        getCurrentSession().persist(type);
    }

    @Override
    public T getById(Long id) throws DBException {
        return (T) getCurrentSession().get(persistentClass, id);
    }

    @Override
    public void delete(Long id) throws DBException {
        Session session = sessionFactory.getCurrentSession();
        T type = (T) session.get(persistentClass, id);
        session.delete(type);
    }

    @Override
    public void update(T type) throws DBException {
        getCurrentSession().update(type);
    }

    @Override
    public List<T> getAll() throws DBException {
        return getCurrentSession().createCriteria(persistentClass).list();
    }
}
