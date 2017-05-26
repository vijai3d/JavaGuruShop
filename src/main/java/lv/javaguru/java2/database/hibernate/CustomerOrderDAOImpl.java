package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.customer.CustomerOrder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Vijai3D on 25.05.2017.
 */
@Component
@Transactional
public class CustomerOrderDAOImpl extends DAOImpl<CustomerOrder> implements CustomerOrderDAO{


    @Override
    public CustomerOrder find(int id)  throws DBException {
        CustomerOrder customerOrder = getCurrentSession().load(CustomerOrder.class, new Integer(id));
        return customerOrder;
    }

    @Override
    public CustomerOrder findByCustomer(Object customer)  throws DBException{
        return (CustomerOrder) getCurrentSession().createNamedQuery("CustomerOrder.findByCustomer")
                .setParameter("customer", customer).getSingleResult();
    }
}
