package com.bigsquare.user.service.exceptions;

public class ResourceNotfoundException extends RuntimeException{

//    extra properties that you want to manage

   public ResourceNotfoundException(){
        super("Resource not found on server");
    }

   public ResourceNotfoundException(String msg){
        super(msg);
    }

}
