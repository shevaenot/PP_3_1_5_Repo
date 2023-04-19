package ru.kata.spring.boot_security.demo.service;

import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;

import java.util.List;
import java.util.Set;

public interface RoleService {

    void add(Role role);

    List<Role> getListRoles();

    List<Role> getRolesListById(List<Long> id);

    Role getRoleById(long id);

    Set<Role> listByName(List<String> name);
}
