package com.kce.studentmanage.interfaces;

import com.kce.studentmanage.model.Student;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface StudentServices {

    Student addStudents(Student student);
    List<Student> getAllStudents();
    ResponseEntity<?> findById(String id);
    Student getStudentByEmail(String email);
    void deleteById(String id);
}
