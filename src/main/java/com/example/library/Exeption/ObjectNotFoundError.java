package com.example.library.Exeption;

public class ObjectNotFoundError extends Error {
    public ObjectNotFoundError(String message){
        System.out.println(message);
    }
}
