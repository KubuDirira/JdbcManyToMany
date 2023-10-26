package com.kubudirira.jdbcManyToMany.controller;



import com.kubudirira.jdbcManyToMany.model.Role;
import com.kubudirira.jdbcManyToMany.model.User;
import com.kubudirira.jdbcManyToMany.repository.RoleReposiroty;
import com.kubudirira.jdbcManyToMany.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {
    private final UserRepository userRepository;
    private final RoleReposiroty roleRepository;


    @GetMapping("/all")
    public List<User> findAllUsers(){
        return userRepository.list();
    }

    @GetMapping("/allRoles")
    public List<Role> findAllRoles(){
        return roleRepository.list();
    }



}
