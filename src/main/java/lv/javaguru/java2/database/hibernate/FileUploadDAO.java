package lv.javaguru.java2.database.hibernate;


import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.Pictures;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface FileUploadDAO {
    void save(Pictures pictures);
    List<Pictures> getAll();
}

@Repository
@Transactional
class FileUploadDAOImpl extends DAOImpl<Pictures> implements FileUploadDAO {
    @Autowired private SessionFactory sessionFactory;

    public FileUploadDAOImpl() {
    }

    public FileUploadDAOImpl(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override

    public void save(Pictures pictures) {
        sessionFactory.getCurrentSession().save(pictures);
    }

    @Override
    public List<Pictures> getAll() {
        List<Pictures> pictures = getCurrentSession().createQuery("from Pictures")
                .list();
        return pictures;
    }
}