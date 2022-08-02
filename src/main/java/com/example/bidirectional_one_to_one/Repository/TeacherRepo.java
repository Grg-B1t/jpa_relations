package com.example.bidirectional_one_to_one.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.bidirectional_one_to_one.Entity.Teacher;
@Repository
public interface TeacherRepo extends JpaRepository<Teacher, Long>{
    
}
