package lv.javaguru.java2.configs;

import lv.javaguru.java2.database.jdbc.product.CategoryDAOIMmpl;
import lv.javaguru.java2.database.jdbc.product.ProductDAOImpl;
import lv.javaguru.java2.database.product.CategoryDAO;
import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.services.products.CategoryService;
import lv.javaguru.java2.services.products.CategoryServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Vijai3D on 03.05.2017.
 */

@Configuration
@ComponentScan(basePackages = {"lv.javaguru.java2"})
public class SpringConfig {



}
