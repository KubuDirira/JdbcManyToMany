package com.kubudirira.jdbcManyToMany.repository;



import com.kubudirira.jdbcManyToMany.model.Role;
import com.kubudirira.jdbcManyToMany.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface RoleReposiroty  {
    Optional<Role> get(int id);

    List<Role> list();

    /*More Complex Operations*/
    void addRoleToUser(Long Userid, String roleName);

    List<Role>  getRoleByUserId(int userId);

    void updateUserRole(Long userId, String roleName);
}
