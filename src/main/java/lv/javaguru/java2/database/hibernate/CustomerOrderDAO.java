package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.domain.customer.CustomerOrder;

/**
 * Created by Vijai3D on 25.05.2017.
 */
public interface CustomerOrderDAO extends BaseDAO<CustomerOrder> {
    CustomerOrder find(int id);
    CustomerOrder findByCustomer(Object customer);
}
