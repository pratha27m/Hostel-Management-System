package com.HostelManagementSystem.service;

import com.HostelManagementSystem.dto.StudentDTO;
import com.HostelManagementSystem.entity.Room;
import com.HostelManagementSystem.entity.Student;
import com.HostelManagementSystem.exception.RoomNotEmptyException;
import com.HostelManagementSystem.exception.RoomNotFoundException;
import com.HostelManagementSystem.exception.StudentNotFoundException;
import com.HostelManagementSystem.repository.RoomRepository;
import com.HostelManagementSystem.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private RoomRepository roomRepository;

    public Student addStudent(Student student){
        return studentRepository.save(student);
    }

    public void deleteStudent(int studentId){

        Student std= studentRepository.findById(studentId).orElseThrow(()-> new RuntimeException("Student not found"));

        Room room = std.getRoom();

        if(room != null){
            room.setCurrentOccupancy(room.getCurrentOccupancy() - 1);
            roomRepository.save(room);
        }

        studentRepository.delete(std);
    }

    public StudentDTO convertToDTO(Student student){
        StudentDTO dto = new StudentDTO();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setEmail(student.getEmail());

        if(student.getRoom()!=null){
            dto.setRoomId(student.getRoom().getId());
        }

        return dto;
    }

    public StudentDTO assignStudentToRoom(int studentId, int roomId){
        Student std = studentRepository.findById(studentId)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));
        Room room = roomRepository.findById(roomId)
                .orElseThrow(() -> new RoomNotFoundException("Room not found"));
        if(room.getCurrentOccupancy() >= room.getCapacity()){
            throw new RoomNotEmptyException("Room is full");
        }
        std.setRoom(room);
        room.setCurrentOccupancy(room.getCurrentOccupancy()+1);
        studentRepository.save(std);
        roomRepository.save(room);

        return convertToDTO(std);

    }

    public StudentDTO getStudentById(int id){
        Student std = studentRepository.findById(id)
                .orElseThrow(() -> new StudentNotFoundException("Student not found"));

        return convertToDTO(std);
    }
}
