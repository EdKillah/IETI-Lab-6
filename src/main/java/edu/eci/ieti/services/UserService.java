package edu.eci.ieti.services;

import java.util.List;
import edu.eci.ieti.models.User;


public interface UserService {

    List<User> getAll();

    User getById(String userId);

    User create(User user);

    User update(User user);

    void remove(String userId);
}