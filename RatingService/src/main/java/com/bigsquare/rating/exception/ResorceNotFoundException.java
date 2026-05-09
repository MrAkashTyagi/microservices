package com.bigsquare.rating.exception;

public class ResorceNotFoundException extends RuntimeException {

    public ResorceNotFoundException(){
        super("Rating with this id does not exists !!");
    }
    public ResorceNotFoundException(String msg){
        super(msg);
    }

}
