package com.kubudirira.jdbcManyToMany.repository;



import com.kubudirira.jdbcManyToMany.model.User;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface UserRepository {

    /*Basic CRUD Application*/

    int create(User post, int user_id);
    Optional<User> get(int id);
    int delete(int id);
    int update(int id, User user);

    List<User> list();

    /*More Complex Operations*/


}
