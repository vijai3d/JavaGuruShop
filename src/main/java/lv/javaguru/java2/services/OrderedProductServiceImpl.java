package lv.javaguru.java2.services;

import lv.javaguru.java2.database.hibernate.OrderedProductDAO;
import lv.javaguru.java2.domain.orders.OrderedProduct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Vijai3D on 25.05.2017.
 */
@Component
@Transactional
public class OrderedProductServiceImpl implements OrderedProductService {
    @Autowired
    private OrderedProductDAO orderedProductDAO;

    @Override
    public List<OrderedProduct> findByOrderId(Object id) {
        return orderedProductDAO.findByOrderId(id);
    }
}
