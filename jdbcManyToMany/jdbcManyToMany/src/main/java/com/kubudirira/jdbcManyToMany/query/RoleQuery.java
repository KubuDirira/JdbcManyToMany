package com.kubudirira.jdbcManyToMany.query;

public class RoleQuery {


    public static final String INSERT_ROLE_TO_USER_QUERY  = "INSERT INTO UserRoles(user_id, role_id) VALUES (?, ?)";

    public static final String SELECT_ROLE_BY_NAME_QUERY = "SELECT * FROM Roles WHERE name = ?";

    public static final String SELECT_ROLE_QUERY = "SELECT * FROM Roles";
    public static final String SELECT_ROLE_BY_ID_QUERY = """
                                                        SELECT id, name, permission 
                                                        FROM Roles 
                                                        WHERE id = ?
                                                        """;
    public static final String SELECT_USERROLES_BY_USER_ID_QUERY = """
                                                SELECT Roles.id, Roles.name, Roles.permission
                                                FROM Roles
                                                INNER JOIN UserRoles
                                                ON UserRoles.role_id = Roles.id
                                                WHERE UserRoles.user_id = ?;
                                                """;



}
