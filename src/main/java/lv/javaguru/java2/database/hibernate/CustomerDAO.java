package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.domain.customer.Customer;

import java.util.List;

/**
 * Created by Vijai3D on 15.05.2017.
 */
public interface CustomerDAO extends BaseDAO<Customer> {
    public void create(Customer customer);
    public void update(Customer customer);
    public List<Customer> getAll();
    public void delete(int id);
    public Customer getById(int id);

}
