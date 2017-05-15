package lv.javaguru.java2.database;

import lv.javaguru.java2.domain.customer.Customer;

import java.util.List;

/**
 * Created by Vijai3D on 15.05.2017.
 */
public interface CustomerDAO {
    public void addCustomer(Customer customer);
    public void updateCustomer(Customer customer);
    public List<Customer> listCustomers();
    public void removeCustomer(int id);
    public Customer getCustomerById(int id);

}
