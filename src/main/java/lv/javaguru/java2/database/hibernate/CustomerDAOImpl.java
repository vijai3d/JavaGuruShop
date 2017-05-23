package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.hibernate.CustomerDAO;
import lv.javaguru.java2.domain.customer.Customer;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by Vijai3D on 15.05.2017.
 */
@Repository
public class CustomerDAOImpl implements CustomerDAO {


    @Autowired
    private SessionFactory sessionFactory;


    @Override
    public void addCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.persist(customer);
    }

    @Override
    public void updateCustomer(Customer customer) {
        Session session = sessionFactory.getCurrentSession();
        session.update(customer);
    }

    @Override
    public List<Customer> listCustomers() {
        Session session = sessionFactory.getCurrentSession();
        List<Customer> customersList = session.createQuery("from Customer").list();
        return customersList;
    }

    @Override
    public void removeCustomer(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.load(Customer.class, new Integer(id));
        if(null != customer){
            session.delete(customer);
        }
    }

    @Override
    public Customer getCustomerById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Customer customer = (Customer) session.load(Customer.class, new Integer(id));

        return customer;
    }
}
