package com.HostelManagementSystem.exception;

public class RoomFullException extends RuntimeException{
    public RoomFullException(String message){
        super(message);
    }
}
