package com.thoughtworks.capability.gtb.restfulapidesign.exception;

/**
 * Created by wzw on 2020/9/13.
 */
public class StudentException extends Exception{
    String message;
    public StudentException(String message){
        this.message = message;
    }
}
