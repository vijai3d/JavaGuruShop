package lv.javaguru.java2.configs;

import lv.javaguru.java2.database.jdbc.product.ProductDAOImpl;
import lv.javaguru.java2.database.product.CategoryDAO;
import lv.javaguru.java2.services.products.ProductService;
import lv.javaguru.java2.services.products.ProductServiceImpl;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.Assert.*;

/**
 * Created by Vijai3D on 03.05.2017.
 */
public class SpringConfigTest {

    @Test
    public  void test() {
        ApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        CategoryDAO productDAO =  context.getBean(CategoryDAO.class);
        assertNotNull(productDAO);


    }

}