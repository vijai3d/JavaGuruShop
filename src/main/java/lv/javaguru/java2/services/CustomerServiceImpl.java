package lv.javaguru.java2.services;

import lv.javaguru.java2.database.hibernate.CustomerDAO;
import lv.javaguru.java2.domain.customer.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vijai3D on 15.05.2017.
 */
@Component
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    @Qualifier("HibernateCustomerDAOImpl")
    private CustomerDAO customerDAO;

//TODO add validation

    @Override
    public void create(Customer customer) {
        customerDAO.create(customer);
    }

    @Override
    public void update(Customer customer) {
        customerDAO.update(customer);
    }

    @Override
    public List<Customer> getAll() {
        return customerDAO.getAll();
    }

    @Override
    public void delete(int id) {
        customerDAO.delete(id);
    }

    @Override
    public Customer getById(int id) {
        return customerDAO.getById(id);
    }
}
