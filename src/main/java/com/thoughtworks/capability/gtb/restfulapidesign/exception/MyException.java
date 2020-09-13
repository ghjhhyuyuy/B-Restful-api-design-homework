package com.thoughtworks.capability.gtb.restfulapidesign.exception;

/**
 * Created by wzw on 2020/9/13.
 */
public class MyException extends Exception{
    String message;
    public MyException(String message){
        this.message = message;
    }
}
