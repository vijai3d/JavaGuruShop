package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.domain.customer.CustomerOrder;

import java.util.List;

/**
 * Created by Vijai3D on 25.05.2017.
 */
public interface CustomerOrderDAO extends BaseDAO<CustomerOrder> {
    CustomerOrder find(int id);
    List<CustomerOrder> findByCustomer(Object customer);
}
