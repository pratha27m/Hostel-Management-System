package com.System.HostelManagement.service;

import com.System.HostelManagement.dto.RoomDTO;
import com.System.HostelManagement.entity.Room;
import com.System.HostelManagement.exception.RoomNotEmptyException;
import com.System.HostelManagement.exception.RoomNotFoundException;
import com.System.HostelManagement.repository.RoomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoomService {

    @Autowired
    private RoomRepository roomRepository;

    public Room createRoom(Room room){
        room.setCurrentOccupancy(0);
        return roomRepository.save(room);
    }
    public List<RoomDTO> getAllRooms(){
        return roomRepository.findAll()
                .stream().map(this::convertToDTO).toList();
    }

    public Room getRoomById(int id){
        return roomRepository.findById(id).orElseThrow(()-> new RoomNotFoundException("Room not found"));
    }

    public void deleteRoom(int roomId){

        Room room =roomRepository.findById(roomId).orElseThrow(()-> new RoomNotFoundException("Room not found"));

        if(room.getCurrentOccupancy() > 0){
            throw new RoomNotEmptyException("Room is not empty");
        }

        roomRepository.delete(room);
    }

    public RoomDTO convertToDTO(Room room){
        RoomDTO dto = new RoomDTO();
        dto.setId(room.getId());
        dto.setRoomNumber(room.getRoomNumber());
        dto.setCapacity(room.getCapacity());
        dto.setCurrentOccupancy(room.getCurrentOccupancy());
        dto.setStudentCount(room.getStudents().size());

        return dto;
    }
}
