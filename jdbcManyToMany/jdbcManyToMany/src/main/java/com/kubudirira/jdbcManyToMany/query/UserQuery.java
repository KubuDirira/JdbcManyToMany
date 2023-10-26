package com.kubudirira.jdbcManyToMany.query;

public class UserQuery {

    public static final String SELECT_USER_QUERY = "SELECT * FROM users";
    public static final String SELECT_USER_BY_ID_QUERY = """
                                                        SELECT id, first_name, last_name, email  
                                                        FROM :user 
                                                        WHERE id = ?
                                                        """;
    public static final String INSERT_USER_QUERY = """
                                                    INSERT INTO Users(first_name,last_name,email)
                                                    VALUES (?,?,?)
                                                    """;
    public static final String DELETE_USER_QUERY = "DELETE FROM users WHERE id = ?";

    public static final String UPDATE_USER_QUERY = """
                                                    UPDATE Users  SET  first_name = ?, last_name = ?, email = ?
                                                    WHERE id = ?;
                                                    """;




}
