package com.kce.studentmanage.service;

import com.kce.studentmanage.exceptions.StudentNotFoundException;
import com.kce.studentmanage.model.Student;
import com.kce.studentmanage.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student addStudents(Student student) {
        return studentRepository.save(student);
    }

    public List<Student> getAllStudents(){
        List<Student>  students =  studentRepository.findAll();

        return students;
    }
    public Student findById(String id){
        Optional<Student> student = studentRepository.findById(id);
        return student.get();
    }
    public Student getStudentByEmail(String email){

       return  studentRepository.findByEmail(email);

    }
    public void deleteById(String id){
        studentRepository.deleteById(id);
    }


}
