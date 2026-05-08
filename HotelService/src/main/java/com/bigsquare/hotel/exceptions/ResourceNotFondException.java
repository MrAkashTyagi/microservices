package com.bigsquare.hotel.exceptions;

public class ResourceNotFondException extends RuntimeException {

    public ResourceNotFondException(){
        super("Resource that you are trying to find by this id does not exist !!");
    }

    public ResourceNotFondException(String msg){
        super(msg);
    }

}
