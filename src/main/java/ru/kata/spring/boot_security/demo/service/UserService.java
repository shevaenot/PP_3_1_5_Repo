package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;

public interface UserService {

    User getById(Long id);

    List<User> listUsers();

    boolean saveUser(User user);

    void removeUser(Long id);

    void updateUser(User user);

    List<Role> listByRole(List<String> lsr);

    User findByName(String name);
}
