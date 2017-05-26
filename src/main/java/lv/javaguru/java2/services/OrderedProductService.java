package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.orders.OrderedProduct;

import java.util.List;

/**
 * Created by Vijai3D on 25.05.2017.
 */
public interface OrderedProductService {
    List<OrderedProduct> findByOrderId(Object id);
}
