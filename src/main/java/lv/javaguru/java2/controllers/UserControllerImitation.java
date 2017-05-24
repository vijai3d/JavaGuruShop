package lv.javaguru.java2.controllers;


import lv.javaguru.java2.database.jdbc.DAOImpl;
import lv.javaguru.java2.database.jdbc.product.CategoryDAOIMmpl;

import lv.javaguru.java2.database.product.CategoryDAO;
import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserBuilder;
import lv.javaguru.java2.domain.products.Category;
import lv.javaguru.java2.services.UserFactory;
import lv.javaguru.java2.services.UserFactoryImpl;
import lv.javaguru.java2.services.UserService;
import lv.javaguru.java2.services.UserServiceImpl;
import lv.javaguru.java2.services.products.CategoryService;
import lv.javaguru.java2.services.products.CategoryServiceImpl;
import lv.javaguru.java2.services.products.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * Created by Vijai3D on 22.03.2017.
 */
//Simple CRUD operations without servlet controllers

public class UserControllerImitation {

    public static void main(String[] args) {


        //CREATE new user prototype
        //UserFactory user = new UserFactoryImpl();
        //UserService userService = new UserServiceImpl();
        //user.create("Viktors", "Antipins");
        //UserBuilder.createUser();

        //UPDATE user prototype
        //getting new values from JSP form
        //Long tempId = Long.valueOf(1005);
        //String newFirstName = "Gorge";
        //String newLastName = "Mickle";
        //edit user by ID
        //userService.edit(tempId, newFirstName, newLastName);

        //DELETE user
        //userService.delete(tempId);

        //get user by id
        //Long userId = Long.valueOf(1005);
        //Optional<User> userOpt = userService.showById(userId);
        //System.out.println(userOpt.get().getFirstName() + " " +
         //userOpt.get().getLastName());

        //READ all userService prototype
       // List<User> userList= userService.showAll();
        //for(User u:userList) {
        //    System.out.println(u.getFirstName() + " " + u.getLastName());
        //}

    }
}
