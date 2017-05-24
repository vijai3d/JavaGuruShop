package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.customer.Customer;

import java.util.List;

/**
 * Created by Vijai3D on 15.05.2017.
 */
public interface CustomerService {
    public void create(Customer customer);
    public void update(Customer customer);
    public List<Customer> getAll();
    public void delete(int id);
    public Customer getById(int id);
}
