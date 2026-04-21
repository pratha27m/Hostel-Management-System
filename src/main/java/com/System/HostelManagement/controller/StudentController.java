package com.System.HostelManagement.controller;

import com.System.HostelManagement.dto.StudentDTO;
import com.System.HostelManagement.entity.Student;
import com.System.HostelManagement.service.StudentService;
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

//    @PutMapping("/{studentId}/assign/{roomId}")
//    public Student assignStudentToRoom(@PathVariable int studentId, @PathVariable int roomId){
//        return studentService.assignStudentToRoom(studentId,roomId);
//    }
//
//    @GetMapping("/{id}")
//    public Student getStudentById(@PathVariable int id){
//        return studentService.getStudentById(id);
//    }

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
