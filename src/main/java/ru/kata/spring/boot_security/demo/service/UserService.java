package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface UserService {

    Set<Role> listByName(List<String> name);
    boolean saveUser(User user);
    List<User> getAllUsers();
    void delete(long id);
    void updateUser(User user, long id);
    User getById(long id);

    User findByName(String name);

    User getCurrentUser();



}
