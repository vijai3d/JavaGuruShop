package lv.javaguru.java2.cart;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Vijai3D on 13.05.2017.
 */
public interface Validator {
    boolean validateQuantity (String productId, String quantity);
    boolean validateForm(String name,
                         String email,
                         String phone,
                         String address,
                         String cityRegion,
                         String ccNumber,
                         HttpServletRequest request);
}
