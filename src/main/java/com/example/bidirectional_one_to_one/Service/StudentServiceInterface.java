package com.example.bidirectional_one_to_one.Service;

import java.util.List;

import com.example.bidirectional_one_to_one.Entity.Student;

public interface StudentServiceInterface {
    List<Student> getAllStudents();
    Student addStudent(Student newStudent);
    String removeStudentById(Long studentId);
    Student updateStudentById(Student student);
}
