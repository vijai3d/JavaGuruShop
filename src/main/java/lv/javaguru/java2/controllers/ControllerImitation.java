package lv.javaguru.java2.controllers;

import lv.javaguru.java2.domain.User;
import lv.javaguru.java2.domain.UserBuilder;
import lv.javaguru.java2.services.UserFactory;
import lv.javaguru.java2.services.UserFactoryImpl;
import lv.javaguru.java2.services.UserService;
import lv.javaguru.java2.services.UserServiceImpl;

import java.util.List;

/**
 * Created by Vijai3D on 22.03.2017.
 */
//Simple CRUD operations without servlet controllers
public class ControllerImitation {

    public static void main(String[] args) {

        //CREATE new user prototype
        UserFactory user = new UserFactoryImpl();
        UserService users = new UserServiceImpl();
        //user.create("Viktors", "Antipins");
        UserBuilder.createUser();

        //UPDATE user prototype
        //getting new values from JSP form
        Long tempId = Long.valueOf(1005);
        String newFirstName = "Gorge";
        String newLastName = "Mickle";
        //edit user by ID
        users.edit(tempId, newFirstName, newLastName);

        //DELETE user
        //users.delete(tempId);

        //READ all users prototype
        List<User> userList= users.showAll();
        for(User u:userList) {
            System.out.println(u.getFirstName() + " " + u.getLastName());
        }

    }
}
