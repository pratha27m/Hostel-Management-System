package com.System.HostelManagement.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToMany(mappedBy = "room")
    @JsonManagedReference
    private List<Student> students;
    private int roomNumber;
    private int capacity;
    private int currentOccupancy;
}
