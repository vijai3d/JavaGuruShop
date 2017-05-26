package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.customer.CustomerOrder;

/**
 * Created by Vijai3D on 25.05.2017.
 */
public interface CustomerOrderService {
    CustomerOrder find(int id);
    CustomerOrder findByCustomer(Object customer);
}
