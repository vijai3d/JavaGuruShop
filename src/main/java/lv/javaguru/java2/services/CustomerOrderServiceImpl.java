package lv.javaguru.java2.services;

import lv.javaguru.java2.database.hibernate.CustomerOrderDAO;
import lv.javaguru.java2.domain.customer.CustomerOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by Vijai3D on 25.05.2017.
 */
@Component
@Transactional
public class CustomerOrderServiceImpl implements CustomerOrderService {

    @Autowired
    private CustomerOrderDAO customerOrderDAO;

    @Override
    public CustomerOrder find(int id) {

        return customerOrderDAO.find(id);
    }

    @Override
    public CustomerOrder findByCustomer(Object customer) {
        return customerOrderDAO.findByCustomer(customer);
    }
}
