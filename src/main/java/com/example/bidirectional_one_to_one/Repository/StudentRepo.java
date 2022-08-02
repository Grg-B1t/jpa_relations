package com.example.bidirectional_one_to_one.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bidirectional_one_to_one.Entity.Student;
@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
    
}
