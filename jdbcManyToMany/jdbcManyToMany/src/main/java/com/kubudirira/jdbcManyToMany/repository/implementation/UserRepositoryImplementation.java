package com.kubudirira.jdbcManyToMany.repository.implementation;

import com.kubudirira.jdbcManyToMany.model.User;
import com.kubudirira.jdbcManyToMany.repository.RoleReposiroty;
import com.kubudirira.jdbcManyToMany.repository.UserRepository;
import com.kubudirira.jdbcManyToMany.repository.rowmapper.UserRowMapper;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.batch.BatchProperties;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.kubudirira.jdbcManyToMany.query.UserQuery.*;


@Repository
@RequiredArgsConstructor
@Slf4j
public class UserRepositoryImplementation implements UserRepository {

    private final JdbcTemplate jdbcTemplate;

    private final RoleReposiroty roleReposiroty;

    @Override
    public int create(User user, int user_id) {
        return  jdbcTemplate.update(INSERT_USER_QUERY, user.getFirstName(), user.getLastName(), user.getEmail());

    }

    @Override
    public Optional<User> get(int id) {
        return jdbcTemplate.query(SELECT_USER_BY_ID_QUERY,new UserRowMapper(),id)
                .stream()
                .findFirst();
    }

    @Override
    public int delete(int id) {
        return jdbcTemplate.update(DELETE_USER_QUERY,id);
    }

    @Override
    public int update(int id, User user) {
        return jdbcTemplate.update(UPDATE_USER_QUERY,
                user.getFirstName(),
                user.getLastName(),
                user.getEmail(),id);
    }

    @Override
    public List<User> list() {

        List<User> users =  jdbcTemplate.query(SELECT_USER_QUERY,new UserRowMapper());

        for(User user : users ){
            //add their passport for presentation


            if(!roleReposiroty.getRoleByUserId(user.getId()).isEmpty()){

                user.setRoles(roleReposiroty.getRoleByUserId(user.getId()));

            }else{
                user.setRoles(null);
            }
        }

        return users;
    }
}
