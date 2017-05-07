package lv.javaguru.java2.services;

import lv.javaguru.java2.database.UserDAO;
import lv.javaguru.java2.database.jdbc.UserDAOImpl;
import lv.javaguru.java2.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class UserServiceImpl implements UserService {
    @Autowired
    private UserDAO userDAO;
    @Autowired
    private UserValidator userValidator;

    @Override
    public void edit(Long userId,
                     String newFirstName,
                     String newLastName) {
        Optional<User> userOpt = userDAO.getById(userId);
        if (!userOpt.isPresent()) {
            throw new IllegalArgumentException("User not found by id = " + userId);
        }

        userValidator.validate(newFirstName, newLastName);

        User user = userOpt.get();
        user.setFirstName(newFirstName);
        user.setLastName(newLastName);
        userDAO.update(user);
    }

    @Override
    public List<User> showAll() {
        List<User> userList = userDAO.getAll();
        return userList;
    }

    @Override
    public Optional<User> showById(Long userId) {
        Optional<User> user = userDAO.getById(userId);
        return user;
    }


    @Override
    public void delete(Long userId) {
        userDAO.delete(userId);
    }

}
