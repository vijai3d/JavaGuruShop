package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.User;

import java.util.List;

public interface UserService {

    void edit(Long userId, String newFirstName, String newLastName);

    List<User> showAll();

    void delete(Long userId);

}
