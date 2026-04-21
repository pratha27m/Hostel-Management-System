package com.HostelManagementSystem.controller;

import com.HostelManagementSystem.dto.StudentDTO;
import com.HostelManagementSystem.entity.Student;
import com.HostelManagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public Student addStudent(@RequestBody Student student){
        return studentService.addStudent(student);
    }

    @DeleteMapping("/{id}")
    public String deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
        return "Student deleted successfully";
    }

    @GetMapping("/{id}")
    public StudentDTO getStudentById(@PathVariable int id){
        return studentService.getStudentById(id);
    }

    @PutMapping("/{studentId}/assign/{roomId}")
    public StudentDTO assignStudentToRoom(@PathVariable int studentId, @PathVariable int roomId){
        return studentService.assignStudentToRoom(studentId,roomId);
    }
}
