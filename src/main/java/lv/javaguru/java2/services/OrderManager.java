package lv.javaguru.java2.services;

import lv.javaguru.java2.cart.ShoppingCart;
import lv.javaguru.java2.cart.ShoppingCartItem;
import lv.javaguru.java2.database.DBException;
import lv.javaguru.java2.domain.customer.Customer;
import lv.javaguru.java2.domain.customer.CustomerOrder;
import lv.javaguru.java2.domain.orders.OrderedProduct;
import lv.javaguru.java2.domain.orders.OrderedProductPK;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;
import java.util.Random;

/**
 * Created by Vijai3D on 18.05.2017.
 */
@Component
public class OrderManager {

    @Autowired
    private SessionFactory sessionFactory;

    @Transactional
    public int placeOrder(String name, String email, String phone, String address, String city, String country, ShoppingCart cart) {

            Customer customer = addCustomer(name, email, phone, address, city, country);
            CustomerOrder order = addOrder(customer, cart);
            addOrderedItems(order, cart);
            return order.getId();

    }

    private Customer addCustomer(String name, String email, String phone, String address, String cityRegion, String ccNumber) {

        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhone(phone);
        customer.setAddress(address);
        customer.setCity(cityRegion);
        customer.setCountry(ccNumber);
        Session session = sessionFactory.getCurrentSession();
        session.persist(customer);
        return customer;
    }
    private CustomerOrder addOrder(Customer customer, ShoppingCart cart) {


        CustomerOrder order = new CustomerOrder();
        order.setCustomer(customer);
        order.setAmount(BigDecimal.valueOf(cart.getTotal()));

        // create confirmation number
        Random random = new Random();
        int i = random.nextInt(999999999);
        order.setConfirmationNumber(i);
        Session session = sessionFactory.getCurrentSession();
        session.persist(order);
        return order;
    }

    private void addOrderedItems(CustomerOrder order, ShoppingCart cart) {
        Session session = sessionFactory.getCurrentSession();
        session.flush();

        List<ShoppingCartItem> items = cart.getItems();

        // iterate through shopping cart and create OrderedProducts
        for (ShoppingCartItem scItem : items) {

            int productId = scItem.getProduct().getProductId();

            // set up primary key object
            OrderedProductPK orderedProductPK = new OrderedProductPK();
            orderedProductPK.setCustomerOrderId(order.getId());
            orderedProductPK.setProductId(productId);

            // create ordered item using PK object
            OrderedProduct orderedItem = new OrderedProduct(orderedProductPK);

            // set quantity
            orderedItem.setQuantity(scItem.getQuantity());

            session.persist(orderedItem);
        }
    }

}
