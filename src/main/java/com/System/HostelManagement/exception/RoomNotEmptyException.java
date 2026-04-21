package com.System.HostelManagement.exception;

public class RoomNotEmptyException extends RuntimeException{
    public RoomNotEmptyException(String message){
        super(message);
    }
}
