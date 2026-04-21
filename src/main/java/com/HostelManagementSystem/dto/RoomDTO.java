package com.HostelManagementSystem.dto;

import lombok.Data;

@Data
public class RoomDTO {
    private int id;
    private int roomNumber;
    private int capacity;
    private int currentOccupancy;
    private int studentCount;
}
