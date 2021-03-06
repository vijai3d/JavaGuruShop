package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.customer.CustomerOrder;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import java.util.List;


/**
 * Created by Vijai3D on 25.05.2017.
 */
@Component
public class CustomerOrderDAOImpl extends DAOImpl<CustomerOrder> implements CustomerOrderDAO{


    @Override
    public CustomerOrder find(int id)  throws DBException {
        CustomerOrder customerOrder = (CustomerOrder) getCurrentSession().get(CustomerOrder.class, new Integer(id));
        return customerOrder;
    }

    @Override
    public List<CustomerOrder> findByCustomer(Object customer)  throws DBException{
         List<CustomerOrder> customerOrders = (List<CustomerOrder>) getCurrentSession().createQuery("SELECT c FROM CustomerOrder c WHERE c.customer = :customer")
                .setParameter("customer", customer).list();
         return customerOrders;
    }
}
