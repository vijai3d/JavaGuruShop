package lv.javaguru.java2.services;

import lv.javaguru.java2.database.hibernate.CustomerDAO;
import lv.javaguru.java2.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vijai3D on 15.05.2017.
 */
@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    @Qualifier("HibernateCustomerDAOImpl")
    private CustomerDAO customerDAO;

//TODO add validation

    @Override
    @Transactional
    public void create(Customer customer) {
        customerDAO.create(customer);
    }

    @Override
    @Transactional
    public void update(Customer customer) {
        customerDAO.update(customer);
    }

    @Override
    @Transactional
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    @Override
    @Transactional
    public void delete(int id) {
        customerDAO.delete(id);
    }

    @Override
    @Transactional
    public Customer getById(int id) {
        return customerDAO.getById(id);
    }
}
