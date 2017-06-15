package lv.javaguru.java2.servlet;

import lv.javaguru.java2.database.hibernate.ProductDAO;
import lv.javaguru.java2.domain.products.Product;
import lv.javaguru.java2.filter.mvc.MVCController;
import lv.javaguru.java2.filter.mvc.MVCModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;
import javax.servlet.http.HttpServletRequest;


/**
 * Created by Vijai3D on 29.05.2017.
 */
@Component
public class TestServlet implements MVCController{

    @Autowired
    private ProductDAO productDAO;

    @Override
    public MVCModel processGet(HttpServletRequest request) {

        Product product = productDAO.getById(1);

        request.setAttribute("productParam", String.valueOf(product.getName()));

        return new MVCModel("/test.jsp");
    }

    @Override
    public MVCModel processPost(HttpServletRequest request) {
        return null;
    }
}
