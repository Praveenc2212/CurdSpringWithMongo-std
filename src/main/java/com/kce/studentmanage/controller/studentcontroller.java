package com.kce.studentmanage.controller;

import com.kce.studentmanage.model.Student;
import com.kce.studentmanage.repository.StudentRepository;
import com.kce.studentmanage.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/students")
public class studentcontroller {

    @Autowired
    private StudentService studentService;


    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.addStudents(student);
    }


    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get a student by ID
    @GetMapping("/findbyemail/{email}")
    public Student getStudentById(@PathVariable String email) {
        return studentService.getStudentByEmail(email);
    }

    @PutMapping("/{id}")
    public Student updateStudent(@PathVariable String id , @RequestBody Student student){
        Student std = studentService.findById(id);
        std.setName(student.getName());
        std.setEmail(student.getEmail());
        studentService.addStudents(std);
        return std;
    }
    @GetMapping("findbyid/{id}")
    public Student finById(@PathVariable String id){
        return studentService.findById(id);
    }
    @DeleteMapping("/{id}")
    public String deteStudent(@PathVariable String id){
        studentService.deleteById(id);
        return "Student deleted";

    }

}
