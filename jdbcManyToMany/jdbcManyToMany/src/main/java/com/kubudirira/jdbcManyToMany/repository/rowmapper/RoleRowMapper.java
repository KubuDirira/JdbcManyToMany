package com.kubudirira.jdbcManyToMany.repository.rowmapper;



import com.kubudirira.jdbcManyToMany.model.Role;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class RoleRowMapper implements RowMapper<Role> {
    @Override
    public Role mapRow(ResultSet resultSets, int rowNum) throws SQLException {
        return Role.builder()
                .id(resultSets.getInt("id"))
                .name(resultSets.getString("name"))
                .permission(resultSets.getString("permission"))
                .build();
    }
}
