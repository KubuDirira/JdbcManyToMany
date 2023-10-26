package com.kubudirira.jdbcManyToMany.exception;

public class ApiException extends RuntimeException{
    public ApiException(String message){
        super(message);
    }
}
