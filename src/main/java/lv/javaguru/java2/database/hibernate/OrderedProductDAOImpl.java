package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.domain.orders.OrderedProduct;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Vijai3D on 25.05.2017.
 */
@Component
@Transactional
public class OrderedProductDAOImpl extends DAOImpl<OrderedProduct> implements OrderedProductDAO {
    @Override
    public List<OrderedProduct> findByOrderId(Object id) {
        return getCurrentSession().createNamedQuery("OrderedProduct.findByCustomerOrderId").setParameter("customerOrderId", id).getResultList();
    }
}
