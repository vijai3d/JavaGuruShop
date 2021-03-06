package lv.javaguru.java2.services;

import lv.javaguru.java2.database.jdbc.UserDAO;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import static lv.javaguru.java2.domain.UserBuilder.createUser;

public class UserFactoryImpl implements UserFactory {
    @Autowired
    private UserValidator userValidator;
    @Autowired
    private UserDAO userDAO;


    @Override
    public User create(String firstName, String lastName) {
        userValidator.validate(firstName, lastName);

        User user = createUser()
                .withFirstName(firstName)
                .withLastName(lastName).build();

        return userDAO.save(user);
    }

}
