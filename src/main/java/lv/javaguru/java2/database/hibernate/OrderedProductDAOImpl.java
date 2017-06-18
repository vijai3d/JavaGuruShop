package lv.javaguru.java2.database.hibernate;

import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.orders.OrderedProduct;
import org.springframework.stereotype.Component;


import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Vijai3D on 25.05.2017.
 */
@Component
@Transactional
public class OrderedProductDAOImpl extends DAOImpl<OrderedProduct> implements OrderedProductDAO {
    @Override
    public List<OrderedProduct> findByOrderId(Object id) {
        return getCurrentSession().createQuery("SELECT o FROM OrderedProduct o WHERE o.orderedProductPK.customerOrderId = :customerOrderId")
                .setParameter("customerOrderId", id)
                .list();
    }

}
