package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.customer.Customer;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Vijai3D on 15.05.2017.
 */
@Component("HibernateCustomerDAOImpl")
public class CustomerDAOImpl extends DAOImpl<Customer> implements CustomerDAO {

    @Override
    public void create(Customer customer) throws DBException {
        getCurrentSession().persist(customer);
    }

    @Override
    public Customer getById(int id) throws DBException {
        Customer customer = (Customer) getCurrentSession().get(Customer.class, new Integer(id));
        return customer;
    }

    @Override
    public void delete(int id) throws DBException {
        Customer customer = (Customer) getCurrentSession().get(Customer.class, new Integer(id));
        if(null != customer){
            getCurrentSession().delete(customer);
        }
    }

    @Override
    public void update(Customer customer) throws DBException {
        getCurrentSession().update(customer);
    }

    @Override
    public List<Customer> getAll() throws DBException {
        List<Customer> customersList = getCurrentSession().createQuery("from Customer").list();
        return customersList;
    }
}
