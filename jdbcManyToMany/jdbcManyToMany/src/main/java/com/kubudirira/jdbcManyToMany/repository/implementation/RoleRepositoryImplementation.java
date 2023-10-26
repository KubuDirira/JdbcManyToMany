package com.kubudirira.jdbcManyToMany.repository.implementation;

import com.kubudirira.jdbcManyToMany.exception.ApiException;
import com.kubudirira.jdbcManyToMany.model.Role;
import com.kubudirira.jdbcManyToMany.repository.RoleReposiroty;
import com.kubudirira.jdbcManyToMany.repository.rowmapper.RoleRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

import static com.kubudirira.jdbcManyToMany.enumeration.RoleType.ROLE_USER;
import static com.kubudirira.jdbcManyToMany.query.RoleQuery.*;

@Repository
@RequiredArgsConstructor
@Slf4j
public class RoleRepositoryImplementation implements RoleReposiroty {

    private final JdbcTemplate jdbcTemplate;


    @Override
    public Optional<Role> get(int id) {

        return jdbcTemplate.query(SELECT_ROLE_BY_ID_QUERY,new RoleRowMapper(),id)
                .stream()
                .findFirst();
    }

    @Override
    public List<Role> list() {
        return jdbcTemplate.query(SELECT_ROLE_QUERY,new RoleRowMapper());
    }

    @Override
    public void addRoleToUser(Long Userid, String roleName) {

        log.info("Adding role {} to user id: {} ", roleName, Userid);

        try{

            Role role = jdbcTemplate.query(SELECT_ROLE_BY_NAME_QUERY,new RoleRowMapper() ,roleName).stream().findFirst().get();

            //Insert into UserRole Table
            jdbcTemplate.update(INSERT_ROLE_TO_USER_QUERY,Userid,role.getId());

        }catch (EmptyResultDataAccessException exception){
            throw new ApiException("No role found by name: " + roleName);
        }catch(Exception exception){
            throw new ApiException("An error occured. Please try again.");

        }
    }

    @Override
    public List<Role> getRoleByUserId(int userId) {
        //I have role and roleuser table.
        return jdbcTemplate.query(SELECT_USERROLES_BY_USER_ID_QUERY,new RoleRowMapper(),userId).stream().toList();

    }


    @Override
    public void updateUserRole(Long userId, String roleName) {

    }
}
