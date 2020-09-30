package eci.ieti.api.service;

import eci.ieti.api.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    List<User> getAll();

    User getById(String userId);

    User create(User user);

    User update(User user);

    void remove(String userId);
}
