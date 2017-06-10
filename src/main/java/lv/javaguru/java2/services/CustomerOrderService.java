package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.customer.CustomerOrder;

import java.util.List;

/**
 * Created by Vijai3D on 25.05.2017.
 */
public interface CustomerOrderService {
    CustomerOrder find(int id);
    List<CustomerOrder> findByCustomer(Object customer);
}
