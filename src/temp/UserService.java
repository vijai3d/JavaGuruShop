package lv.javaguru.java2.services;

import lv.javaguru.java2.domain.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    void edit(Long userId, String newFirstName, String newLastName);

    List<User> showAll();

    Optional<User> showById(Long userId);

    void delete(Long userId);

}
