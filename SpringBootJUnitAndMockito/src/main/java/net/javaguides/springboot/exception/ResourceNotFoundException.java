package net.javaguides.springboot.exception;

//clasa creata care se ocupa de exceptii
public class ResourceNotFoundException extends RuntimeException{

    //constructor 1
    public ResourceNotFoundException(String message){
        //delegam mesajul clasei super, care este RuntimeException
        super(message);
    }
    //constructor 2
    public ResourceNotFoundException(String message,Throwable cause){
        //delegam mesajul clasei super, care este RuntimeException
        super(message, cause);
    }
}
