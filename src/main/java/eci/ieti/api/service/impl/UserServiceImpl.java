package eci.ieti.api.service.impl;

import eci.ieti.api.model.User;
import eci.ieti.api.service.UserService;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class UserServiceImpl implements UserService {

    private User user = new User("jeymar@mail.com", "Jeymar Vega", "password");

    @Override
    public List<User> getAll() {
        List<User> users = new ArrayList<>();
        users.add(user);
        return users;
    }

    @Override
    public User getById(String userId) {
        if(user.getEmail().equals(userId)){
            return user;
        }else{
            return null;
        }

    }

    @Override
    public User create(User user) {
        return user;
    }

    @Override
    public User update(User user) {
        return user;
    }

    @Override
    public void remove(String userId) {
    }
}
