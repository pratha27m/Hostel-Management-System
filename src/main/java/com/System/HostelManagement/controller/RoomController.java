package com.System.HostelManagement.controller;

import com.System.HostelManagement.dto.RoomDTO;
import com.System.HostelManagement.entity.Room;
import com.System.HostelManagement.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rooms")
public class RoomController {

    @Autowired
    private RoomService roomService;

    @GetMapping
    public List<RoomDTO> getAllRooms(){

        return roomService.getAllRooms();
    }

    @GetMapping("/{id}")
    public Room getRoomById(@PathVariable int id){
        return roomService.getRoomById(id);
    }

    @DeleteMapping("/{id}")
    public String deleteRoom(@PathVariable int id){
        roomService.deleteRoom(id);
        return "Room deleted successfully";
    }

    @PostMapping
    public RoomDTO createRoom(@RequestBody Room room){
        return roomService.convertToDTO(roomService.createRoom(room));
    }
}
