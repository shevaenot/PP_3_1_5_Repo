package ru.kata.spring.boot_security.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import ru.kata.spring.boot_security.demo.model.Role;
import ru.kata.spring.boot_security.demo.model.User;
import ru.kata.spring.boot_security.demo.service.RoleService;
import ru.kata.spring.boot_security.demo.service.UserService;

import java.util.HashSet;
import java.util.Set;

@Controller
@RequestMapping("/admin")
public class AdminController {

    private final RoleService roleService;
    private final UserService userService;

    public AdminController(RoleService roleService, UserService userService) {
        this.roleService = roleService;
        this.userService = userService;
    }


    @GetMapping
    public String userPage(Model model) {
        model.addAttribute("users", userService.getAllUsers());
        model.addAttribute("roleList", roleService.getAllRoles());
        return "admin";
    }

    @GetMapping("/user-create")
    public String newUser(ModelMap model) {
        model.addAttribute("user", new User());
        model.addAttribute("roles", roleService.getAllRoles());
        return "user-create";
    }

    @PostMapping("/user-create")
    public String create(@ModelAttribute("user") User user) {
        Set<Role> rolesList = new HashSet<>();
        for (Role role : user.getRoles()) {
            rolesList.add(roleService.getByName("ROLE_" + role));
        }
        user.setRoles(rolesList);
        userService.saveUser(user);
        return "redirect:/admin";
    }

    @GetMapping("/user-delete/{id}")
    public String deleteUser(@PathVariable("id") long id){
        userService.deleteUser(id);
        return "redirect:/admin";
    }

    @GetMapping("/user-update/{id}")
    public String updateUserForm(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        model.addAttribute("roles", roleService.getAllRoles());
        return "user-update";
    }
    @PostMapping("/user-update")
    public String update(@ModelAttribute("user") User user) {
        Set<Role> rolesList = new HashSet<>();
        for (Role role : user.getRoles()) {
            rolesList.add(roleService.getByName("ROLE_" + role));
        }
        user.setRoles(rolesList);
        userService.updateUser(user);
        return "redirect:/admin";
    }
}

