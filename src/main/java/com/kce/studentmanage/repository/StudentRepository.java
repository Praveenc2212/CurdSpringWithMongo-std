package com.kce.studentmanage.repository;

import com.kce.studentmanage.model.Student;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends MongoRepository<Student, String> {
    // You can add custom query methods if needed, like:
    Student findByEmail(String email);
}
